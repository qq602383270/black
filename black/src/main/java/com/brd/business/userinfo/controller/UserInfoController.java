package com.brd.business.userinfo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.brd.business.userinfo.domain.UserInfo;
import com.brd.business.userinfo.service.UserInfoService;
import com.commons.controller.BaseController;
import com.commons.web.SpringUtil;
import com.utils.Cookies;


@Controller
@RequestMapping("userInfo")
public class UserInfoController extends BaseController {
	@Autowired
	UserInfoService userInfoService;

	@RequestMapping("/getAllUserInfo")
	public ModelAndView getAllUserInfo(HttpServletRequest request, HttpServletResponse reponse) {

		ModelAndView mav = new ModelAndView("userInfo/list");
		long time1 = System.currentTimeMillis();
		List<Map<String, Object>> listMap = userInfoService.selectCityList(null);
		System.out.println("mybaits执行时长：" + (System.currentTimeMillis() - time1));
		mav.addObject("listMap", listMap);

		long time2 = System.currentTimeMillis();
		List<UserInfo> userInfoList = userInfoService.getAllUserInfo_DAO();
		System.out.println("jdbcTemplete执行时长：" + (System.currentTimeMillis() - time2));

		mav.addObject("userInfoList", userInfoList);

		System.out.println("-------------------------------");
		return mav;
	}

	@RequestMapping("/insert")
	@ResponseBody
	@Transactional
	public String insert(HttpServletRequest request, HttpServletResponse reponse, UserInfo userInfo) {
		request.getParameter("realname");

		userInfoService.inset_DAO(userInfo);
		
		System.out.println("成功执行");
		try {
			reponse.sendRedirect("getAllUserInfo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{}";
	}

	@RequestMapping("/userLogin")
	public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse reponse) {
		ModelAndView mav = new ModelAndView("index");
		Map<String, Object> params = new HashMap<String, Object>();
		setRequest(request);
		initParamsMap(params);

		UserInfo userInfo = userInfoService.userLogin(params);
		if (userInfo != null) {
			request.getSession().setAttribute("userInfo", userInfo);
			Cookies.addCookies(reponse, "userName", userInfo.getUsername());
		} else {
			mav.setViewName("login");
			mav.addObject("username", params.get("username"));
			mav.addObject("password", params.get("password"));
		}
		return mav;
	}
	@RequestMapping("/delteAll")
	public ModelAndView delteAll(HttpServletRequest request, HttpServletResponse reponse) {
		ModelAndView mav = new ModelAndView("index");
		int  count=userInfoService.findAll();
		mav.addObject("count", count);
		return mav;
	}

}
