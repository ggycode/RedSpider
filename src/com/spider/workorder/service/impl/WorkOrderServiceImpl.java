package com.spider.workorder.service.impl;

import java.util.List;

import javax.jms.Destination;
import javax.transaction.Synchronization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spider.amqp.message.MessagePublisher;
import com.spider.util.UUIDUtils;
import com.spider.util.WorkOrderStatus;
import com.spider.workorder.dao.WorkOrderDao;
import com.spider.workorder.model.WorkOrderBo;
import com.spider.workorder.model.WorkOrderPropertyBo;
import com.spider.workorder.service.WorkOrderService;

@Transactional
@Service("workOrderService")
public class WorkOrderServiceImpl implements WorkOrderService {
	
	@Autowired
	@Qualifier("workOrderDao")
	private WorkOrderDao workOrderDao;
	
	@Autowired
	@Qualifier("messagePublisher")
	private MessagePublisher messagePublisher;
	
	@Autowired
	@Qualifier("queueDestination")
	private Destination destination;

	@Override
	public void addWorkOrder(WorkOrderBo workOrderBo) {
		String workOrderNo = null;
		try {
			workOrderNo = getSequence();
		} catch (Exception e) {
			workOrderNo = null;
		}
		if(workOrderNo == null){
			workOrderNo = UUIDUtils.getUuid();
		}
		workOrderBo.setWorkOrderNo(workOrderNo);
		workOrderBo.setState(WorkOrderStatus.OPENING.getValue());
		workOrderDao.insertWorkOrder(workOrderBo);
		
		if(workOrderBo.getWorkOrderProperties() != null && workOrderBo.getWorkOrderProperties().size() > 0){
			for(WorkOrderPropertyBo pro : workOrderBo.getWorkOrderProperties()){
				pro.setWorkOrderBo(workOrderBo);
				if(pro.getId() == null){
					pro.setId(UUIDUtils.getUuid());
				}
				workOrderDao.insertWorkOrderProperty(pro);
			}
		}
		System.out.println(JSON.toJSONString(workOrderBo));
		//发送消息到适配层
		messagePublisher.sendMessage(destination,JSON.toJSONString(workOrderBo));
	}

	@Override
	public List findWorkOrder() {
		return workOrderDao.selectWorkOrders();
	}

	public synchronized String getSequence() {
		return workOrderDao.getSequence();
	}
	
	
}
