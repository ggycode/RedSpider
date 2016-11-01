package com.spider.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spider.resource.dao.ResourcePoolDao;
import com.spider.resource.model.ResourcePool;
import com.spider.resource.service.ResourcePoolService;

@Transactional
@Service("resourcePoolService")
public class ResourcePoolServiceImpl implements ResourcePoolService {

	@Autowired
	@Qualifier("resourcePoolDao")
	private ResourcePoolDao resourcePoolDao;
	
	@Override
	public ResourcePool getResourcePoolById(String id) {
		return resourcePoolDao.findResourcePool(id);
	}

	@Override
	public List<ResourcePool> getResourcePools(String platformId,String name) {
		return resourcePoolDao.findResourcePoolList(platformId,name);
	}

}
