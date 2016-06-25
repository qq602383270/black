package com.brd.business.email.service.impl;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.brd.business.email.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired  
    private JmsTemplate jmsTemplate;      
  
	@Override
    public void sendMessage(Destination destination, final Serializable obj) {  
        jmsTemplate.send(destination, new MessageCreator() {  
   
            public Message createMessage(Session session) throws JMSException {  
                ObjectMessage objMessage = session.createObjectMessage(obj);  
                return objMessage;  
            }  
              
        });  
        
      //使用MessageConverter的情况  
       // jmsTemplate.convertAndSend(destination, obj);  
    }  
   
}
