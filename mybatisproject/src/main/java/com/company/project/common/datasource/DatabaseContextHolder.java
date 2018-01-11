package com.company.project.common.datasource;
/**
 * 
 * @author: zhangcs
 * @Description: 保存一个线程安全的DatabaseType容器
 * 构建一个DatabaseType容器，并提供了向其中设置和获取DatabaseType的方法
 * @date: 2018年1月10日 上午9:55:12
 */
public class DatabaseContextHolder {
	private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();
	
	public static void setDatabaseType(DatabaseType type){
	         contextHolder.set(type);
	}
	     
	public static DatabaseType getDatabaseType(){
		 return contextHolder.get();
	}

}
