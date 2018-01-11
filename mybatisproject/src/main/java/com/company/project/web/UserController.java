package com.company.project.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.company.project.model.SysUser;
import com.company.project.model.User;
import com.company.project.service.RedisService;
import com.company.project.service.UserTestService;


@RestController
public class UserController {
	protected static Logger logger=LoggerFactory.getLogger(UserController.class);  
//	@Autowired
//	private UserServiceImpl userService;
	@Autowired
	private RedisService redisService;
	@Autowired
	private UserTestService testService;
	
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public @ResponseBody String getResult() {
		System.out.println("进入server方法name=");
		JSONObject jsonObject = new JSONObject();  
        jsonObject.put("msg", "更新人员信息成功");
        
        User user = new User();
        user.setId(10L);
        user.setName("zhangcs");
        user.setPassword("111111");
//        userService.save(user);
        User user1 = testService.findById(1);
        System.out.println("user.name=="+user1.getUsername());
        return jsonObject.toString();
	}
	@RequestMapping(value = "/result/{name}")
	public @ResponseBody String addRedis(@PathVariable String name) {
		System.out.println("进入addRedis方法");
		redisService.set("name", name);
		JSONObject jsonObject = new JSONObject();  
		jsonObject.put("msg", "添加人员信息成功");
		return jsonObject.toString();
		
	}
	@RequestMapping(value = "/getresult/{name}")
	public @ResponseBody String getRedis(@PathVariable String name) {
		System.out.println("进入getRedis方法");
		String name1 = (String) redisService.get("username");
		System.out.println("name1=="+name1);
		JSONObject jsonObject = new JSONObject();  
		jsonObject.put("username", name1);
		return jsonObject.toString();
		
	}

}
