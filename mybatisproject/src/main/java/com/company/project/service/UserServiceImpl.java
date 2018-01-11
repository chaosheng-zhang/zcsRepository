/*package com.company.project.service;

import java.util.List;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.core.AbstractService;
import com.company.project.mapper.UserDaoMapper;
import com.company.project.model.User;

import tk.mybatis.mapper.entity.Condition;
//@Service
public class UserServiceImpl extends AbstractService<User> {
	@Autowired
	private UserDaoMapper userDao;
	@Override
	public void save(User model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(List<User> models) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User model) {
		// TODO Auto-generated method stub
		
	}
	
	 * @Transactional添加事务
	 
	@Transactional
	@Override
	public User findById(Integer id) {
		User users = userDao.getUser(id);
		
		System.out.println("users=="+users.getName());
		return users;
	}

	@Override
	public User findBy(String fieldName, Object value) throws TooManyResultsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByCondition(Condition condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
*/