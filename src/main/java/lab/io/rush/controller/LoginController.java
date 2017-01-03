package lab.io.rush.controller;

import lab.io.rush.model.User;
import lab.io.rush.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月26日
 *
 */
@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/checkuser")
	@ResponseBody
	public int checkUser(String ucount, String password){
		
		ModelAndView mav = new ModelAndView("single");
		User user = userService.selectUserbyCount(ucount);
		
		if(user == null){
			System.out.println("fail");
			return 0;
		}
		
		if (user.getUpassword().equals(password)) {
			mav.addObject("ucount", ucount);
			System.out.println("success");
			return 1;
		} else {
			System.out.println("fail");
			return 0;

		}
		
	}

}
