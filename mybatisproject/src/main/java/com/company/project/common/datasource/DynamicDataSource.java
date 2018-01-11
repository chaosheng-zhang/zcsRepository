package com.company.project.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
  * 动态数据源（需要继承AbstractRoutingDataSource）
  * 使用DatabaseContextHolder获取当前线程的DatabaseType
  */
public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return DatabaseContextHolder.getDatabaseType();
	}

}
