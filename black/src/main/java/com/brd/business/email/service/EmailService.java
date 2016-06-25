package com.brd.business.email.service;

import java.io.Serializable;

import javax.jms.Destination;

public interface EmailService {

	void sendMessage(Destination destination, Serializable obj);

}
