package com.spider.resource.service;

import com.spider.resource.model.BusinessResourceRelation;

public interface BusinessResourceRelationService {
	public BusinessResourceRelation getBusinessResourceRelationByUserId(String userId);
	
	public void addBusinessResourceRelation(BusinessResourceRelation businessResourceRelation);
}
