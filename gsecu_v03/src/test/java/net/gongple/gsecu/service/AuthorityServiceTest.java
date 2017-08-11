package net.gongple.gsecu.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.gongple.gsecu.domain.Authority;
import net.gongple.gsecu.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/root-context.xml")
public class AuthorityServiceTest {
	
	@Autowired AuthorityService authSvc;
	
	private List<Authority> makeInputData() {
		List<Authority> inputDatas = new ArrayList<Authority>();
		
		Authority auth = new Authority();
		User user = new User();
		user.setUserId(new Long(1004));
		auth.setUser(user);
		auth.setAuthCode("ROLE_H_ADMIN");
		auth.setAuthName("최고관리자");
		inputDatas.add(auth);
		
		auth = new Authority();
		user = new User();
		user.setUserId(new Long(1005));
		auth.setUser(user);
		auth.setAuthCode("ROLE_M_ADMIN");
		auth.setAuthName("중간관리자");
		inputDatas.add(auth);
		
		auth = new Authority();
		user = new User();
		user.setUserId(new Long(1006));
		auth.setUser(user);
		auth.setAuthCode("ROLE_L_ADMIN");
		auth.setAuthName("실무관리자");
		inputDatas.add(auth);
		
		auth = new Authority();
		user = new User();
		user.setUserId(new Long(1007));
		auth.setUser(user);
		auth.setAuthCode("ROLE_USER");
		auth.setAuthName("사용자");
		inputDatas.add(auth);
		
		return inputDatas;
	}
	
	@Test
	public void Auth입력() throws Exception {
		List<Authority> inputData = makeInputData();
		System.out.println("@@@ inputData - Size : "+ inputData.size());
		
		for(Authority auth : inputData) {
			System.out.println("@");
			System.out.println("@ Id: "+ auth.getAuthId() +", AuthCode: "+ auth.getAuthCode() +", AuthName: "+ auth.getAuthName());
			authSvc.add(auth);
		}
		
		List<Authority> auths = authSvc.findAll();
		for(Authority auth : auths) {
			System.out.println("#");
			System.out.println("# Id: "+ auth.getAuthId() +", AuthCode: "+ auth.getAuthCode() +", AuthName: "+ auth.getAuthName());
		}
	}
}
