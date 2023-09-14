package com.noej.jun153s.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

// Java - JSP - EJB(Enterprise JavaBean)
//					Winter
// Spring : POJO를 사용, IoC로 DI해주는 Framework
//		POJO(Plain Old Java Object)를 사용
//		IoC(Inversion of Control)
//			제어권의 역전
//			프로그램 -제어-> 파일
//			파일 -제어-> 프로그램 v
//		DI(Dependency Injection)
//			의존성 주입
//			객체만들고 값 넣고

public class SMain {
	public static void main(String[] args) {
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(new ClassPathResource("hero.xml"));
		// Avengers aa = (Avengers) dlbf.getBean("a");
		Avengers aa =  dlbf.getBean("a", Avengers.class);
		aa.attack();
	}
}
