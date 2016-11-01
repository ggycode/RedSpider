package com.spider.resource.service;

import com.alibaba.fastjson.JSONObject;
import com.spider.resource.adapter.AliyunAdapter;
import com.spider.resource.adapter.ResourceAdapter;
import com.spider.resource.model.ResourcePool;


public interface ResourceQueryService {
	public JSONObject describeEcsInstances(String userId,ResourceAdapter adapter,ResourcePool resourcePool,String pageSize, String pageNum);
}
