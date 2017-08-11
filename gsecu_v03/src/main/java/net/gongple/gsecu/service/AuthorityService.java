package net.gongple.gsecu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.gongple.gsecu.dao.AuthorityDao;
import net.gongple.gsecu.domain.Authority;

@Service
@Transactional
public class AuthorityService {
	
	@Autowired private AuthorityDao authDao;
	
	public Authority add(Authority auth) {
		return authDao.save(auth);
	}
	
	public Authority findById(Long id) {
		return authDao.findOne(id);
	}
	
	public Authority findByAuthCode(String authCode) {
		return authDao.findByAuthCode(authCode);
	}
	
	public List<Authority> findAll() {
		return authDao.findAll();
	}
	
}
