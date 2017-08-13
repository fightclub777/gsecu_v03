package net.gongple.gsecu.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;
	
	private String role;
	
	@Override
	public String getAuthority() {
		return getRole();
	}
	
	//--- constructor ---//
	public Authority() {}
	
	public Authority(String role) {
		setRole(role);
	}
	
	//--- setter, getter ---//
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
