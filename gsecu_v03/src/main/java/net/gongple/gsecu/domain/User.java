package net.gongple.gsecu.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "user")
@TableGenerator(name = "base_id_sequence", table = "id_sequences", 
	pkColumnName = "id_type", pkColumnValue= "BASE", allocationSize = 1)
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "base_id_sequence")
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "username", nullable = false)
	private String userName;
	
	@Column(name = "passwd", nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Authority> auths = new ArrayList<Authority>();
	
	//--- constructor ---//
	public User() {}
	
	
	//--- setter, getter ---//
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Authority> getAuths() {
		return auths;
	}

	public void setAuths(List<Authority> auths) {
		this.auths = auths;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", auths=" + auths
				+ "]";
	}
	
}
