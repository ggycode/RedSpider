package com.spider.dao.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import com.spider.dao.HibernateGenericDao;
import com.spider.user.model.PageSource;

public class HibernateGenericDaoImpl<T> extends HibernateDaoSupport implements HibernateGenericDao<T> {
	@Autowired  
	@Qualifier("sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory){  
	    super.setSessionFactory(sessionFactory);  
	}

	@Override
	public PageSource findPage(PageSource page, String hql) {
		Session session =  this.getSession();
        Query query =  session.createQuery(hql);
        query.setFirstResult((page.getCurrentPage()-1)*page.getPageSize());
        query.setMaxResults(page.getPageSize());
        List list =  query.list();
        page.setList(list);
        long count = countHqlResult(hql);
        page.setTotalRows(count);
        long totalPages = page.getTotalRows()%page.getPageSize() == 0 ? page.getTotalRows()/page.getPageSize() : page.getTotalRows()/page.getPageSize() + 1;
        page.setTotalPages(totalPages);
        return page;
	} 
	
	public long countHqlResult(String hql){
		String fromHql = hql;
		//select子句与order by子句会影响count查询,进行简单的排除.
		fromHql = "from " + StringUtils.substringAfter(fromHql, "from");
		fromHql = StringUtils.substringBefore(fromHql, "order by");
		String countHql = "select count(*) " + removeFetch(fromHql);
		return findUnique(countHql);
	}
	
	/**
	 * 去除hql的Fetch 子句，用于pagedQuery.
	 * 
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	private static String removeFetch(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("\\b(inner|out|left)\\s+join\\s+fetch\\b.+?[A-Za-z][A-Za-z0-9.]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	public <X> X findUnique(final String hql) {
		return (X) this.getSession().createQuery(hql).uniqueResult();
	}
}
