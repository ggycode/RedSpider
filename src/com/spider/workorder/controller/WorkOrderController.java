package com.spider.workorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spider.amqp.message.MessagePublisher;
import com.spider.workorder.model.WorkOrderBo;
import com.spider.workorder.service.WorkOrderService;

@Controller
@RequestMapping("/workorder")
public class WorkOrderController {
	
	@Autowired
	@Qualifier("workOrderService")
	private WorkOrderService workOrderService;
	
	@RequestMapping(value = "/add/workorders", method = RequestMethod.POST, headers="Content-Type=application/json")
	public @ResponseBody String createWorkOrder(@RequestBody WorkOrderBo workOrderBo,Model model){
		workOrderService.addWorkOrder(workOrderBo);
		return "ok";
	}
}
