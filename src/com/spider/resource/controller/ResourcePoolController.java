package com.spider.resource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.spider.resource.model.ResourcePool;
import com.spider.resource.service.ResourcePoolService;

@Controller
@RequestMapping("/resourcePool")
public class ResourcePoolController {
	
	@Autowired
	@Qualifier("resourcePoolService")
	private ResourcePoolService resourcePoolService;
	
	@RequestMapping(value="/find",method=RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody String findResourcePools(@RequestParam(value="platformId",required=false) String platformId,
												@RequestParam(value="name",required=false) String name) {
		List<ResourcePool> resourcePools = resourcePoolService.getResourcePools(platformId,name);
		JSONObject json = new JSONObject();
		json.put("resource", resourcePools);
		return json.toJSONString();
	}
}
