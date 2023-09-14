package com.noej.jun132mb.main;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeleteMain {
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
		Snack s = new Snack(n, null);
		
		int row = ss.delete("snackMapper.delSnack", s);
		if (row == 1) {
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
