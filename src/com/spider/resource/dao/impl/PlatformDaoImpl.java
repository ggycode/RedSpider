package com.spider.resource.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spider.dao.impl.HibernateGenericDaoImpl;
import com.spider.resource.dao.PlatformDao;
import com.spider.resource.model.Platform;

@Repository("platformDao")
public class PlatformDaoImpl extends HibernateGenericDaoImpl<PlatformDaoImpl> implements PlatformDao {

	@Override
	public Platform findPlatformById(String id) {
		List<Platform> platformList = getHibernateTemplate().find("from Platform where id='"+id+"'");
		if(platformList != null && platformList.size() > 0){
			return platformList.get(0);
		}
		return null;
	}

}
