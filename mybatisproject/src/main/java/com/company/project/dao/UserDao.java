package com.company.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.project.mapper.UserDaoMapper;
import com.company.project.model.User;

@Repository
public class UserDao {
	@Autowired
	private UserDaoMapper mapper;
	
	public User getUser(Integer id) {
		//DatabaseContextHolder.setDatabaseType(DatabaseType.test);
		
		return mapper.getUser(id);
		
	}
	
}
