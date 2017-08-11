package net.gongple.gsecu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.gongple.gsecu.domain.User;

public interface UserDao extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);
	
}
