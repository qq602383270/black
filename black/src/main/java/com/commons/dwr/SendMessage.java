package com.commons.dwr;

import java.util.Collection;
import java.util.List;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;

import com.commons.interceptor.LogUtil;

/**
 * 推送方法
 *
 * 向页面推送信息
 * 
 * @author WangBin
 *
 * @Company: 百信金融
 *
 * 2015年6月29日 下午3:16:50
 */
public class SendMessage {

	/**
	 * @param userIds
	 *            推送给谁
	 * @param functionName
	 *            页面执行函数名称
	 * @param args
	 *            参数
	 */
	public static void sendMessageAuto(final List<String> userIds, final String functionName, final Object... args) {
		Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
			public boolean match(ScriptSession session) {
				// 根据脚本中的userId属性来判断是否是要推送的目标脚本会话
				if (session.getAttribute("userId") == null) {
					return false;
				} else {
					for(String userId : userIds) {
						if(userId.equals(String.valueOf(session.getAttribute("userId")))) {
							return true;
						}
					}
					return false;
				}
			}
		}, new Runnable() {
			public void run() {
				ScriptBuffer script = new ScriptBuffer();
				script.appendCall(functionName, args);
				Collection<ScriptSession> sessions = Browser.getTargetSessions();
				LogUtil.info(getClass(), "后台推送信息,funname = " + functionName + ",args = " + args);
				for (ScriptSession scriptSession : sessions) {
					scriptSession.addScript(script);
				}
			}
		});
	}

	/**
	 *
	 * @param userId
	 * @param functionName
	 * @param args
	 */
	public static void sendMessageAuto(final String userId, final String functionName, final Object... args) {
		Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
			public boolean match(ScriptSession session) {
				// 根据脚本中的userId属性来判断是否是要推送的目标脚本会话
				if (session.getAttribute("userId") == null) {
					return false;
				} else {
					return (userId.equals(String.valueOf(session.getAttribute("userId"))));
				}
			}
		}, new Runnable() {
			public void run() {
				ScriptBuffer script = new ScriptBuffer();
				script.appendCall(functionName, args);				
				Collection<ScriptSession> sessions = Browser.getTargetSessions();
				//Collection<ScriptSession> sessions = DwrScriptSessionManagerUtil.getScriptSessions();				
				LogUtil.info(getClass(), "后台推送信息,funname = " + functionName + ",args = " + args);
				for (ScriptSession scriptSession : sessions) {
					scriptSession.addScript(script);
				}
			}
		});
	}
}
