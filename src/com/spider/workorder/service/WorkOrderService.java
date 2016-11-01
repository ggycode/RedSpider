package com.spider.workorder.service;

import java.util.List;

import com.spider.workorder.model.WorkOrderBo;

public interface WorkOrderService {
	public void addWorkOrder(WorkOrderBo workOrderBo);
	
	public List findWorkOrder();
	
}
