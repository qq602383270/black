package com.commons.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.commons.web.SpringUtil;

public class StartupListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("执行了初始化项目名称保存");
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("projectpath", sc.getContextPath());
		SpringUtil.setServletContext(sc);
		
	}

}
