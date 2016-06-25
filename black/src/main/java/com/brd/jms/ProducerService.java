package com.brd.jms;

import javax.jms.Destination;

public interface ProducerService {

	void sendMessage(Destination destination, String string);

}
