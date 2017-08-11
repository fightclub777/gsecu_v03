package net.gongple.gsecu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.gongple.gsecu.dao.UserDao;
import net.gongple.gsecu.domain.User;

@Service
@Transactional
public class UserService {
	
	@Autowired private UserDao usrDao;
	
	public User add(User user) {
		System.out.println("### UserService - user.toString() : "+ user.toString());
		return usrDao.save(user);
	}
	
	public User findById(Long id) {
		return usrDao.findOne(id);
	}
	
	public User findByUserName(String userName) {
		return usrDao.findByUserName(userName);
	}
	
	public List<User> findAll() {
		return usrDao.findAll();
	}
	
}
