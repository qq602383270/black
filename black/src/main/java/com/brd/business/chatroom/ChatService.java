package com.brd.business.chatroom;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.brd.business.chatroom.domain.Message;
import com.brd.business.chatroom.event.ChatMessageEvent;
@Service
public class ChatService implements ApplicationContextAware {
    private ApplicationContext ctx;
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }
    
    /**
     * <b>function:</b> 向服务器发送信息，服务器端监听ChatMessageEvent事件，当有事件触发就向所有客户端发送信息
     * @param msg
     */
    public void sendMessage(Message msg) {
        //发布事件
        ctx.publishEvent(new ChatMessageEvent(msg));
    }
}
