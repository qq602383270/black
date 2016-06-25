package com.commons.dwr;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

import com.commons.interceptor.LogUtil;

/**
 * 页面调用此处，注册当前用户
 * 
 * @author WangBin
 *
 * @Company: 百信金融
 *
 * 2015年6月29日 下午3:16:34
 */
@RemoteProxy(name = "MessagePush")
public class MessagePush {
	
	private static boolean registListener = false;
	@RemoteMethod
	public void onPageLoad(String userId) {
		try {
			// ScriptSession,DWR中提供的脚本会话对象,这个会话是储存在本地线程中的
			ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
			HttpSession session = WebContextFactory.get().getSession();
			// 给每个脚本会话赋值一个属性,一般作为脚本会话的区别属性
			scriptSession.setAttribute("userId", userId);
			synchronized (MessagePush.class) {
				if(!registListener){
					registListener = true;
					new DwrScriptSessionManagerUtil().init();
				}
			}
		} catch (ServletException e) {
			LogUtil.debug(getClass(), e.getMessage());
		}
	}
}
