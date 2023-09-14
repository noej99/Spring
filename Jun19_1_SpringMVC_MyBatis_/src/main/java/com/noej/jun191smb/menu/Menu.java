package com.noej.jun191smb.menu;

import java.math.BigDecimal;

// DB - MyBatis- JavaBean객체
//	1) DB필드명, 멤버변수명 통일
//	2) OracleDB의 number타입은 BigDecimal

// 요청파라메터 - Spring - JavaBean객체
//	요청파라메터명, 멤버변수명 통일

public class Menu {
	private String m_name;
	private BigDecimal m_price;
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	public Menu(String m_name, BigDecimal m_price) {
		super();
		this.m_name = m_name;
		this.m_price = m_price;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public BigDecimal getM_price() {
		return m_price;
	}
	public void setM_price(BigDecimal m_price) {
		this.m_price = m_price;
	}
}
