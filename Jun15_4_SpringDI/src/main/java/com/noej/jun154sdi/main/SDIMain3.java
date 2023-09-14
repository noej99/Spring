package com.noej.jun154sdi.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.noej.jun154sdi.dog.Dog;

public class SDIMain3 {
	public static void main(String[] args) {
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(new ClassPathResource("beans.xml"));
		
		Dog d = dlbf.getBean("d1", Dog.class);
		d.info();
		System.out.println("---------------");
		
		Dog dd = dlbf.getBean("d2", Dog.class);
		dd.info();
		System.out.println("---------------");
		Dog ddd = dlbf.getBean("d3", Dog.class);
		ddd.info();
	}
}
