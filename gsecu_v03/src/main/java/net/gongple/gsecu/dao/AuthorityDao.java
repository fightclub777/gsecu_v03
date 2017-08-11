package net.gongple.gsecu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.gongple.gsecu.domain.Authority;

public interface AuthorityDao extends JpaRepository<Authority, Long> {
	
	Authority findByAuthCode(String authCode);
}
