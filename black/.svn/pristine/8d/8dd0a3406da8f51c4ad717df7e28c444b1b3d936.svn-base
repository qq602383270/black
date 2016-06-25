/**
 *
 */
package com.commons.interceptor;

import java.util.HashMap;

import org.apache.log4j.Logger;


/**
 * log util
 * 日志级别由高到低：ERROR WARN INFO DEBUG
 * @author wangBin
 * @date 2015年6月9日 上午午11:03:14
 *
 */
public class LogUtil {
	// 定义一个全局的记录器，通过Logger获取
	private static HashMap<Class<?>, Logger> logMap = new HashMap<Class<?>, Logger>();
	
	public static Logger getLogger(Class<?> clazz) {
		Logger logger = logMap.get(clazz);
		if(logger == null){
			logger = Logger.getLogger(clazz);
			logMap.put(clazz, logger);
		}
		return logger;
	}

	public static void debug(Class<?> clazz, String msg) {
		getLogger(clazz).debug(msg);
	}
	
	public static void info(Class<?> clazz, String msg) {
		getLogger(clazz).info(msg);
	}
	
	public static void error(Class<?> clazz, String msg) {
		getLogger(clazz).error(msg);
	}
	
	public static void warn(Class<?> clazz, String msg) {
		getLogger(clazz).warn(msg);
	}
}
