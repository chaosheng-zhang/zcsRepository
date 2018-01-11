package com.company.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.company.project.core.Mapper;
import com.company.project.model.User;

public interface UserDaoMapper  {
	@Select("select * from user where id = #{state}")
    public User getUser(Integer state);
}
