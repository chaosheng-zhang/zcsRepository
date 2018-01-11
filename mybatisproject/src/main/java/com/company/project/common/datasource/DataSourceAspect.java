package com.company.project.common.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.company.project.dao.SysUserDao;
import com.company.project.dao.UserDao;

@Aspect
@Component
public class DataSourceAspect {
	
	 /**
	      * 使用空方法定义切点表达式
	      */
	     @Pointcut("execution(* com.company.project.dao.*.*(..))")
	     public void declareJointPointExpression() {
	     }
	 
	     /**
	      * 使用定义切点表达式的方法进行切点表达式的引入
	      */
	     @Before("declareJointPointExpression()")
	     public void setDataSourceKey(JoinPoint point) {
	         // 连接点所属的类实例是SysUserDao
	         if (point.getTarget() instanceof SysUserDao) {
	             DatabaseContextHolder.setDatabaseType(DatabaseType.sang);
	         } else {// 连接点所属的类实例是UserDao（当然，这一步也可以不写，因为defaultTargertDataSource就是该类所用的mytestdb）
	             DatabaseContextHolder.setDatabaseType(DatabaseType.test);
	         }
	     }

}
