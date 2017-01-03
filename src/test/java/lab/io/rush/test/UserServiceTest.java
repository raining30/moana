package lab.io.rush.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lab.io.rush.base.*;
import lab.io.rush.dao.UserDao;
import lab.io.rush.model.User;
import lab.io.rush.service.UserService;
/***
 * 
 * @author jd.zeng
 * @create date 2016年12月24日
 *
 */

public class UserServiceTest extends SpringTestCase{
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao dao;
	
	//@Test
	public void userDaoTest(){
		User user = dao.selectUserById(1);
		System.out.println(user.getUcount());
		System.out.println(user.getUpassword());
	}
	
	//@Test
	public void UserSelectTest(){
		User user = userService.selectUserbyID(1);
		System.out.println(user.getUcount());
		System.out.println(user.getUpassword());
	}
	
	@Test
	public void userInsertTest(){
		User user = new User();
		user.setUcount("rain");
		user.setUpassword("987654");
		
		try {
			int result = userService.insertUser(user);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("insert fail");
		}
		
	}
	
	//@Test 
	public void userDaoInsertTest(){
		User user = new User();
		user.setUcount("test");
		user.setUpassword("1230");
		int result = dao.insertUser(user);
		System.out.println(result);
	}
	
	//@Test
	public void userUpdateTest(){
		User user = new User();
		user.setUid(1);
		user.setUcount("test");
		user.setUpassword("1230");
		
		userService.updateUser(user);
		System.out.println("update sucess");
		UserSelectTest();
	}
	
	//@Test
	public void userSelectAllTest(){
		System.out.println("select all start...");
		List<User> users = userService.selectAll();
		for(User atom : users){
			System.out.println(atom.getUcount());
		}
		System.out.println("select all end.");
	}
	
	//@Test
	public void userDeleteTest(){
		userSelectAllTest();
		userService.deleteUser(12);
		userSelectAllTest();
	}
	
	//@Test
	public void selectUserByCountTest(){
		User user = userService.selectUserbyCount("rain");
		System.out.println(user.getUcount());
		System.out.println(user.getUpassword());
	}

}
