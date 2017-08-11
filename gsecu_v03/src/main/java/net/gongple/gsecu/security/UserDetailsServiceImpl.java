package net.gongple.gsecu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.gongple.gsecu.domain.User;
import net.gongple.gsecu.service.UserService;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired UserService usrSvc;
	
	@Override
	public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("### username : "+ username);
		
		User user = usrSvc.findByUserName(username);
		
		UserDetailsImpl userDetails = new UserDetailsImpl();
		userDetails.setUserid(user.getUserName());
		userDetails.setUserpw(user.getPassword());
		userDetails.setAuth(user.getAuths());
		
		return userDetails;
	}
	
}
