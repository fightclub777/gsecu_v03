#gsecu_v0.3

1. 개요.
	gsecu_v0.3은 security-context.xml의 사용자 정보 설정을 이용하지 않고, 
	DB를 조회하여 인증하도록 커스터마이징 한다.

2. 목표.
	1) 로그인 시 DB를 조회하여 사용자 ID, PASSWORD를 가져와 
	사용자가 인증화면에서 입력한 ID, PASSWORD와 비교하여 인증하도록 커스터마이징. 
      
3. 주요내용.
	Spring Security에서 DB연동을 위한 커스터마이징을 하려면 우선 눈여겨 봐야할 것은
	"UserDetails", "UserDetailsService", "GrantedAuthority" 세가지 인터페이스이다.
	즉, 이 세가지 인터페이스를 구현하는 클래스를 작성해야 하는 것이다.

	3.1. 
		1) UserDetails
			: Spring Security에서는 이 인터페이스를 구현한 클래스를 
			사용자 정보라고 파악한다.
			
		2) UserDetailsService
			: 
		
		3) GrantedAuthority
			: 
		
		2) UserDetailsService
			: 
			
		3) AuthenticationProvider
			: 
			
		
4. 추가내용.
	4.1. 
		1) 
			: 
		
		2) 
			: 
			
	4.2. 
		1) 
