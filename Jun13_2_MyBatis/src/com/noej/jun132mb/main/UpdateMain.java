package com.noej.jun132mb.main;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UpdateMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		SqlSession ss = null;
		try {
			// 설계도
			InputStream is = Resources.getResourceAsStream("a.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();

			System.out.println("얼마이상 : ");
			BigDecimal p1 = new BigDecimal(k.nextInt());
			System.out.println("얼마 할인 : ");
			BigDecimal p2 = new BigDecimal(k.nextInt());
			
			SnackUpdateValues sv = new SnackUpdateValues(p2, p1);
			
			int row = ss.update("snackMapper.updateSnack", sv);
			if (row == 1) {
				System.out.println("수정성공");
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정실패");
		}
		ss.close();
		k.close();
	}
}
