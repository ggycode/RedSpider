package com.spider.resource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spider.resource.dao.AdapterTaskDao;
import com.spider.resource.model.AdapterTask;
import com.spider.resource.service.AdapterTaskService;

@Transactional
@Service("adapterTaskService")
public class AdapterTaskServiceImpl implements AdapterTaskService {

	@Autowired
	@Qualifier("adapterTaskDao")
	private AdapterTaskDao adapterTaskDao;
	
	@Override
	public void addAdapterTask(AdapterTask taskDB) {
		adapterTaskDao.insertAdapterTask(taskDB);
	}

}
