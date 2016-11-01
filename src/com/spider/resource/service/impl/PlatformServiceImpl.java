package com.spider.resource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spider.resource.dao.PlatformDao;
import com.spider.resource.model.Platform;
import com.spider.resource.service.PlatformService;

@Transactional
@Service("platformService")
public class PlatformServiceImpl implements PlatformService {

	@Autowired
	@Qualifier("platformDao")
	private PlatformDao platformDao;
	
	@Override
	public Platform getPlatform(String id) {
		return platformDao.findPlatformById(id);
	}

}
