#gsecu_v0.3

1. 개요.
	gsecu_v0.3은 security-context.xml의 <authentication-provider>의 사용자 정보 설정을 이용하지 않고, 
	사용자 인증을 담당하는 클래스를 만들어 이를 통해 사용자를 인증하도록 커스터마이징 한다.

2. 목표.
	1) 인증을 담당하는 UserDetails, UserDetailsService 인터페이스를 구현하는 클래스를 작성한다.
	2) v0.2에서 <authentication-provider>의 <user-service>태그에 기술했던 
		사용자 정보는 UserDetailsService 구현 클래스에 코딩하도록 한다. 
	3) <authentication-provider>가 UserDetailsService 구현 클래스를 참조해 인증을 성공시킨다.  
      
3. 주요내용.
	Spring Security의 사용자 정보를 담당하는 인터페이스인 UserDetails 의 구현 클래스를 작성한다.
	권한을 담당하는 인터페이스인 GrantedAuthority 의 구현 클래스를 작성한다.
	사용자 인증을 담당하는 인터페이스인 UserDetailsService 의 구현 클래스를 작성한다.
	
	3.1. Spring Security의 인증 과정.
		: Spring Security는 인증 과정이 시작되면, 
		UserDetailsService 구현 클래스의 loadUserByUsername(String username) 메소드를 호출한다.
		사용자가 인증화면에서 입력한 아이디의 입력 값은 
		loadUserByUsername(String username) 메소드의 파라메터인 username으로 전달되게 된다.
		
		username으로 전달받은 아이디를 가지고 사용자 데이터(인증이 허가된 사용자 데이터)를 검색하여 
		동일한 아이디가 있는지 확인하고 만약 있다면,  
		미리 생성해 둔 UserDetails 구현 클래스에 검색된 동일한 아이디의 정보를 채워넣어 반환한다.
		(여기까지는 사용자가 입력한 아이디의 사용자 정보를 찾는 과정)
		
		그렇게 사용자 정보를 채워넣은 UserDetails를 loadUserByUsername() 메소드가
		반환하게 되어 인증여부(아이디와 비밀번호가 맞는지)를 판정한다.
		(찾아낸 사용자 정보를 통해, 인증화면에서 입력된 아이디,비번과 맞는지 체크한다.)
		여기서, <authentication-provider>의 역할은 바로 이 아이디 비번이 맞는지 판정하는 것이다.
		추후, 비번 체크를 <authentication-provider>에 의존하지 않고 커스터마이징을 하려면
		<authentication-provider>에 참조 클래스를 적어넣는다.
		즉, AuthenticationProvider 인터페이스를 구현하는 CustomAuthenticationProvider 클래스를
		작성한 뒤에 해당 클래스를 bean으로 등록하고, 등록한 bean아이디를 다음과 같이
		<authentication-provider ref="bean아이디"> ref에 적어넣어 참조하도록 한다.
		이 부분은 v0.5에서 자세하게 다루겠다.

	3.2. 인터페이스 설명.
		1) UserDetailsService
			: 인증의 시작인 loadUserByUsername(String username) 메소드를 구현해야한다.
		
		2) UserDetails
			: 이 인터페이스를 구현한 클래스를 사용자 정보라고 파악한다.
			여기서 사용자 정보는 인증화면에서 사용자가 입력한 정보가 아니라
			DB에서 조회한 사용자 정보를 뜻한다.
			즉, DB에서 사용자 정보를 조회한 뒤 UserDetails에 채워줘야
			인증화면에서 사용자가 입력한 정보와 비교할 수 있게 된다.
			
			# getUserName() : 계정의 이름을 리턴한다.
			# getPassword() : 계정의 패스워드를 리턴한다.
			# getAuthorities() : 계정이 갖고 있는 권한 목록을 리턴한다.
			
			# isAccountNonExpired() 
				: 계정이 만료되지 않았는지를 리턴한다.
				(true를 리턴하면 만료되지 않음)
			# isAccountNonLocked()
				: 계정이 잠겨있지 않은지를 리턴한다.
				(true를 리턴하면 잠겨있지 않음) 
			# isCredentialsNonExpired()
				: 계정의 패스워드가 만료되지 않은지를 리턴한다.
				(true를 리턴하면 만료되지 않음)
			# isEnabled()
				: 계정이 사용가능한 계정인지를 리턴한다.
				(true를 리턴하면 사용가능한 계정) 
		
		3) GrantedAuthority
			: Spring Security의 사용자는 '인증정보'와 함께 반드시 '권한'을 갖게 된다.
			인증한 사용자가 어떤 권한을 갖게 될 것인지를 정의해야 하는 것이다.
			권한은 getAuthority() 메소드에 구현한다.
			즉, 권한을 담당하는 클래스는 GrantedAuthority 인터페이스를 구현하도록 정의하고, 
			getAuthority()에서 권한 데이터를 반환해야 한다.
		
