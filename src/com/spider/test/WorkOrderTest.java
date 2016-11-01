package com.spider.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spider.user.service.UserService;
import com.spider.workorder.dao.WorkOrderDao;
import com.spider.workorder.service.WorkOrderService;

public class WorkOrderTest {
	
	private static WorkOrderDao workOrderDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:/Users/gaoguanyin/Workspaces/MyEclipse 8.5/RedSpider/WebRoot/WEB-INF/config/spring/applicationContext.xml");
		workOrderDao = (WorkOrderDao) applicationContext.getBean("workOrderDao");
	}
	
	@Test
	public void testGetSequence(){
		String seq = workOrderDao.getSequence();
		System.out.println(seq);
	}
}
