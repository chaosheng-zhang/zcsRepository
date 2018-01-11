package com.company.project.model;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQSender implements RabbitTemplate.ConfirmCallback{
	/**
     * 配置发送消息的rabbitTemplate，因为是构造方法，所以不用注解Spring也会自动注入（应该是新版本的特性）
     * @param rabbitTemplate
     */
	 private RabbitTemplate rabbitTemplate;
	 
	 public RabbitMQSender(RabbitTemplate rabbitTemplate) {
		 this.rabbitTemplate = rabbitTemplate;
	        //设置消费回调
	        this.rabbitTemplate.setConfirmCallback(this);
	 }
	 
	 /**
	     * 向消息队列1中发送消息
	     * @param msg
	     * @return
	     */
	 public String send1(String msg){
	        String uuid = UUID.randomUUID().toString();
	        System.out.println("uuid=="+uuid);
	        CorrelationData correlationId = new CorrelationData(uuid);
	        rabbitTemplate.convertAndSend("my-mq-exchange", "queue_one_key1", msg,
	                correlationId);
	        return null;
	    }
	 /**
	     * 向消息队列2中发送消息
	     * @param msg
	     * @return
	     */
	 public String send2(String msg){
	        String uuid = UUID.randomUUID().toString();
	        System.out.println("uuid1=="+uuid);
	        CorrelationData correlationId = new CorrelationData(uuid);
	        rabbitTemplate.convertAndSend("my-mq-exchange", "queue_one_key2", msg,
	                correlationId);
	        return null;
	    }
	 /**
	     * 消息的回调，主要是实现RabbitTemplate.ConfirmCallback接口
	     * 注意，消息回调只能代表成功消息发送到RabbitMQ服务器，不能代表消息被成功处理和接受
	     */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		// TODO Auto-generated method stub
		System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + cause+"\n重新发送");

        }
		
	}

}
