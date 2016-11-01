package com.spider.product.service;

import java.util.List;
import java.util.Map;

import com.spider.product.model.ProductSpec;

public interface ProductSpecService {
	public List<ProductSpec> findProductSpecsByClause(String resType);
}
