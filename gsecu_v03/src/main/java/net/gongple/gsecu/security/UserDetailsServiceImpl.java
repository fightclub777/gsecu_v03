package net.gongple.gsecu.security;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Override
	public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsImpl userDetails = new UserDetailsImpl();
		
		List<UserDetailsImpl> usersData = new Users().getUsers();
		
		for(UserDetailsImpl userData : usersData) {
			if(userData.getUsername().equals(username)) {
				userDetails = userData;
			}
		}
		
		return userDetails;
	}
	
}
