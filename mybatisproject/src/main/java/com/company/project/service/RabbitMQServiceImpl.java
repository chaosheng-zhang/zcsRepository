package com.company.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.model.RabbitMQSender;

@Service
public class RabbitMQServiceImpl implements RabbitMQService {
	@Autowired
	private RabbitMQSender rabbitSerder;
	@Override
	public void send1(String msg) {
		
		for(int i=0;i<10;i++) {
			
			rabbitSerder.send1(msg);
		}

	}

	@Override
	public void send2(String msg) {
		// TODO Auto-generated method stub
		rabbitSerder.send2(msg);
	}

}
