package com.noej.wp.sns;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

// join고려해서
public class SNSMsg {
	private BigDecimal ws_no;
	private String ws_writer;
	private String ws_txt;
	private Date ws_date;

	private String wm_photo;
	
	private List<SNSReply> replys;
	public SNSMsg() {
		// TODO Auto-generated constructor stub
	}

	public SNSMsg(BigDecimal ws_no, String ws_writer, String ws_txt, Date ws_date, String wm_photo) {
		super();
		this.ws_no = ws_no;
		this.ws_writer = ws_writer;
		this.ws_txt = ws_txt;
		this.ws_date = ws_date;
		this.wm_photo = wm_photo;
	}

	public BigDecimal getWs_no() {
		return ws_no;
	}

	public void setWs_no(BigDecimal ws_no) {
		this.ws_no = ws_no;
	}

	public String getWs_writer() {
		return ws_writer;
	}

	public void setWs_writer(String ws_writer) {
		this.ws_writer = ws_writer;
	}

	public String getWs_txt() {
		return ws_txt;
	}

	public void setWs_txt(String ws_txt) {
		this.ws_txt = ws_txt;
	}

	public Date getWs_date() {
		return ws_date;
	}

	public void setWs_date(Date ws_date) {
		this.ws_date = ws_date;
	}

	public String getWm_photo() {
		return wm_photo;
	}

	public void setWm_photo(String wm_photo) {
		this.wm_photo = wm_photo;
	}
	
	public List<SNSReply> getReplys() {
		return replys;
	}
	
	public void setReplys(List<SNSReply> replys) {
		this.replys = replys;
	}
}
