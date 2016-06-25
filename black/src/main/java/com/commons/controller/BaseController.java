package com.commons.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.brd.business.userinfo.domain.UserInfo;
import com.commons.interceptor.LogUtil;

@Controller
public class BaseController extends RequestResponseContext  {



	@RequestMapping(value = { "/", "/index" })
	public ModelAndView index(HttpServletRequest request, HttpServletResponse reponse) {
		ModelAndView mav = new ModelAndView("index");
	
		
		return mav;
	}
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request,HttpSession session, HttpServletResponse reponse) {
		ModelAndView mav = new ModelAndView("login");
		
		UserInfo userinfo=(UserInfo) session.getAttribute("userInfo");	
		if(userinfo!=null){
			mav.setViewName("index");
			
		}
		return mav;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = {"/jsp/**/*.do","/jsp/**"})
	protected ModelAndView showLogin(HttpServletRequest request) {
		// 请求的url
		String url = request.getRequestURI();
		try {
			int startIndex = url.indexOf("jsp/") + "jsp/".length();
			int endIndex=0;
			if(url.indexOf(".")>0){
				endIndex = url.indexOf(".do") > 0 ? url.indexOf(".do") : 0;
			}
			else{
				endIndex=url.length();
			}
			url = url.substring(startIndex, endIndex);
			LogUtil.info(getClass(), "请求地址：" + url);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.error(getClass(), e.getMessage());
		}
		return new ModelAndView(url).addAllObjects(request.getParameterMap());
	}
}
