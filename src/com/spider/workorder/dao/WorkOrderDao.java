package com.spider.workorder.dao;

import java.util.List;

import com.spider.workorder.model.WorkOrderBo;
import com.spider.workorder.model.WorkOrderPropertyBo;

public interface WorkOrderDao {
	public void insertWorkOrder(WorkOrderBo workOrderBo);
	
	public List selectWorkOrders();
	
	public String getSequence();
	
	public void insertWorkOrderProperty(WorkOrderPropertyBo workOrderPropertyBo);
}
