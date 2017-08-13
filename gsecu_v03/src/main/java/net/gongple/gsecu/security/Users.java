package net.gongple.gsecu.security;

import java.util.ArrayList;
import java.util.List;

public class Users {
	
	private List<UserDetailsImpl> users = new ArrayList<UserDetailsImpl>();
	
	public Users() {
		for(int i = 1; i <= 5; i++) {
			UserDetailsImpl user = new UserDetailsImpl();
			user.setUserid("user"+ i);
			user.setUserpw("pwd"+ i);
			List<Authority> auths = new ArrayList<Authority>();
			switch(i) {
			case 1 : 
				auths.add(new Authority("ROLE_H_ADMIN"));
				break;
			case 2 :
				auths.add(new Authority("ROLE_M_ADMIN"));
				break;
			case 3 :
				auths.add(new Authority("ROLE_L_ADMIN"));
				break;
			case 4 :
				auths.add(new Authority("ROLE_USER"));
				break;
			case 5 : 
				auths.add(new Authority("ROLE_L_ADMIN"));
				auths.add(new Authority("ROLE_USER"));
			}
			user.setAuths(auths);
			users.add(user);
		}
	}

	public List<UserDetailsImpl> getUsers() {
		return users;
	}
	
}
