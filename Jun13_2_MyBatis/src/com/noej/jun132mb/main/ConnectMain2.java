package com.noej.jun132mb.main;

import org.apache.ibatis.session.SqlSession;

import com.noej.db.manager.NoejDBManager;
// SqlSessionFactory는 한번만 만들어지는게 맞다

// 실행 -> static붙은것들 다 만들어지고 -> main
public class ConnectMain2 {
	public static void main(String[] args) {
		SqlSession ss = null;
		try {
			NoejDBManager.getNdbm().setSsf("a.xml");
			ss = NoejDBManager.getNdbm().connect();
			System.out.println("성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
