package com.spider.product.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spider.product.dao.ProductSpecDao;
import com.spider.product.model.ProductSpec;
import com.spider.product.service.ProductSpecService;

@Transactional
@Service("productSpecService")
public class ProductSpecServiceImpl implements ProductSpecService {

	@Autowired
	@Qualifier("productSpecDao")
	private ProductSpecDao productSpecDao;
	
	@Override
	public List<ProductSpec> findProductSpecsByClause(String resType) {
		return productSpecDao.getProductSpecsByClause(resType);
	}

}
