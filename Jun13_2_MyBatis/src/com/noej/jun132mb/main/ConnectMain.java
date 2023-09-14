package com.noej.jun132mb.main;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// MyBatis :  
//		Java + DB 유지보수 용이
//		DB ORM(Object Relationship Mapping) Framework

//					DB연결정보		SQL
// JDBC				.java			.java
// ConnectionPool	.xml			.java
// MyBatis			???.xml			???.xml
// ~2 : iBatis
// 3~ : MyBatis

// Maven프로젝트로 바꾸고
// OracleDB서버	-> ojdbc8.jar
// MyBatis		-> mybatis.jar		

public class ConnectMain {
	public static void main(String[] args) {
		// Connection con = null;
		SqlSession ss = null;
		try {
			// 설계도
			InputStream is = Resources.getResourceAsStream("a.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();
			
			System.out.println("성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
