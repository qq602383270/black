package com.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies {
	public static void addCookies(HttpServletResponse response,String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(12 * 1000 * 60 * 60);
		response.addCookie(cookie);
	}
	
	public static Cookie getCookieByName(HttpServletRequest request,String name){
		Map<String,Cookie> cookieMap = new HashMap<>();
		
		Cookie[] cookies = request.getCookies();
		  if(null!=cookies){
		    for(Cookie cookie : cookies){
		     cookieMap.put(cookie.getName(), cookie);
		    }
		  }
		  
	    if(cookieMap.containsKey(name)){
	      Cookie cookie = (Cookie)cookieMap.get(name);
	      return cookie;
	    }else{
	      return null;
	    } 
	    }
}
