package com.spider.resource.adapter;

import com.spider.workorder.model.WorkOrderBo;

public interface CommonApi {
	
	public String getValueByScope(String scope, String name);
	
	public String getUid(WorkOrderBo workOrderBo);
	
	public String getRegionId(WorkOrderBo workOrderBo);
	
	public String getPropertyValueFromWorkOrder(WorkOrderBo workOrderBo, String propertyName);	
	
	public String findImage(AliyunAdapter adapter, WorkOrderBo workOrderBo);
	
	public String findInstanceType(AliyunAdapter adapter, WorkOrderBo workOrderBo);
}
