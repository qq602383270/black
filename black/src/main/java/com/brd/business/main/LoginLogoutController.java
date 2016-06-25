package com.brd.business.main;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;  
  
@Controller  
@RequestMapping("auth")  
public class LoginLogoutController {  
  
    protected static Logger logger = Logger.getLogger("controller");  
  
    /** 
     * 指向登录页面 
     */  
    @RequestMapping(value = "/login")  
    public String getLoginPage(  
            @RequestParam(value = "error", required = false) boolean error,  
            ModelMap model) {  
  
        logger.debug("Received request to show login page");  
  
        if (error == true) {  
            // Assign an error message  
            model.put("error",  
                    "You have entered an invalid username or password!");  
        } else {  
            model.put("error", "");  
        }  
        return "loginpage";  
  
    }  
  
    /** 
     * 指定无访问额权限页面 
     *  
     * @return 
     */  
    @RequestMapping(value = "/denied")  
    public String getDeniedPage() {  
  
        logger.debug("Received request to show denied page");  
  
        return "deniedpage";  
  
    }  
}  