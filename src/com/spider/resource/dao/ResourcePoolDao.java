package com.spider.resource.dao;


import java.util.List;

import com.spider.resource.model.ResourcePool;

public interface ResourcePoolDao {
	public ResourcePool findResourcePool(String id);
	
	public List<ResourcePool> findResourcePoolList(String platformId,String name);
}
