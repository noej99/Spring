package com.noej.sp.gallery;

import java.math.BigDecimal;
import java.util.Date;

public class Gallery {
	private BigDecimal sg_no;
	private String sg_writer;
	private String sg_txt;
	private String sg_img;
	private Date sg_date;
	
	public Gallery() {
	}

	public Gallery(BigDecimal sg_no, String sg_writer, String sg_txt, String sg_img, Date sg_date) {
		super();
		this.sg_no = sg_no;
		this.sg_writer = sg_writer;
		this.sg_txt = sg_txt;
		this.sg_img = sg_img;
		this.sg_date = sg_date;
	}

	public BigDecimal getSg_no() {
		return sg_no;
	}

	public void setSg_no(BigDecimal sg_no) {
		this.sg_no = sg_no;
	}

	public String getSg_writer() {
		return sg_writer;
	}

	public void setSg_writer(String sg_writer) {
		this.sg_writer = sg_writer;
	}

	public String getSg_txt() {
		return sg_txt;
	}

	public void setSg_txt(String sg_txt) {
		this.sg_txt = sg_txt;
	}

	public String getSg_img() {
		return sg_img;
	}

	public void setSg_img(String sg_img) {
		this.sg_img = sg_img;
	}

	public Date getSg_date() {
		return sg_date;
	}

	public void setSg_date(Date sg_date) {
		this.sg_date = sg_date;
	}
}
