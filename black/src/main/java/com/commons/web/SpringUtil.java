package com.commons.web;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


@Component
public class SpringUtil implements ApplicationContextAware {
	private static ServletContext servletContext;
	private static ApplicationContext applicationContext;

	public static void setServletContext(ServletContext servletContext) {
		SpringUtil.servletContext = servletContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		
		
		SpringUtil.applicationContext = arg0;
	}

	/**
	 * get project ApplicationContext
	 *
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * get project ServletContext
	 *
	 * @return
	 */
	public static ServletContext getServletContext() {
		return servletContext;
	}

	/**
	 * get bean with name
	 *
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	/**
	 * get bean with class type
	 *
	 * @param name
	 * @return
	 */
	public static Object getBean(Class<?> type) {
		return applicationContext.getBean(type);
	}

	/**
	 * get attribute from servletContext
	 *
	 * @param name	参数名称
	 * @return
	 */
	public static Object getServleContextAttribute(String name) {
		return servletContext.getAttribute(name);
	}

	/**
	 * set attribute to servletContext
	 *
	 * @param name	参数名称
	 * @param object	值
	 */
	public static void setServleContextAttribute(String name, Object object) {
		servletContext.setAttribute(name, object);
	}

	/**
	 * publish event
	 * @param event	事件
	 */
	public static void publishEvent(ApplicationEvent event) {
		applicationContext.publishEvent(event);
	}

}
