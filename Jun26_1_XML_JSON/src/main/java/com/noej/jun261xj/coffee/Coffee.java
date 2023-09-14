package com.noej.jun261xj.coffee;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// 데이터 하나를 표현

@XmlRootElement
public class Coffee {
	private String jc_name;
	private BigDecimal jc_price;
	public Coffee() {
		// TODO Auto-generated constructor stub
	}
	public Coffee(String jc_name, BigDecimal jc_price) {
		super();
		this.jc_name = jc_name;
		this.jc_price = jc_price;
	}
	public String getJc_name() {
		return jc_name;
	}
	
	@XmlElement
	public void setJc_name(String jc_name) {
		this.jc_name = jc_name;
	}
	public BigDecimal getJc_price() {
		return jc_price;
	}
	
	@XmlElement
	public void setJc_price(BigDecimal jc_price) {
		this.jc_price = jc_price;
	}
}
