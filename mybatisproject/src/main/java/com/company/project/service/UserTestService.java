package com.company.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.dao.UserDao;
import com.company.project.model.User;
@Service
public class UserTestService {
	@Autowired
	private UserDao userDao;
	/*
	 * @Transactional添加事务
	 */
	@Transactional
	public User findById(int id) {
		User users = userDao.getUser(id);
		
		System.out.println("users=="+users.getName());
		return users;
	}
	
	

}
