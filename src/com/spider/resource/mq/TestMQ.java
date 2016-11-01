package com.spider.resource.mq;

import javax.jms.Message;
import javax.jms.MessageListener;

public class TestMQ implements MessageListener {

	@Override
	public void onMessage(Message message) {
		System.out.println("message:   "+message.toString());
	}

}
