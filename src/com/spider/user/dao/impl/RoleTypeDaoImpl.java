package com.spider.user.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spider.dao.impl.HibernateGenericDaoImpl;
import com.spider.user.dao.RoleTypeDao;
import com.spider.user.model.RoleType;

@Repository("roleTypeDao")
public class RoleTypeDaoImpl extends HibernateGenericDaoImpl<RoleTypeDaoImpl> implements RoleTypeDao {

	@Override
	public List<RoleType> findRoleTypes() {
		return getHibernateTemplate().find("from RoleType");
	}

}
