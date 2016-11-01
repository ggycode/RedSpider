package com.spider.user.service.impl;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spider.user.dao.UserDao;
import com.spider.user.dao.impl.UserDaoImpl;
import com.spider.user.model.PageSource;
import com.spider.user.model.User;
import com.spider.user.service.UserService;
import com.spider.util.MD5Encrypt;
import com.spider.util.UUIDUtils;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	public UserServiceImpl(){
		logger.info("creating bean");
		System.out.println("create bean userService");
	}
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao; 
	
	@Override
	public void addUser(User user) {
		if(user.getUuid()==null){
			user.setUuid(UUIDUtils.getUuid());
		}
		if(user.getPassword() != null){
			user.setPassword(MD5Encrypt.encrypt(user.getPassword()));
		}
//		user.setRole("ROLE_USER");
		user.setState("enabled");
		user.setUserType("3");
		userDao.addUserInfo(user);
	}

	@Override
	public User getUserById(String id) {
		return userDao.getUserInfoById(id);
	}

	@Override
	public PageSource findUsersByCondition(PageSource page, String userName) {
		return userDao.getUsersByCondition(page,userName);
	}

	@Override
	public void updateUser(User user) {
		if(user.getPassword() != null){
			user.setPassword(MD5Encrypt.encrypt(user.getPassword()));
		}
		user.setUpdated(new Date());
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(String id) {
		userDao.deleteUser(id);
	}

	@Override
	public boolean checkUser(String userName) {
		User user = userDao.getUserInfoByName(userName);
		if(user != null){
			return true;
		}
		return false;
	}

	@Override
	public User getUserByName(String userName) {
		User user = userDao.getUserInfoByName(userName);
		return user;
	}

}
