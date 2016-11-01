package com.spider.resource.adapter.task;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.api.AliyunClient;
import com.aliyun.api.account.account20130701.request.CreateAliyunAccountForBidRequest;
import com.aliyun.api.account.account20130701.request.CreateAppForBidRequest;
import com.aliyun.api.account.account20130701.response.CreateAliyunAccountForBidResponse;
import com.aliyun.api.account.account20130701.response.CreateAppForBidResponse;
import com.spider.resource.adapter.AliyunAdapter;
import com.spider.resource.adapter.IAdapterTask;
import com.spider.resource.adapter.ResourceAdapter;
import com.spider.resource.model.AdapterTask;
import com.spider.resource.model.BusinessResourceRelation;
import com.spider.resource.model.StateEnum;
import com.spider.resource.service.BusinessResourceRelationService;
import com.spider.util.UUIDUtils;
import com.spider.workorder.model.WorkOrderBo;
import com.taobao.api.ApiException;

@Service("aliyunCreateAccount")
@Scope("prototype")
public class CreateAliyunAccountTask implements IAdapterTask {

	Logger logger = LoggerFactory.getLogger(CreateAliyunAccountTask.class);
	
	@Autowired
	@Qualifier("businessResourceRelationService")
	private BusinessResourceRelationService businessResRelService;
	
	@Override
	public AdapterTask createTask(ResourceAdapter adapter, WorkOrderBo workorder) {
		AdapterTask taskDB = new AdapterTask();
        taskDB.setCommandProtocol("aliyunCommandUtil");
        
        BusinessResourceRelation businessResRel = businessResRelService.getBusinessResourceRelationByUserId(workorder.getUserId());
        if(businessResRel != null && businessResRel.getBusinessResId() != null){
        	logger.info("∞¢¿Ô‘∆’À∫≈“—¥Ê‘⁄");
        	taskDB.setStatus(StateEnum.success);
        	return taskDB;
        }
        
        AliyunAdapter aliyunAdapter;
        if (adapter instanceof AliyunAdapter) {
            aliyunAdapter = (AliyunAdapter) adapter;
        } else {
            throw new RuntimeException("The resource adapter must be AliyunAdapter.");
        }
        AliyunClient client = aliyunAdapter.getAliyunAccountClient();
        
        CreateAliyunAccountForBidRequest req = new CreateAliyunAccountForBidRequest();
        try {
			CreateAliyunAccountForBidResponse res = client.execute(req);
			String errorCode = res.getErrorCode();
			JSONObject uid = null;
			Map<String, String> uidInfo = new HashMap<String, String>();
			if (errorCode != null && errorCode.equals("200")) {
            	uid = JSONObject.parseObject(res.getBody()); 
            	uidInfo.put("Aliyunid", uid.getString("Aliyunid"));
            	uidInfo.put("Pk", uid.getString("Pk"));
            	logger.info("Get aliyunid and pk info: " + res.getBody());
            }
            
            CreateAppForBidRequest reqApp = new CreateAppForBidRequest();
            reqApp.setOwnerAccount(uidInfo.get("Aliyunid"));
            CreateAppForBidResponse resApp = client.execute(reqApp);
            errorCode = resApp.getErrorCode();
            
            if (errorCode != null && errorCode.equals("200")) {
            	uid = JSONObject.parseObject(resApp.getBody()); 
            	uidInfo.put("AppKey", uid.getString("AppKey"));
            	uidInfo.put("Secret", uid.getString("Secret"));
            }
			
			BusinessResourceRelation relation = new BusinessResourceRelation();
			relation.setUuid(UUIDUtils.getUuid());
			relation.setUserId(workorder.getUserId());
			relation.setBusinessResId(JSON.toJSONString(uidInfo));
			businessResRelService.addBusinessResourceRelation(relation);
		} catch (ApiException e) {
			e.printStackTrace();
			taskDB.setStatus(StateEnum.error);
			taskDB.setInfo(e.getMessage());
		}
		
		return taskDB;
	}

}
