package com.company.project.dubbo;


import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.company.project.entity.User;

@Component
public class UserDubboConsumerService {
	
	@Reference(version = "1.0.0")
	UserDubboService userDubboService;
	
	public void printUser() {
		String name="zhangs";
		
		User user = userDubboService.findUserByName(name);
		
		System.out.println(user.toString());
		
	}

}
