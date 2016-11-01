package com.spider.resource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spider.resource.dao.BusinessResourceRelationDao;
import com.spider.resource.model.BusinessResourceRelation;
import com.spider.resource.service.BusinessResourceRelationService;

@Transactional
@Service("businessResourceRelationService")
public class BusinessResourceRelationServiceImpl implements BusinessResourceRelationService {

	@Autowired
	@Qualifier("businessResourceRelationDao")
	private BusinessResourceRelationDao businessResourceRelationDao;
	
	@Override
	public BusinessResourceRelation getBusinessResourceRelationByUserId(String userId) {
		return businessResourceRelationDao.findBusinessResourceRelationByUserId(userId);
	}

	@Override
	public void addBusinessResourceRelation(BusinessResourceRelation businessResourceRelation) {
		businessResourceRelationDao.insertBusinessResourceRelation(businessResourceRelation);
	}

}
