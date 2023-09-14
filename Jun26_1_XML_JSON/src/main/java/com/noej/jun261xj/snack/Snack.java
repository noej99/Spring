package com.noej.jun261xj.snack;

import java.math.BigDecimal;

public class Snack {
	private String s_name;
	private BigDecimal s_price;

	public Snack() {
		// TODO Auto-generated constructor stub
	}

	public Snack(String s_name, BigDecimal s_price) {
		super();
		this.s_name = s_name;
		this.s_price = s_price;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public BigDecimal getS_price() {
		return s_price;
	}

	public void setS_price(BigDecimal s_price) {
		this.s_price = s_price;
	}

}
