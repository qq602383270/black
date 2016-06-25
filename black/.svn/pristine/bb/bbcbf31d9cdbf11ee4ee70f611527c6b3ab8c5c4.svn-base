package com.commons.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		//请求地址
		String requestUrl = request.getRequestURI(); 
		System.out.println("requestUrl="+requestUrl);
		
		responseLogOut(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 向前端输出登陆异常
	 * @param request
	 * @param response
	 */
	public void responseLogOut(HttpServletRequest request,HttpServletResponse response){
		try {
			//请求方式
			String requestType = request.getHeader("X-Requested-With");
			if (requestType != null && requestType.equals("XMLHttpRequest")) {
				// AJAX
				response.setHeader("sessionstatus", "timeout");
			} else {
				// FORM SUBMIT
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
			request.getSession().invalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
