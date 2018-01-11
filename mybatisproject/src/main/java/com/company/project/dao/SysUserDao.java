package com.company.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.project.common.datasource.DatabaseContextHolder;
import com.company.project.common.datasource.DatabaseType;
import com.company.project.mapper.SysUserDaoMapper;
import com.company.project.mapper.UserDaoMapper;
import com.company.project.model.SysUser;
import com.company.project.model.User;

@Repository
public class SysUserDao {
	@Autowired
	private SysUserDaoMapper mapper;
	
	public SysUser getSysUser(int id) {
//		DatabaseContextHolder.setDatabaseType(DatabaseType.sang);
		return mapper.getSysUser(id);
		
	}
	
}
