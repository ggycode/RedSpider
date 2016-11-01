package com.spider.resource.service;


import java.util.List;

import com.spider.resource.model.ResourcePool;

public interface ResourcePoolService {
	public ResourcePool getResourcePoolById(String id);
	
	public List<ResourcePool> getResourcePools(String platformId,String name);
}
