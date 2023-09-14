package com.noej.jun132mb.main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// db orm
public class SelectMain {
	public static void main(String[] args) {
		SqlSession ss = null;
		try {
			// 설계도
			InputStream is = Resources.getResourceAsStream("a.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();
			
			List<Snack> snacks = ss.selectList("snackMapper.getSnack");
			
			for (Snack snack : snacks) {
				System.out.println(snack.getS_name());
				System.out.println(snack.getS_price());
				System.out.println("---------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
		}
		ss.close();
	}
}
