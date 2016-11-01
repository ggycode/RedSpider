package com.spider.resource.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spider.dao.impl.HibernateGenericDaoImpl;
import com.spider.resource.dao.ResourcePoolDao;
import com.spider.resource.model.Platform;
import com.spider.resource.model.ResourcePool;

@Repository("resourcePoolDao")
public class ResourcePoolDaoImpl extends HibernateGenericDaoImpl<ResourcePoolDaoImpl> implements ResourcePoolDao {

	@Override
	public ResourcePool findResourcePool(String id) {
		List<ResourcePool> resourcePoolList = getHibernateTemplate().find("from ResourcePool where id='"+id+"'");
		if(resourcePoolList != null && resourcePoolList.size() > 0){
			return resourcePoolList.get(0);
		}
		return null;
	}

	@Override
	public List<ResourcePool> findResourcePoolList(String platformId,String name) {
		String hql = "from ResourcePool where 1=1";
		if (platformId != null) {
			hql += " and platformId='"+platformId+"'";
		}
		if(name != null){
			hql += " and name='"+name+"'";
		}
		List<ResourcePool> resourcePoolList = getHibernateTemplate().find(hql);
		return resourcePoolList;
	}
}