/**
 *
 */
package com.commons.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * @link http://www.oschina.net/question/274766_101880?sort=time
 * @author WangBin
 *
 * @Company: 百信金融
 *
 * 2015年6月9日 上午11:38:53
 */
public class RequestResponseContext extends MapUtils{
	private static Logger logger = Logger.getLogger(RequestResponseContext.class);
	
	private static ThreadLocal<HttpServletRequest> request_threadLocal = new ThreadLocal<HttpServletRequest>();

	private static ThreadLocal<HttpServletResponse> reponse_threadLocal = new ThreadLocal<HttpServletResponse>();

	public static void setRequest(HttpServletRequest request) {
		request_threadLocal.set(request);
	}

	public static HttpServletRequest getRequest() {
		return request_threadLocal.get();
	}

	public static void removeRequest() {
		request_threadLocal.remove();
	}

	public static void setResponse(HttpServletResponse response) {
		reponse_threadLocal.set(response);
	}

	public static HttpServletResponse getResponse() {
		return reponse_threadLocal.get();
	}

	public static void removeResponse() {
		reponse_threadLocal.remove();
	}
	////////--------------------------request---------------------------------
	/**
	 * get string value from request
	 * @param name	参数名称
	 * @return
	 */
	public static String getStrPameter(String name) {
		return getStrPameter(name, null);
	}
	/**
	 * 根据参数名称，获取request作用于中值，返回Integer
	 * @param name	参数名称
	 * @param strDefault	如果获取的值为空，则返回该默认值
	 * @return	String
	 */
	public static String getStrPameter(String name,String strDefault) {
		HttpServletRequest request=getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		String value = request.getParameter(name);
		value = "".equals(value) ? strDefault : value;
		return value;
	}

	/**
	 * set value to request
	 * @param name	参数名称
	 * @param value	值
	 */
	public static void setObjPameter(String name,Object value) {
		getRequest().setAttribute(name, value);
	}


	/**
	 * get Integer value from request
	 * @param name	参数名称
	 * @return
	 */
	public static Integer getIntPameter(String name) {
		return getIntPameter(name, null);
	}
	/**
	 * 根据参数名称，获取request作用于中值,返回Integer
	 * @param name	参数名称
	 * @param iDefault	如果获取的值为空，则返回该默认值
	 * @return Integer
	 */
	public static Integer getIntPameter(String name,Integer iDefault) {
		String value = getStrPameter(name);
		return !StringUtils.isBlank(value) ? Integer.valueOf(value) : iDefault;
	}
	/**
	 * get Short value from request
	 * @param name	参数名称
	 * @return
	 */
	public static Short getShortPameter(String name) {
		return getShortPameter(name, null);
	}
	/**
	 * 根据参数名称，获取request作用于中值,返回Short
	 * @param name	参数名称
	 * @param iDefault	如果获取的值为空，则返回该默认值
	 * @return Short
	 */
	public static Short getShortPameter(String name,Short sDefault) {
		String value = getStrPameter(name);
		return !StringUtils.isBlank(value) ? Short.valueOf(value) : sDefault;
	}
	/**
	 * get Byte value from request
	 * @param name	参数名称
	 * @return
	 */
	public static Byte getBytePameter( String sParam) {
		return getBytePameter(sParam, null);
	}
	/**
	 * 根据参数名称，获取request作用于中值,返回Byte
	 * @param name	参数名称
	 * @param nDefault	如果获取的值为空，则返回该默认值
	 * @return Byte
	 */
	public static Byte getBytePameter(String sParam,Byte nDefault) {
		String s = getRequest().getParameter(sParam);
		return !StringUtils.isBlank(s) ? Byte.valueOf(s) : nDefault;
		
	}
	/**
	 * get Long value from request
	 * @param name	参数名称
	 * @return
	 */
	public static Long getLongPameter(String name) {
		String value = getStrPameter(name);
		if(value == null) {
			return null;
		}else {
			return Long.valueOf(value);
		}
	}
	/**
	 * 根据参数名称，获取request作用于中值,返回Long
	 * @param name	参数名称
	 * @param lDefault	如果获取的值为空，则返回该默认值
	 * @return Integer
	 */
	public static Long getLongPameter(String name,Long lDefault) {
		String value = getStrPameter(name);
		return !StringUtils.isBlank(value) ? Long.valueOf(value) : lDefault;
	}
	/**
	 * get Double value from request
	 * @param name	参数名称
	 * @return
	 */
	public static Float getFloatPameter(String name) {
		return getFloatPameter(name, null);
	}
	/**
	 * get Double value from request
	 * @param name	参数名称
	 * @return
	 */
	public static Float getFloatPameter(String name,Float defaultValue) {
		String value = getStrPameter(name);
		return !StringUtils.isBlank(value) ? Float.valueOf(value) : defaultValue;
	}

	/**
	 * get Double value from request
	 * @param name	参数名称
	 * @return
	 */
	public static Double getDoublePameter(String name) {
		String value = getStrPameter(name);
		return !StringUtils.isBlank(value) ? Double.valueOf(value) : null;
	}
	/**
	 * get Double value from request
	 * @param name	参数名称
	 * @return
	 */
	public static Double getDoublePameter(String name,Double defaultValue) {
		String value = getStrPameter(name);
		return !StringUtils.isBlank(value) ? Double.valueOf(value) : defaultValue;
	}
	/**
	 * get Date value from request
	 * @param name	参数名称
	 * @return
	 */
	public static Date getDatePameter(String name) {
		String value = getStrPameter(name);
		return !StringUtils.isBlank(value) ? DateUtils.StringToDateTime(value) : null;
	}
	/**
	 * get Date value from request
	 * @param name	参数名称
	 * @return
	 */
	public static Date getDatePameter(String name,Date defaultValue) {
		String value = getStrPameter(name);
		return !StringUtils.isBlank(value) ? DateUtils.StringToDateTime(value) : defaultValue;
	}
	

	/**
	 * get session from request
	 * @return
	 */
	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * get attribute from session
	 * @param name	参数名称
	 * @return
	 */
	public static Object getAttr(String name) {
		return getSession().getAttribute(name);
	}

	/**
	 * remove attribute from session
	 * @param name	参数名称
	 */
	public static void removeAttr(String name) {
		getSession().removeAttribute(name);
	}

	/**
	 * update session
	 * @param name	参数名称
	 */
	public static void setAttr(String name,Object value) {
		getSession().setAttribute(name, value);
	}
	
	
	//-------------------------------response--------------------------------------
	/**
	 * 返回响应 ，string类型
	 * @param sReturn 需要返回的string类型字符串
	 */
	public static void setResponseResultRaw(String sReturn) {
		try {
			HttpServletResponse response = getResponse();
			response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
			response.setHeader("Pragma", "no-cache"); // HTTP 1.0
			response.setDateHeader("Expires", 0); // prevents caching at the
													// proxy server
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(sReturn);
			response.flushBuffer();
			logger.info(sReturn);
		} catch (IOException e) {
			logger.error("setResponseResultRaw:" + e.getMessage());
		}
	}

	//----------------request------------------
	/**
	 * 将作用于中的参数放入map中
	 * @param paramMap	需要操作的map
	 */
	@SuppressWarnings("unchecked")
	public static void initParamsMap(Map<String, Object> paramMap){
		try {
			Map<String, String[]> requestMaps = getRequest().getParameterMap();
			for (String key : requestMaps.keySet()) {
				String[] values = requestMaps.get(key);
				
				if(values != null && values.length > 0){
					paramMap.put(key, values[0]);
				}else{
					paramMap.put(key, "");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
