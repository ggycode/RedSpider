package com.spider.resource.mq;

import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.spider.amqp.message.MessageQueueMap;
import com.spider.amqp.message.MessageResolve;
import com.spider.resource.adapter.AdapterFactory;
import com.spider.resource.adapter.IAdapterTask;
import com.spider.resource.adapter.ResourceAdapter;
import com.spider.resource.model.AdapterTask;
import com.spider.resource.service.AdapterTaskService;
import com.spider.util.SpringContextUtil;
import com.spider.util.UUIDUtils;
import com.spider.workorder.model.WorkOrderBo;

//@Component
//@MessageDriven(mappedName=MessageQueueMap.QUEUE_RESOURCE_EXCUTETASK)
public class ResourceMQ implements MessageListener {

	@Autowired
	@Qualifier("messageResolve")
	private MessageResolve messageResolve;
	
	@Autowired
	@Qualifier("adapterFactory")
	private AdapterFactory adapterFactory;
	
	@Autowired
	@Qualifier("adapterTaskService")
	private AdapterTaskService adapterTaskService;
	
	@Override
	public void onMessage(Message message){ 
		System.out.println("message:   "+message.toString());
		WorkOrderBo workorder = (WorkOrderBo) messageResolve.msgToJavaObject(message, WorkOrderBo.class);
		
		ResourceAdapter aliyunAdapter = adapterFactory.getAdapter(workorder.getResourcePoolId());
		
		IAdapterTask task = (IAdapterTask) SpringContextUtil.getBean("aliyun"+"CreateAccount");
		AdapterTask taskDB = task.createTask(aliyunAdapter, workorder);
		
		IAdapterTask task2 = (IAdapterTask) SpringContextUtil.getBean("aliyun"+"CreateVM");
		AdapterTask taskDB2 = task2.createTask(aliyunAdapter, workorder);
		
		taskDB2.setPoolId(workorder.getResourcePoolId());
		taskDB2.setPlatformId(aliyunAdapter.getPlatform().getId());
		taskDB2.setBeanName("aliyun"+"CreateVM");
		taskDB2.setWorkOrderId(workorder.getWorkOrderNo());
		taskDB2.setWorkOrderContent(workorder.toString());
		taskDB2.setId(UUIDUtils.getUuid());
		adapterTaskService.addAdapterTask(taskDB2);
	}
}
