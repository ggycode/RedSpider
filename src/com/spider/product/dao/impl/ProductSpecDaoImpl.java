package com.spider.product.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spider.dao.impl.HibernateGenericDaoImpl;
import com.spider.product.dao.ProductSpecDao;
import com.spider.product.model.ProductSpec;
import com.spider.product.model.ProductSpecValue;
import com.spider.user.dao.impl.UserDaoImpl;

@Repository("productSpecDao")
public class ProductSpecDaoImpl extends HibernateGenericDaoImpl<ProductSpecDaoImpl> implements ProductSpecDao {

	@Override
	public List<ProductSpec> getProductSpecsByClause(String resType) {
		String hql = "select s from ProductSpec s,Product p where s.productId=p.productId and s.quitDate = null and s.status = '"+"1'";
		if (resType != null) {
			hql += " and p.resourceType = '"+resType+"'";
		}
		List<ProductSpec> productSpecs = getHibernateTemplate().find(hql);
		return productSpecs;
	}

}
