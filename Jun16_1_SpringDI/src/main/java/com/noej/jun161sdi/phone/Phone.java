package com.noej.jun161sdi.phone;

import org.springframework.beans.factory.annotation.Autowired;

import com.noej.jun161sdi.company.Company;

// 세상에서 회사는 삼성만 : singleton
// 세상의 모든 폰은 삼성 : static

// @XXX : annotation
//		원래는 작업해야하는데,
//		어노테이션 쓰면 자동으로 처리됨
public class Phone {
	// beans2.xml에 등록되어있는
	// 그 하나뿐인 회사랑 자동연결
	// aac방식이어야만
	@Autowired
	private Company maker;
	
	// 생성자 x
	// getter/setter x 
	
	public void info() {
		maker.info();
	}
}
