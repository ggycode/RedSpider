package com.spider.resource.dao.impl;

import org.springframework.stereotype.Repository;

import com.spider.dao.impl.HibernateGenericDaoImpl;
import com.spider.resource.dao.AdapterTaskDao;
import com.spider.resource.model.AdapterTask;

@Repository("adapterTaskDao")
public class AdapterTaskDaoImpl extends HibernateGenericDaoImpl<AdapterTaskDaoImpl> implements AdapterTaskDao {

	@Override
	public void insertAdapterTask(AdapterTask taskDB) {
		getHibernateTemplate().save(taskDB);
	}

}
