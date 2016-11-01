package com.spider.resource.adapter;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.api.AliyunClient;
import com.aliyun.api.domain.Image;
import com.aliyun.api.domain.InstanceType;
import com.aliyun.api.ecs.ecs20140526.request.DescribeImagesRequest;
import com.aliyun.api.ecs.ecs20140526.request.DescribeInstanceTypesRequest;
import com.aliyun.api.ecs.ecs20140526.response.DescribeImagesResponse;
import com.aliyun.api.ecs.ecs20140526.response.DescribeInstanceTypesResponse;
import com.spider.resource.adapter.task.CreateECSTask;
import com.spider.resource.model.BusinessResourceRelation;
import com.spider.resource.model.ResourcePool;
import com.spider.resource.service.BusinessResourceRelationService;
import com.spider.resource.service.ResourcePoolService;
import com.spider.workorder.model.WorkOrderBo;
import com.spider.workorder.model.WorkOrderPropertyBo;
import com.taobao.api.ApiException;

@Service("aliyunCommonApi")
public class AliyunCommonApi implements CommonApi {
	
	private Logger logger = LoggerFactory.getLogger(AliyunCommonApi.class);
	
	@Autowired
	@Qualifier("resourcePoolService")
	private ResourcePoolService resourcePoolService;
	
	@Autowired
	@Qualifier("businessResourceRelationService")
	private BusinessResourceRelationService businessResRelService;
	
	@Override
	public String getValueByScope(String scope, String name)
	{
		return (String) JSONObject.parseObject(scope).get(name);
	}

	@Override
	public String getUid(WorkOrderBo workOrderBo) {
		String scope = null;
		BusinessResourceRelation relation = businessResRelService.getBusinessResourceRelationByUserId(workOrderBo.getUserId());
		if(relation != null){
			scope = relation.getBusinessResId();
			if(scope != null){
				return getValueByScope(scope, "Aliyunid");
			}
		}
		return null;
	}

	@Override
	public String getRegionId(WorkOrderBo workOrderBo) {
		String scope = null;
        ResourcePool resourcePool = resourcePoolService.getResourcePoolById(workOrderBo.getResourcePoolId());
        if (resourcePool != null) {
            scope = resourcePool.getScope();
            if(scope != null){
				return getValueByScope(scope, "regionId");
			}
        }
		return null;
	}

	@Override
	public String getPropertyValueFromWorkOrder(WorkOrderBo workOrderBo,String propertyName) {
		if(workOrderBo != null){
			Set<WorkOrderPropertyBo> propertyBos = workOrderBo.getWorkOrderProperties();
			for(WorkOrderPropertyBo propertyBo : propertyBos){
				if(propertyName.equals(propertyBo.getPropertyName())){
					return propertyBo.getPropertyValue();
				}
			}
		}
		return null;
	}

	@Override
	public String findImage(AliyunAdapter adapter, WorkOrderBo workOrderBo) {
		Long size = null;
		String attrSize = getPropertyValueFromWorkOrder(workOrderBo, "root_disk");
		if (attrSize != null)
		{
			// 工单模板单位是G
			size = Long.valueOf(attrSize.split(" ")[0]);
		}

		String osName = getPropertyValueFromWorkOrder(workOrderBo, "osName");

		String imageId = null;
		AliyunClient client = adapter.getClient();
		DescribeImagesRequest req = new DescribeImagesRequest();
		String uid = getUid(workOrderBo);
		if (!StringUtils.isEmpty(uid)) {
			req.setOwnerAccount(uid);
        }
		req.setPageNumber(1l);
		req.setPageSize(50l);

		String regionId = getRegionId(workOrderBo);
        if (regionId != null) {
        	req.setRegionId(regionId);
        }

		try
		{
			DescribeImagesResponse res = client.execute(req);
			if (res.getErrorCode() == null)
			{
				List<Image> lists = res.getImages();
				for (Image image : lists)
				{
					// 查找系统公有镜像多加一判断
					if (image.getoSName().equals(osName) && image.getSize().equals(size) && image.getImageOwnerAlias().equals("system"))
					{
						imageId = image.getImageId();
						break;
					}
				}
			} else
			{
				logger.info("Error to find image. " + res.getMessage());
			}
		} catch (ApiException e)
		{
		}
		return imageId;
	}

	@Override
	public String findInstanceType(AliyunAdapter adapter, WorkOrderBo workOrderBo) {
		Long cpu = null;
		String attrCpu = getPropertyValueFromWorkOrder(workOrderBo, "cpu");
		if (attrCpu != null)
		{
			// 取值，工单单位默认为核
			cpu = Long.valueOf(attrCpu.split(" ")[0]);
		}

		String memory = null;
		String attrMemory = getPropertyValueFromWorkOrder(workOrderBo, "memory");
		if (attrMemory != null)
		{
			// 工单内存单位是G
			memory = attrMemory.split(" ")[0];
			if (!memory.contains("."))
			{
				memory = memory + ".0";
			}
		}

		String instanceTypeId = null;
		AliyunClient client = adapter.getClient();
		DescribeInstanceTypesRequest req = new DescribeInstanceTypesRequest();
		String uid = getUid(workOrderBo);
		if (!StringUtils.isEmpty(uid)) {
			req.setOwnerAccount(uid);
        }

		try
		{
			DescribeInstanceTypesResponse res = client.execute(req);
			if (res.getErrorCode() == null)
			{//
				List<InstanceType> lists = res.getInstanceTypes();
				for (InstanceType instanceType : lists)
				{
					if (instanceType.getCpuCoreCount().equals(cpu) && instanceType.getMemorySize().equals(memory))
					{
						instanceTypeId = instanceType.getInstanceTypeId();
						break;
					}
				}
			} else
			{
				logger.info("Error to find instance type. " + res.getMessage());
			}
		} catch (ApiException e)
		{
		}

		return instanceTypeId;
	}
}
