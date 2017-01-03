package lab.io.rush.controller;

import java.util.HashMap;
import java.util.Map;

import lab.io.rush.model.User;
import lab.io.rush.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月26日
 *
 */
@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	@ResponseBody
	public int userRegister(User user){
		int result = 0;
		try {
			userService.insertUser(user);
			result = 1;
		} catch (Exception e) {
			System.out.println(e);
			result = 0;
		}
				
		return result;
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public Map<String, Integer> justTest(String ucount, String password){
		System.out.println(ucount);
		System.out.println(password);
		System.out.println("succeed");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("test1", 123);
		map.put("test2", 456);
		return map;
	}
	
	@RequestMapping("test2")
	@ResponseBody
	public Map<String, Integer> test2(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("test1", 123);
		map.put("test2", 456);
		return map;
	}
	
	@RequestMapping("test3")
	@ResponseBody
	public String test3(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("test1", 123);
		map.put("test2", 456);
		return "hello";
	}

}
