package com.noej.jun154sdi.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.noej.jun154sdi.human.Human;

public class SDIMain4 {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans.xml");
		aac.registerShutdownHook();
		
		System.out.println("---------");
		Human h = aac.getBean("h1", Human.class);
		h.info();
		System.out.println("---------");

		Human hh = aac.getBean("h2", Human.class);
		hh.info();
		System.out.println("---------");
		
		// 오늘 날짜
		// 2023/06/15 <- 이런 형식으로
		Date now = new Date(); // 현재시간날짜
		// 2023/06/15 -> 6월 15일
		SimpleDateFormat sdf = aac.getBean("sdf", SimpleDateFormat.class);
		String result = sdf.format(now);
		System.out.println(result);
		
		aac.close();
	}
}
