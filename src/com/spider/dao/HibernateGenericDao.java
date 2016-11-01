package com.spider.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.spider.user.model.PageSource;

public interface HibernateGenericDao<T> {
	public void setMySessionFactory(SessionFactory sessionFactory);
	
	 ////��ҳ����
    public PageSource findPage(PageSource page, String hql);
}
