package com.spider.user.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.spider.user.model.PageSource;
import com.spider.user.model.RoleType;
import com.spider.user.model.User;
import com.spider.user.service.RoleTypeService;
import com.spider.user.service.UserService;
import com.spider.util.UUIDUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("roleTypeService")
	private RoleTypeService roleTypeService;
	
	@RequestMapping(value="/reload/add")
	public String reloadAdd(Model model){
		List<RoleType> roleTypes = roleTypeService.getAllRoleTypes();
		model.addAttribute("roleTypes", roleTypes);
		return "addUser";
	}
	
	@RequestMapping(value="/reload/update", method=RequestMethod.GET)
	public String reloadModify(@RequestParam("id") String id, Model model){
		User user = userService.getUserById(id);
		List<RoleType> roleTypes = roleTypeService.getAllRoleTypes();
		model.addAttribute("roleTypes", roleTypes);
		model.addAttribute("user", user);
		return "modifyUser";
	}
	
	@RequestMapping(value="/jump/page/modifyPassword")
	public String modifyPassJump(@RequestParam("id") String id, Model model){
		model.addAttribute("uuid", id);
		return "modifyPassword";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.PUT,headers="Accept=text/html,application/json")
	public @ResponseBody String deleteUser(@RequestParam("id") String id, Model model){
//		User user = userService.getUserById(id);
//		if(user != null){
//			user.setRemoved(new Date());
//			userService.updateUser(user);
//		}
//		return "userList";
		
		userService.deleteUser(id);
		return "ok";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT,headers="Content-Type=application/json")
	public @ResponseBody String modifyUser(@RequestBody User u, Model model){
		userService.updateUser(u);
//		return "redirect:findUser";
		return "ok";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST,headers="Content-Type=application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody String addUser(@RequestBody User user,Model model){
		logger.info("²ÎÊý£º"+user);
		if(userService.checkUser(user.getUserName())){
			return "user_name_exists";
		}
	    userService.addUser(user);
//		return "redirect:findUser";
		return "ok";
	}
	
	@RequestMapping(value="/findUser",method=RequestMethod.GET)
	public String getAllUser(@RequestParam(value="username",required=false) String userName,
							 @RequestParam(value="pageSize",required=false) String pageSize,
							 @RequestParam(value="pageNum",required=false) String pageNum,
							 Model model){
		PageSource page = new PageSource();
		page.setCurrentPage(Integer.parseInt(pageNum));
		page.setPageSize(Integer.parseInt(pageSize));
		page = userService.findUsersByCondition(page,userName);
		model.addAttribute("pageSource", page);
		return "userList";
	}
	
	@RequestMapping(value="/detail/{id}", method=RequestMethod.GET)
	public String userDetail(@PathVariable("id") String id, Model model){
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "detailUser";
	}
	
	@RequestMapping(value="/getUserInfo/userName/{userName}", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody User userDetail(@PathVariable("userName") String userName){
		User user = userService.getUserByName(userName);
		return user;
	}
	
}
