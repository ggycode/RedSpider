package com.spider.user.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.spider.dao.impl.HibernateGenericDaoImpl;
import com.spider.user.dao.UserDao;
import com.spider.user.model.PageSource;
import com.spider.user.model.User;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Repository("userDao")
public class UserDaoImpl extends HibernateGenericDaoImpl<UserDaoImpl> implements UserDao {

	
	public UserDaoImpl(){
		System.out.println("create bean userDao");
	}
	
	@Override
	public void addUserInfo(User user) {
		logger.info("created:"+user.getCreated());
		getHibernateTemplate().save(user);
	}

	@Override
	public User getUserInfoById(String id) {
		List<User> userList = getHibernateTemplate().find("from User user where user.removed is null and user.uuid='" + id + "'");
		if(userList != null && userList.size() > 0){
			return userList.get(0);
		}
		return null;
	}

	@Override
	public PageSource getUsersByCondition(PageSource page, String userName) {
		String hql = "from User user where user.removed is null";
		if(userName != null && !"".equals(userName)){
			hql += " and userName like '%" + userName + "%'";
		}
//		List<User> userList = getHibernateTemplate().find(hql);
		return findPage(page, hql);
	}
	
	@Override
	public User getUserInfoByName(String userName) {
		List<User> userList = getHibernateTemplate().find("from User user where user.removed is null and user.userName='"+userName+"'");
		if(userList != null && userList.size() > 0){
			return userList.get(0);
		}
		return null;
	}

	@Override
	public void updateUser(User user) {
	//	getHibernateTemplate().update(user);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String hql = "update User set ";
		if (user.getUserName() != null) {
			hql += "userName='"+user.getUserName()+"',";
		}
		if(user.getPassword() != null){
			hql += "password='"+user.getPassword()+"',";
		}
		if(user.getRole() != null){
			hql += "role='"+user.getRole()+"',";
		}
		if(user.getEmail() != null){
			hql += "email='"+user.getEmail()+"',";
		}
		if(user.getPhoneNumber() != null){
			hql += "phoneNumber='"+user.getPhoneNumber()+"',";
		}
		if(user.getDescription() != null){
			hql += "description='"+user.getDescription()+"',";
		}
		if(user.getQq() != null){
			hql += "qq='"+user.getQq()+"',";
		}
		if(user.getSex() != null){
			hql += "sex='"+user.getSex()+"',";
		}
		if(user.getState() != null){
			hql += "state='"+user.getState()+"',";
		}
		if(user.getUserType() != null){
			hql += "userType='"+user.getUserType()+"',"; 
		}
		if(user.getAddress() != null){
			hql += "address='"+user.getAddress()+"',";
		}
		if(user.getUpdated() != null){
			String updateTime = df.format(user.getUpdated());
			hql += "updated='"+updateTime+"',";
		}
		if(user.getRemoved() != null){
			String removeTime = df.format(user.getRemoved());
			hql += "removed='"+removeTime+"',";
		}
		if(hql.endsWith(",")){
			hql = hql.substring(0, hql.length()-1);
		}
		hql += " where uuid='" + user.getUuid() + "'";
		Query query = this.getSession().createQuery(hql);
		query.executeUpdate();	
	}

	@Override
	public void deleteUser(String id) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String date = df.format(new Date());
		String hql = "update User set removed = '"+date+"' where uuid = '"+id+"'";
		Query query = this.getSession().createQuery(hql);
		query.executeUpdate();
	}

}
