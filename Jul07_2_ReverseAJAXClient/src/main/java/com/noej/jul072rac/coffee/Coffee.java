package com.noej.jul072rac.coffee;

import java.math.BigDecimal;

public class Coffee {
	private String c_name;
	private BigDecimal c_price;
	
	public Coffee() {
		// TODO Auto-generated constructor stub
	}

	public Coffee(String c_name, BigDecimal c_price) {
		super();
		this.c_name = c_name;
		this.c_price = c_price;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public BigDecimal getC_price() {
		return c_price;
	}

	public void setC_price(BigDecimal c_price) {
		this.c_price = c_price;
	}
}
