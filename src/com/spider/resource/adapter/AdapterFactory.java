package com.spider.resource.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spider.resource.model.Platform;
import com.spider.resource.model.ResourcePool;
import com.spider.resource.service.PlatformService;
import com.spider.resource.service.ResourcePoolService;
import com.spider.util.SpringContextUtil;

@Service("adapterFactory")
public class AdapterFactory {

	@Autowired
	@Qualifier("platformService")
	private PlatformService platformService;
	
	@Autowired
	@Qualifier("resourcePoolService")
	private ResourcePoolService resourcePoolService;
	
	public ResourceAdapter getAdapter(String resourcePoolId) {
		ResourcePool resourcePool = resourcePoolService.getResourcePoolById(resourcePoolId);
        Platform platform = platformService.getPlatform(resourcePool.getPlatformId());
        ResourceAdapter aliyunAdapter = (ResourceAdapter) SpringContextUtil.getBean("aliyunAdapter");
        aliyunAdapter.config(platform);
        return aliyunAdapter;
    }
}
