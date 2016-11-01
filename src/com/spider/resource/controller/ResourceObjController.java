package com.spider.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.spider.resource.adapter.AdapterFactory;
import com.spider.resource.adapter.ResourceAdapter;
import com.spider.resource.model.ResourcePool;
import com.spider.resource.service.ResourcePoolService;
import com.spider.resource.service.ResourceQueryService;

@Controller
@RequestMapping("/resourceObj")
public class ResourceObjController {
	
	@Autowired
	@Qualifier("resourcePoolService")
	private ResourcePoolService resourcePoolService;
	
	@Autowired
	@Qualifier("adapterFactory")
	private AdapterFactory adapterFactory;
	
	@Autowired
	@Qualifier("resourceQueryService")
	private ResourceQueryService resourceQueryService;
	
	@RequestMapping(value="/ecs/describeInstances/{userId}",method=RequestMethod.GET)
	public String getEcsInstances(@PathVariable("userId") String userId,
								 @RequestParam(value="pageSize",required=false) String pageSize,
								 @RequestParam(value="pageNum",required=false) String pageNum,
								 @RequestParam(value="resourcePoolId",required=false) String resPoolId,
								 Model model){
		ResourcePool resourcePool = resourcePoolService.getResourcePoolById(resPoolId);
		ResourceAdapter adapter = adapterFactory.getAdapter(resPoolId);
		JSONObject json = resourceQueryService.describeEcsInstances(userId, adapter, resourcePool, pageSize, pageNum);
		model.addAttribute("resource", json);
		return "";
	}
}
