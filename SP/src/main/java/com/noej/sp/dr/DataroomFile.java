package com.noej.sp.dr;

import java.math.BigDecimal;
import java.util.Date;

public class DataroomFile {
	private BigDecimal sd_no;
	private String sd_uploader;
	private String sd_title;
	private String sd_file;
	private String sd_category;
	private Date sd_date;
	
	public DataroomFile() {
	}

	public DataroomFile(BigDecimal sd_no, String sd_uploader, String sd_title, String sd_file, String sd_category,
			Date sd_date) {
		super();
		this.sd_no = sd_no;
		this.sd_uploader = sd_uploader;
		this.sd_title = sd_title;
		this.sd_file = sd_file;
		this.sd_category = sd_category;
		this.sd_date = sd_date;
	}

	public BigDecimal getSd_no() {
		return sd_no;
	}

	public void setSd_no(BigDecimal sd_no) {
		this.sd_no = sd_no;
	}

	public String getSd_uploader() {
		return sd_uploader;
	}

	public void setSd_uploader(String sd_uploader) {
		this.sd_uploader = sd_uploader;
	}

	public String getSd_title() {
		return sd_title;
	}

	public void setSd_title(String sd_title) {
		this.sd_title = sd_title;
	}

	public String getSd_file() {
		return sd_file;
	}

	public void setSd_file(String sd_file) {
		this.sd_file = sd_file;
	}

	public String getSd_category() {
		return sd_category;
	}

	public void setSd_category(String sd_category) {
		this.sd_category = sd_category;
	}

	public Date getSd_date() {
		return sd_date;
	}

	public void setSd_date(Date sd_date) {
		this.sd_date = sd_date;
	}
}
