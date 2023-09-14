package com.noej.jun154sdi.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.noej.jun154sdi.dog.Dog;

// beans.xml에 객체 만들어놓은거고, java쪽에서는 불러오기만 하는거
// dlbf : 처음 부를 때(객체만들때) 만들뿐(생성자)
public class SDIMain {
	public static void main(String[] args) {
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(new ClassPathResource("beans.xml"));
		
		System.out.println("ㅋ");
		
		Dog dd = dlbf.getBean("d1", Dog.class);
		dd.setName("뽀삐");
		dd.setAge(3);
		dd.info();
		
		Dog ddd = dlbf.getBean("d1",Dog.class);
		ddd.setName("삐뽀");
		ddd.setAge(5);
		ddd.info();
		System.out.println(dd);
		System.out.println(ddd);
	}
}
