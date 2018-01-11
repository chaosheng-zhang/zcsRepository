package com.company.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.company.project.dubbo.UserDubboConsumerService;

@SpringBootApplication
public class MybatisprojectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(MybatisprojectApplication.class, args);
//		UserDubboConsumerService cityService = run.getBean(UserDubboConsumerService.class);
//        cityService.printUser();
		
	}
}
