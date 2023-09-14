package com.noej.jun132mb.main;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeleteMain2 {
	public static void main(String[] args) {
	Scanner k = new Scanner(System.in);
	SqlSession ss = null;
	try {
		InputStream is = Resources.getResourceAsStream("a.xml");
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(is);
		ss = ssf.openSession();

		System.out.println("가격 : ");
		int p = k.nextInt();
		BigDecimal pp = new BigDecimal(p);
		
		Snack s = new Snack(null, pp);
		
		int row = ss.delete("snackMapper.delSnack2", s);
		if (row >= 1) {
			System.out.println("삭제성공");
			ss.commit();
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("삭제실패");
	}
	ss.close();
	k.close();
	}
}
