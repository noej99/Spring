package com.noej.sp.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSReply {
	private BigDecimal ssr_no;
	private BigDecimal ssr_ss_no;
	private String ssr_writer;
	private String ssr_txt;
	private Date ssr_date;
	
	public SNSReply() {
	}

	public SNSReply(BigDecimal ssr_no, BigDecimal ssr_ss_no, String ssr_writer, String ssr_txt, Date ssr_date) {
		super();
		this.ssr_no = ssr_no;
		this.ssr_ss_no = ssr_ss_no;
		this.ssr_writer = ssr_writer;
		this.ssr_txt = ssr_txt;
		this.ssr_date = ssr_date;
	}

	public BigDecimal getSsr_no() {
		return ssr_no;
	}

	public void setSsr_no(BigDecimal ssr_no) {
		this.ssr_no = ssr_no;
	}

	public BigDecimal getSsr_ss_no() {
		return ssr_ss_no;
	}

	public void setSsr_ss_no(BigDecimal ssr_ss_no) {
		this.ssr_ss_no = ssr_ss_no;
	}

	public String getSsr_writer() {
		return ssr_writer;
	}

	public void setSsr_writer(String ssr_writer) {
		this.ssr_writer = ssr_writer;
	}

	public String getSsr_txt() {
		return ssr_txt;
	}

	public void setSsr_txt(String ssr_txt) {
		this.ssr_txt = ssr_txt;
	}

	public Date getSsr_date() {
		return ssr_date;
	}

	public void setSsr_date(Date ssr_date) {
		this.ssr_date = ssr_date;
	}
}
