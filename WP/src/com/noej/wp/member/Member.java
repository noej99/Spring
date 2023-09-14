package com.noej.wp.member;

import java.util.Date;

public class Member {
	private String wm_id;
	private String wm_pw;
	private String wm_name;
	private Date wm_birth;
	private String wm_addr;
	private String wm_photo;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String wm_id, String wm_pw, String wm_name, Date wm_birth, String wm_addr, String wm_photo) {
		super();
		this.wm_id = wm_id;
		this.wm_pw = wm_pw;
		this.wm_name = wm_name;
		this.wm_birth = wm_birth;
		this.wm_addr = wm_addr;
		this.wm_photo = wm_photo;
	}

	public String getWm_id() {
		return wm_id;
	}

	public void setWm_id(String wm_id) {
		this.wm_id = wm_id;
	}

	public String getWm_pw() {
		return wm_pw;
	}

	public void setWm_pw(String wm_pw) {
		this.wm_pw = wm_pw;
	}

	public String getWm_name() {
		return wm_name;
	}

	public void setWm_name(String wm_name) {
		this.wm_name = wm_name;
	}

	public Date getWm_birth() {
		return wm_birth;
	}

	public void setWm_birth(Date wm_birth) {
		this.wm_birth = wm_birth;
	}

	public String getWm_addr() {
		return wm_addr;
	}

	public void setWm_addr(String wm_addr) {
		this.wm_addr = wm_addr;
	}

	public String getWm_photo() {
		return wm_photo;
	}

	public void setWm_photo(String wm_photo) {
		this.wm_photo = wm_photo;
	}
}
