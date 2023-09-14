package com.noej.jun132mb.main;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InsertMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		SqlSession ss = null;
		try {
			// 설계도
			InputStream is = Resources.getResourceAsStream("a.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();

			System.out.println("이름 : ");
			String n = k.next();
			System.out.println("가격 : ");
			int p = k.nextInt();
			// int/double/string -> BigDecimal
			BigDecimal pp = new BigDecimal(p);
			// BigDecimal -> int
			int ppp = pp.intValue();
			
			Snack s = new Snack(n, pp);
			
			int row = ss.insert("snackMapper.regSnack", s);
			if (row == 1) {
				System.out.println("등록성공");
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("등록실패");
		}
		ss.close();
		k.close();
	}
}
