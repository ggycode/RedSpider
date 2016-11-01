package com.spider.user.dao;

import java.util.List;

import com.spider.user.model.PageSource;
import com.spider.user.model.User;

public interface UserDao {
	public void addUserInfo(User user);
	
	public User getUserInfoById(String id);
	
	public PageSource getUsersByCondition(PageSource page, String userName);
	
	public User getUserInfoByName(String userName);
	
	public void updateUser(User user);
	
	public void deleteUser(String id);
	
}
