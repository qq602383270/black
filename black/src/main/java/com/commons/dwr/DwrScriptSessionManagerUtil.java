package com.commons.dwr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.directwebremoting.Container;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;
import org.directwebremoting.servlet.DwrServlet;

import com.commons.interceptor.LogUtil;

/**
 * 推送session管理类
 * 
 * @author WangBin
 *
 * @Company: 百信金融
 *
 * 2015年7月20日 上午9:26:42
 */
public class DwrScriptSessionManagerUtil extends DwrServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = -8908966684532941499L;
	//维护一个Map key为session的Id， value为ScriptSession对象
    public static final Map<String, ScriptSession> scriptSessionMap = new HashMap<String, ScriptSession>();
    
	public void init() throws ServletException {

		Container container = ServerContextFactory.get().getContainer();
		
		final ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);

		ScriptSessionListener listener = new ScriptSessionListener() {
			public void sessionCreated(ScriptSessionEvent ev) {
				HttpSession session = WebContextFactory.get().getSession();
				String userId = session.getAttribute("userId") + "";
				if (!StringUtils.isBlank(userId)) {
					// 从脚本会话管理类中得到目前所有的脚本会话对象
					Collection<ScriptSession> sessions = manager.getAllScriptSessions();
					// 说明已经存在旧的scriptSession.注销这个旧的scriptSession
					Integer scriptSessionId = (Integer) session.getAttribute("scriptSessionId");
					if (scriptSessionId != null) {
						for (ScriptSession scriptSession : sessions) {
							if (scriptSession.hashCode() != scriptSessionId.intValue()) {
								scriptSession.invalidate();
							}
						}
					}
					ScriptSession scriptSession = ev.getSession();
					scriptSession.setAttribute("userId", userId);
					//scriptSession.setAttribute(Constants.System.SYS_LOGIN_USER, sysuser);
					session.setAttribute("scriptSessionId", scriptSession.hashCode());
					LogUtil.debug(getClass(), "a ScriptSession is created! userid: " + userId);					
					scriptSessionMap.put(session.getId(), scriptSession);					
				} else {
					ev.getSession().invalidate();
					session.invalidate();
				}
			}

			public void sessionDestroyed(ScriptSessionEvent ev) {
				
//				HttpSession session = WebContextFactory.get().getSession();
//				
//				System.out.println(session.getId());
//				if(session != null){
//					scriptSessionMap.remove(session.getId());
//					LogUtil.info(getClass(), "a ScriptSession is distroyed" + "--" + ev.toString());
//				}
			}
		};
		manager.addScriptSessionListener(listener);
	}
	/**
     * 获取所有ScriptSession
     */
    public static Collection<ScriptSession> getScriptSessions(){
           return scriptSessionMap.values();
    }

}