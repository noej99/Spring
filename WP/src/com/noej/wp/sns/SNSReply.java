package com.noej.wp.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSReply {
	private BigDecimal wsr_no;
	private BigDecimal wsr_ws_no;
	private String wsr_writer;
	private String wsr_txt;
	private Date wsr_date;
	
	public SNSReply() {
		// TODO Auto-generated constructor stub
	}
	public SNSReply(BigDecimal wsr_no, BigDecimal wsr_ws_No, String wsr_writer, String wsr_txt, Date wsr_date) {
		super();
		this.wsr_no = wsr_no;
		this.wsr_ws_no = wsr_ws_No;
		this.wsr_writer = wsr_writer;
		this.wsr_txt = wsr_txt;
		this.wsr_date = wsr_date;
	}
	public BigDecimal getWsr_no() {
		return wsr_no;
	}
	public void setWsr_no(BigDecimal wsr_no) {
		this.wsr_no = wsr_no;
	}
	public BigDecimal getWsr_ws_No() {
		return wsr_ws_no;
	}
	public void setWsr_ws_No(BigDecimal wsr_ws_No) {
		this.wsr_ws_no = wsr_ws_No;
	}
	public String getWsr_writer() {
		return wsr_writer;
	}
	public void setWsr_writer(String wsr_writer) {
		this.wsr_writer = wsr_writer;
	}
	public String getWsr_txt() {
		return wsr_txt;
	}
	public void setWsr_txt(String wsr_txt) {
		this.wsr_txt = wsr_txt;
	}
	public Date getWsr_date() {
		return wsr_date;
	}
	public void setWsr_date(Date wsr_date) {
		this.wsr_date = wsr_date;
	}
}
