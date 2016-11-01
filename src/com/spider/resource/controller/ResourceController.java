package com.spider.resource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/resource")
public class ResourceController {
	
	@RequestMapping(value="/ecs/manage/table",method=RequestMethod.GET)
	public String toEcsManage(Model model){
		return "ecsResourceManage";
	}
}
