package com.spider.test;


import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spider.user.model.User;
import com.spider.user.service.UserService;
import com.spider.util.MD5Encrypt;

public class UserTest {

	private static UserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:/Users/gaoguanyin/Workspaces/MyEclipse 8.5/RedSpider/WebRoot/WEB-INF/config/spring/applicationContext.xml");
		userService = (UserService) applicationContext.getBean("userService");
	}

	@Test
	public void testAddUser(){
		User user = new User();
		user.setUuid("asdfadfasf41555222asfa");
		user.setUserName("gaoguanyin");
		user.setPassword("12345678");
		user.setRole("ROLE_ADMIN");
		
		userService.addUser(user);
	}
	
	@Test
	public void testEncode(){
		String password = MD5Encrypt.encrypt("admin");
		System.out.println(password);
	}
}
