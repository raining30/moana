package lab.io.rush.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/***
 * 
 * @author jd.zeng
 * @create date 2016年12月25日
 *
 */

@Controller
public class IndexController {
	
	@RequestMapping("/")    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView("login"); 
        return mav; 
    }
	
	@RequestMapping("/single")    
    public ModelAndView getSingle(){      
        ModelAndView mav = new ModelAndView("single"); 
        return mav; 
    }
	
	@RequestMapping("/account")    
    public ModelAndView getAccount(){      
        ModelAndView mav = new ModelAndView("account"); 
        return mav; 
    }

}
