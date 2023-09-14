package com.noej.db.manager;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class NoejDBManager {
	private SqlSessionFactory ssf;
	
	private static final NoejDBManager NDBM = new NoejDBManager();
	
	private NoejDBManager() {
	}

	public static NoejDBManager getNdbm() {
		return NDBM;
	}
	
	public void setSsf(String cfgFile) {
		try {
			InputStream is = Resources.getResourceAsStream(cfgFile);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			ssf = ssfb.build(is);
		} catch (IOException e) {
		}
	}

	public SqlSession connect() {
		return ssf.openSession();
	}
}
