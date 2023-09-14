package com.noej.jun261xj.coffee;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// DB테이블을 표현하는 JavaBean

@XmlRootElement
public class Coffees {
	// 변수명은 단수형 추천
	private List<Coffee> coffee;
	public Coffees() {
		// TODO Auto-generated constructor stub
	}
	public Coffees(List<Coffee> coffee) {
		super();
		this.coffee = coffee;
	}
	public List<Coffee> getCoffee() {
		return coffee;
	}
	
	@XmlElement
	public void setCoffee(List<Coffee> coffee) {
		this.coffee = coffee;
	}
}
