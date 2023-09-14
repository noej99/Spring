package com.noej.jun161sdi.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.noej.jun161sdi.snack.Snack;

// Spring
// aac방식
public class SDIMain {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans.xml");
		aac.registerShutdownHook();
		
//		Company c = aac.getBean("c1", Company.class);
//		c.info();
		Snack s = aac.getBean("s1", Snack.class);
		System.out.println(s.getName());
		System.out.println(s.getPrice());
		System.out.println(s.getMaker().getName());
		System.out.println(s.getMaker().getAddress());
		System.out.println(s.getMaker().getEmployeeCount());
		for (String str : s.getIngredient()) {
			System.out.println(str);
		}
		for (String stri : s.getFeature()) {
			System.out.println(stri);
		}
		System.out.println(s.getNutrient().get("나트륨"));
		System.out.println(s.getNutrient().get("탄수화물"));
		System.out.println(s.getNutrient().get("당류"));
		System.out.println(s.getNutrient().get("지방"));
		aac.close();
	}
}
