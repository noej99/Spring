package com.noej.jun161sdi.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.noej.jun161sdi.phone.Phone;

// aac로
public class SDIMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans2.xml");
		aac.registerShutdownHook();
		
		Phone p = aac.getBean("p", Phone.class);
		p.info();
			
		aac.close();
	}
}
