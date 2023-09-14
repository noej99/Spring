package com.noej.jun154sdi.human;

import com.noej.jun154sdi.dog.Dog;

public class Human {
	private String name;
	private int age;
	private Dog pet;
	
	public Human() {
	}

	public Human(String name, int age, Dog pet) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Dog getPet() {
		return pet;
	}

	public void setPet(Dog pet) {
		this.pet = pet;
	}
	public void info() {
		System.out.println(name);
		System.out.println(age);
		pet.info();
	}
}
