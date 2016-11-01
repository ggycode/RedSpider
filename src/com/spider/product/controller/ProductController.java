package com.spider.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.functors.FalsePredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spider.product.model.ProductSpec;
import com.spider.product.model.ProductSpecValue;
import com.spider.product.service.ProductSpecService;

@Controller
@RequestMapping("product")
public class ProductController {
	private Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	@Qualifier("productSpecService")
	private ProductSpecService productSpecService;
	
	@RequestMapping(value="/skipto/order/page",method=RequestMethod.GET)
	public String toOrderResource(@RequestParam(value="resType",required=false) String resType, Model model){
		List<ProductSpec> productSpecs = productSpecService.findProductSpecsByClause(resType);
		Set<ProductSpecValue> values = productSpecs.get(0).getProductSpecValues();
		model.addAttribute("productSpecList", productSpecs);
		return resType+"OrderPage";
	}
}
