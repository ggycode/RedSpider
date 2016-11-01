package com.spider.resource.adapter;

import com.spider.resource.model.AdapterTask;
import com.spider.workorder.model.WorkOrderBo;

public interface IAdapterTask {
	public AdapterTask createTask(ResourceAdapter adapter, WorkOrderBo workorder);
	
}
