package com.spider.resource.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spider.dao.impl.HibernateGenericDaoImpl;
import com.spider.resource.dao.BusinessResourceRelationDao;
import com.spider.resource.model.BusinessResourceRelation;

@Repository("businessResourceRelationDao")
public class BusinessResourceRelationDaoImpl extends HibernateGenericDaoImpl<BusinessResourceRelationDaoImpl> implements BusinessResourceRelationDao {

	@Override
	public BusinessResourceRelation findBusinessResourceRelationByUserId(String userId) {
		List<BusinessResourceRelation> businessResRelList = getHibernateTemplate().find("from BusinessResourceRelation where removed is null and userId='"+userId+"'");
		if(businessResRelList != null && businessResRelList.size() > 0){
			return businessResRelList.get(0);
		}
		return null;
	}

	@Override
	public void insertBusinessResourceRelation(BusinessResourceRelation businessResourceRelation) {
		getHibernateTemplate().save(businessResourceRelation);
	}

}
