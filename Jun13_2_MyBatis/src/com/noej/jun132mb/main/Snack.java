package com.noej.jun132mb.main;

import java.math.BigDecimal;

// 원래는 하나하나해야하고 소스길고...
// library : 시키는대로 사용하면 자동으로 되는거
// framework : lib + 툴

// MyBatis의 ORM기능 발동조건
//		1) DB필드명과 멤버변수명 같게
//		2) (OracleDB한정) number타입은 BigDecimal로
//		3) 원래하던대로 생성자, getter/setter
//		4) 날짜는 java.util.Date
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
