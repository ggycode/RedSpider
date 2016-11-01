package com.spider.resource.dao;

import com.spider.resource.model.BusinessResourceRelation;

public interface BusinessResourceRelationDao {
	public BusinessResourceRelation findBusinessResourceRelationByUserId(String userId);
	
	public void insertBusinessResourceRelation(BusinessResourceRelation businessResourceRelation);
}
