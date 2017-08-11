package net.gongple.gsecu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authority")
@TableGenerator(name = "base_id_sequence", table = "id_sequences", 
	pkColumnName = "id_type", pkColumnValue= "BASE", allocationSize = 1)
public class Authority implements GrantedAuthority {
	
	private static final long serialVersionUID = -6421531863094533496L;

	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "base_id_sequence")
	@Column(name = "auth_id")
	private Long authId;
	
	@Column(name = "auth_code", nullable = false)
	private String authCode;
	
	@Column(name = "auth_name", nullable = false)
	private String authName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@Override
	public String getAuthority() {
		return getAuthCode();
	}
	
	//--- constructor ---//
	public Authority() {}
	
	//--- relation ---//
	public void setUser(User user) {
		this.user = user;
		user.getAuths().add(this);
	}
	
	//--- setter, getter ---//
	public Long getAuthId() {
		return authId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public User getUser() {
		return user;
	}
	
}
