package com.noej.jun154sdi.dog;

// POJO
public class Dog {
	private String name;
	private int age;
	public Dog() {
		System.out.println("기본생성자");
	}
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("오버로딩된 생성자");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("세터");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void info() {
		System.out.println(name);
		System.out.println(age);
	}
}
