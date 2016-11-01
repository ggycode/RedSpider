package com.spider.resource.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.api.AliyunClient;
import com.aliyun.api.ecs.ecs20140526.request.DescribeInstancesRequest;
import com.aliyun.api.ecs.ecs20140526.response.DescribeInstancesResponse;
import com.spider.resource.adapter.AliyunAdapter;
import com.spider.resource.adapter.ResourceAdapter;
import com.spider.resource.model.BusinessResourceRelation;
import com.spider.resource.model.ResourcePool;
import com.spider.resource.service.BusinessResourceRelationService;
import com.spider.resource.service.ResourceQueryService;
import com.spider.workorder.model.WorkOrderBo;
import com.taobao.api.ApiException;

@Service("resourceQueryService")
public class AliyunResourceQueryServiceImpl implements ResourceQueryService{

	private Logger logger = LoggerFactory.getLogger(AliyunResourceQueryServiceImpl.class);
	
	@Autowired
	@Qualifier("businessResourceRelationService")
	private BusinessResourceRelationService businessResRelService;
	
	public String getUid(String userId) {
		String scope = null;
		BusinessResourceRelation relation = businessResRelService.getBusinessResourceRelationByUserId(userId);
		if(relation != null){
			scope = relation.getBusinessResId();
			if(scope != null){
				return getValueByScope(scope, "Aliyunid");
			}
		}
		return null;
	}
	
	public String getRegionId(ResourcePool resourcePool){
		String regionId = null;
		if(resourcePool != null){
			String scope = resourcePool.getScope();
			if(scope != null){
				regionId = getValueByScope(scope, "regionId");
			}
		}
		return regionId;
	}
	
	public String getValueByScope(String scope, String name)
	{
		return (String) JSONObject.parseObject(scope).get(name);
	}
	
	@Override
	public JSONObject describeEcsInstances(String userId,ResourceAdapter adapter,ResourcePool resourcePool,String pageSize, String pageNum) {
		logger.info("Describe instances from Ali");
		JSONObject json = new JSONObject();
		AliyunClient client = ((AliyunAdapter)adapter).getClient();
		DescribeInstancesRequest req = new DescribeInstancesRequest();
		String uid = getUid(userId);
		if (uid != null) {
			req.setOwnerAccount(uid);
		}
		String regionId = getRegionId(resourcePool);
		if(regionId != null){
			req.setRegionId(regionId);
		}
		Long pSize = Long.valueOf(pageSize);
		Long pNum = Long.valueOf(pageNum);
		req.setPageSize(pSize);
		req.setPageNumber(pNum);
		try {
			DescribeInstancesResponse resp = client.execute(req);
			if(resp.getErrorCode() == null){
				json.put("total", resp.getTotalCount());
				json.put("pageNum", resp.getPageNumber());
				json.put("pageSize", resp.getPageSize());
				json.put("resources", resp.getInstances());
			}else {
				logger.info(resp.getMessage());
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return json;
	}

}
