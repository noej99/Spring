package com.noej.sp.member;

import java.util.Date;

public class Member {
	private String sm_id;
	private String sm_pw;
	private String sm_name;
	private Date sm_birthday;
	private String sm_addr;
	private String sm_img;

	public Member() {
	}

	public Member(String sm_id, String sm_pw, String sm_name, Date sm_birthday, String sm_addr, String sm_img) {
		super();
		this.sm_id = sm_id;
		this.sm_pw = sm_pw;
		this.sm_name = sm_name;
		this.sm_birthday = sm_birthday;
		this.sm_addr = sm_addr;
		this.sm_img = sm_img;
	}

	public String getSm_id() {
		return sm_id;
	}

	public void setSm_id(String sm_id) {
		this.sm_id = sm_id;
	}

	public String getSm_pw() {
		return sm_pw;
	}

	public void setSm_pw(String sm_pw) {
		this.sm_pw = sm_pw;
	}

	public String getSm_name() {
		return sm_name;
	}

	public void setSm_name(String sm_name) {
		this.sm_name = sm_name;
	}

	public Date getSm_birthday() {
		return sm_birthday;
	}

	public void setSm_birthday(Date sm_birthday) {
		this.sm_birthday = sm_birthday;
	}

	public String getSm_addr() {
		return sm_addr;
	}

	public void setSm_addr(String sm_addr) {
		this.sm_addr = sm_addr;
	}

	public String getSm_img() {
		return sm_img;
	}

	public void setSm_img(String sm_img) {
		this.sm_img = sm_img;
	}
}
