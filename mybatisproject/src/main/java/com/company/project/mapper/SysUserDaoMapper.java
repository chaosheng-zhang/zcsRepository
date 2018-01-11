package com.company.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.company.project.core.Mapper;
import com.company.project.model.SysUser;
import com.company.project.model.User;

public interface SysUserDaoMapper  {
	@Select("select * from sys_user where id = #{id}")
    public SysUser getSysUser(int id);
}
