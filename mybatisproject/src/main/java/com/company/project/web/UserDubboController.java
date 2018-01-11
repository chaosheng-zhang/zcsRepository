package com.company.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.company.project.dubbo.UserDubboConsumerService;

@RestController
public class UserDubboController {
//	@Autowired
//	private UserDubboConsumerService userDubboService;
	
	private static ApplicationContext applicationContext;
	
	@RequestMapping(value = "/dubbomsg", method = RequestMethod.GET)
	public @ResponseBody String getDubboMsg() {
		System.out.println("进入server方法");
		JSONObject jsonObject = new JSONObject();  
        jsonObject.put("msg", "更新人员信息成功");
        
        UserDubboConsumerService userDubboService = applicationContext.getBean(UserDubboConsumerService.class);
        
        userDubboService.printUser();
        return jsonObject.toString();
	}

}
