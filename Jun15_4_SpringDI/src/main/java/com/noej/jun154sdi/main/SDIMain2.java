package com.noej.jun154sdi.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// GarbageCollection : heap영역 자동정리시스템
//		그 자동 발동 시점 : 그 번지를 가리키는 변수가 없게 되면

// aac : 일단 다 만들어 놓음(생성자)

public class SDIMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans.xml");
		
		// aac가 없어질때 만들어놨던 객체들 없애라고
		aac.registerShutdownHook();
		
		
		System.out.println("ㅋ");
		
//		Dog dd = aac.getBean("d1", Dog.class);
//		dd.info();
		
		aac.close(); // aac없애기 -> 만들어놨던 객체 없애기
		
	}
}
