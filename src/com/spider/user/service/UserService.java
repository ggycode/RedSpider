package com.spider.user.service;

import java.util.List;

import com.spider.user.model.PageSource;
import com.spider.user.model.User;

public interface UserService {
	public void addUser(User user);
	
	public User getUserById(String id);
	
	public User getUserByName(String userName);
	
	public PageSource findUsersByCondition(PageSource page, String userName);
	
	public void updateUser(User user);
	
	public void deleteUser(String id);
	
	public boolean checkUser(String userName);
	
}
