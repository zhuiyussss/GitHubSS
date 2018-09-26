package com.banktransfer.dao.Support;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SqlSessionFactoryTemplate {
	@Autowired
	@Qualifier("sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private SqlSession session = null;

	public SqlSession CurrentSession(boolean isAutoCommit) {
		session = this.sqlSessionFactory.openSession(isAutoCommit);
		return session;

	}

	public void CloseSession() {
		this.session.close();
	}
}
