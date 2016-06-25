package com.brd.business.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller  
	@RequestMapping("/main")  
	public class MainController {  
	  
	    /** 
	     * 跳转到commonpage页面 
	     *  
	     * @return 
	     */  
	    @RequestMapping(value = "/common")  
	    public String getCommonPage() {  
	       System.out.println("Received request to show common page");  
	        return "commonpage";  
	    }  
	  
	    /** 
	     * 跳转到adminpage页面 
	     *  
	     * @return 
	     */  
	    @RequestMapping(value = "/admin")  
	    public String getAadminPage() {  
	    	 System.out.println("Received request to show admin page");  
	        return "adminpage";  
	  
	    }  
}
