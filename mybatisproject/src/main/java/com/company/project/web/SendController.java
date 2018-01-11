package com.company.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.service.RabbitMQService;

@RestController
public class SendController {
	
	@Autowired
	private RabbitMQService  rabbitService;
	
	@RequestMapping("send1")
	public String send1(String msg) {
		
		rabbitService.send1(msg);
		return msg;
		
	}
	
	@RequestMapping("send2")
	public String send2(String msg) {
		rabbitService.send2(msg);
		return msg;
		
	}

}
