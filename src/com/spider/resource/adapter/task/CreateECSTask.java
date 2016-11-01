package com.spider.resource.adapter.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.aliyun.api.AliyunClient;
import com.aliyun.api.ecs.ecs20140526.request.CreateInstanceRequest;
import com.aliyun.api.ecs.ecs20140526.response.CreateInstanceResponse;
import com.spider.resource.adapter.AliyunAdapter;
import com.spider.resource.adapter.AliyunCommonApi;
import com.spider.resource.adapter.CommonApi;
import com.spider.resource.adapter.IAdapterTask;
import com.spider.resource.adapter.ResourceAdapter;
import com.spider.resource.model.AdapterTask;
import com.spider.resource.model.ResourcePool;
import com.spider.resource.model.StateEnum;
import com.spider.resource.service.BusinessResourceRelationService;
import com.spider.resource.service.ResourcePoolService;
import com.spider.workorder.model.WorkOrderBo;
import com.taobao.api.ApiException;

@Service("aliyunCreateVM")
@Scope("prototype")
public class CreateECSTask implements IAdapterTask {
	
	private Logger logger = LoggerFactory.getLogger(CreateECSTask.class);
	
	@Autowired
	@Qualifier("aliyunCommonApi")
	private CommonApi commonApi;
	
	@Override
	public AdapterTask createTask(ResourceAdapter adapter, WorkOrderBo workorder) {
		AdapterTask taskDB = new AdapterTask();
		taskDB.setCommandProtocol("aliyunCommandUtil");
		
		AliyunAdapter aliyunAdapter;
        if (adapter instanceof AliyunAdapter) {
        	aliyunAdapter = (AliyunAdapter) adapter;
        } else {
            throw new RuntimeException("The resource adapter must be AliyunAdapter.");
        }
        
        AliyunClient client = aliyunAdapter.getClient();
        CreateInstanceRequest createInstanceRequest = new CreateInstanceRequest();
        
        String regionId = commonApi.getRegionId(workorder);
        if (regionId != null) {
        	createInstanceRequest.setRegionId(regionId);
        }
        
        String uid = commonApi.getUid(workorder);
        if(uid != null){
        	createInstanceRequest.setOwnerAccount(uid);
        }
        
        String instanceName = commonApi.getPropertyValueFromWorkOrder(workorder, "vm_name");
        if(instanceName != null){
        	createInstanceRequest.setInstanceName(instanceName);
        }
        
        String imageId = commonApi.findImage(aliyunAdapter, workorder);
        if(imageId != null){
        	createInstanceRequest.setImageId(imageId);
        }
       
        String instanceTypeId = commonApi.findInstanceType(aliyunAdapter, workorder);
        if (instanceTypeId != null) {
        	createInstanceRequest.setInstanceType(instanceTypeId);
        }
        
        for (int i = 1; i <= 4; i++) {
        	String diskCategory = null;
        	String diskName = null;
        	Long diskSize = null;
        	String paraDiskName = "disk_" + i + "_name";
        	String paraDiskSize = "disk_" + i + "_size";
            diskName = commonApi.getPropertyValueFromWorkOrder(workorder, paraDiskName);
            String sizeStr = commonApi.getPropertyValueFromWorkOrder(workorder, paraDiskSize);
            if(sizeStr != null){
            	diskSize = Long.valueOf(sizeStr);
            }
            if (diskName == null && diskSize == null) break;
            if (i == 1) {createInstanceRequest.setDataDisk1DiskName(diskName);createInstanceRequest.setDataDisk1Size(diskSize);}
            else if (i == 2) {createInstanceRequest.setDataDisk2DiskName(diskName);createInstanceRequest.setDataDisk2Size(diskSize);}
            else if (i == 3) {createInstanceRequest.setDataDisk3DiskName(diskName);createInstanceRequest.setDataDisk3Size(diskSize);}
            else {createInstanceRequest.setDataDisk4DiskName(diskName);createInstanceRequest.setDataDisk4Size(diskSize);}
        }
        
      //临时提供默认安全组
        createInstanceRequest.setSecurityGroupId("sg-218raram4");
        
        try {
			CreateInstanceResponse createInstanceResponse = client.execute(createInstanceRequest);
			String errorCode = createInstanceResponse.getErrorCode();
			if (errorCode == null) {
				String instanceId = createInstanceResponse.getInstanceId();
				taskDB.setResult(instanceId);
				taskDB.setStatus(StateEnum.success);
			} else {
				logger.error(createInstanceResponse.getMessage());
				taskDB.setInfo(createInstanceResponse.getMessage());
				taskDB.setStatus(StateEnum.error);
				
				String requestId = createInstanceResponse.getRequestId();
            	String workOrderNo = workorder.getWorkOrderNo();
            	logger.info("*** Failed to exec CreateECSTask, saveWorkOrderProperty requestId="+requestId + ",workOrderNo="+workOrderNo);
            	
			}
			logger.info("RequestId: " + createInstanceResponse.getRequestId());
        	taskDB.setCommandInfo(createInstanceResponse.getRequestId());
		} catch (ApiException e) {
			taskDB.setStatus(StateEnum.error);
			e.printStackTrace();
        	String workOrderNo = workorder.getWorkOrderNo();
        	logger.info("*** Failed to exec CreateECSTask, saveWorkOrderProperty requestId=,workOrderNo="+workOrderNo);
		}
        
		return null;
	}

}
