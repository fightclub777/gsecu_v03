package net.gongple.gsecu.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.gongple.gsecu.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/root-context.xml")
public class UserServiceTest {
	
	@Autowired UserService usrSvc;
	
	private List<User> makeInputData() {
		List<User> inputDatas = new ArrayList<User>();
		User user = new User();
		user.setUserName("adminh");
		user.setPassword("1234h");
		inputDatas.add(user);
		
		user = new User();
		user.setUserName("adminm");
		user.setPassword("1234m");
		inputDatas.add(user);
		
		user = new User();
		user.setUserName("adminl");
		user.setPassword("1234l");
		inputDatas.add(user);
		
		user = new User();
		user.setUserName("user");
		user.setPassword("1234u");
		inputDatas.add(user);
		
		return inputDatas;
	}
	
	@Test
	public void User입력() throws Exception {
		List<User> inputData = makeInputData();
		System.out.println("@@@ inputData - Size : "+ inputData.size());
		
		for(User user : inputData) {
			System.out.println("@");
			System.out.println("@ Id: "+ user.getUserId() +", UserName: "+ user.getUserName() +", PassWord: "+ user.getPassword());
			usrSvc.add(user);
		}
		
		List<User> users = usrSvc.findAll();
		for(User user : users) {
			System.out.println("#");
			System.out.println("# Id: "+ user.getUserId() +", UserName: "+ user.getUserName() +", PassWord: "+ user.getPassword());
		}
	}
}
