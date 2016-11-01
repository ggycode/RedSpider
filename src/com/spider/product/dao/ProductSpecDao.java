package com.spider.product.dao;

import java.util.List;
import java.util.Map;

import com.spider.product.model.ProductSpec;

public interface ProductSpecDao {
	public List<ProductSpec> getProductSpecsByClause(String resType);
}
