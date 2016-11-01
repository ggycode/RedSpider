package com.spider.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spider.user.dao.RoleTypeDao;
import com.spider.user.model.RoleType;
import com.spider.user.service.RoleTypeService;

@Service("roleTypeService")
public class RoleTypeServiceImpl implements RoleTypeService {
	
	@Autowired
	@Qualifier("roleTypeDao")
	private RoleTypeDao roleTypeDao;

	@Override
	public List<RoleType> getAllRoleTypes() {
		return roleTypeDao.findRoleTypes();
	}
	
	
}
