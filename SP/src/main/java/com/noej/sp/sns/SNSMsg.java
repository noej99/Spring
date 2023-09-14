package com.noej.sp.sns;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SNSMsg {

	private BigDecimal ss_no;
	private String ss_writer;
	private String ss_txt;
	private Date ss_date;
	private String ss_color;
	private String sm_img;

	private List<SNSReply> ss_reply;

	public SNSMsg() {
	}

	public SNSMsg(BigDecimal ss_no, String ss_writer, String ss_txt, Date ss_date, String ss_color, String sm_img,
			List<SNSReply> ss_reply) {
		super();
		this.ss_no = ss_no;
		this.ss_writer = ss_writer;
		this.ss_txt = ss_txt;
		this.ss_date = ss_date;
		this.ss_color = ss_color;
		this.sm_img = sm_img;
		this.ss_reply = ss_reply;
	}

	public BigDecimal getSs_no() {
		return ss_no;
	}

	public void setSs_no(BigDecimal ss_no) {
		this.ss_no = ss_no;
	}

	public String getSs_writer() {
		return ss_writer;
	}

	public void setSs_writer(String ss_writer) {
		this.ss_writer = ss_writer;
	}

	public String getSs_txt() {
		return ss_txt;
	}

	public void setSs_txt(String ss_txt) {
		this.ss_txt = ss_txt;
	}

	public Date getSs_date() {
		return ss_date;
	}

	public void setSs_date(Date ss_date) {
		this.ss_date = ss_date;
	}

	public String getSs_color() {
		return ss_color;
	}

	public void setSs_color(String ss_color) {
		this.ss_color = ss_color;
	}

	public String getSm_img() {
		return sm_img;
	}

	public void setSm_img(String sm_img) {
		this.sm_img = sm_img;
	}

	public List<SNSReply> getSs_reply() {
		return ss_reply;
	}

	public void setSs_reply(List<SNSReply> ss_reply) {
		this.ss_reply = ss_reply;
	}
}
