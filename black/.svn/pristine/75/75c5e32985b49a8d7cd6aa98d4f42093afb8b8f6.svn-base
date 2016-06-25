package com.brd.test;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.brd.business.email.domain.Email;
import com.brd.business.email.service.EmailService;
import com.brd.jms.ProducerService;
import com.commons.controller.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class TestJMS {

	@Autowired
	private ProducerService producerService;
	@Autowired
	private EmailService emailService;
	@Autowired
	@Qualifier("queueDestination")
	private Destination destination;

	@Test
	public void testSend() {
		for (int i = 0; i < 2; i++) {
			producerService.sendMessage(destination, "你好，生产者！这是消息：" + (i + 1));
		}
	}
	@Test
	public void testSendEmail() {
		Email email = new Email("zhangsan@xxx.com "+DateUtils.getDateTime(), "主题", "内容");  
		emailService.sendMessage(destination, email);
	}
}
