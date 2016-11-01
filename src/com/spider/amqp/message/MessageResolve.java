package com.spider.amqp.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spider.workorder.model.WorkOrderBo;

@Service("messageResolve")
public class MessageResolve {
	public Object msgToJavaObject(Message message,Class<?> clazz){
		Object object = null;
		try {
			ObjectMessage oMessage = (ObjectMessage) message;
			String seria = oMessage.getObject().toString();
			JSON json = JSON.parseObject(seria);
			object = JSONObject.parseObject(seria, clazz);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
}
