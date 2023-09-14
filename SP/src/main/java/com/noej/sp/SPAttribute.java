package com.noej.sp;

public class SPAttribute {
	private int snsMsgPerPage;
	
	public SPAttribute() {
	}

	public SPAttribute(int snsMsgPerPage) {
		super();
		this.snsMsgPerPage = snsMsgPerPage;
	}

	public int getSnsMsgPerPage() {
		return snsMsgPerPage;
	}

	public void setSnsMsgPerPage(int snsMsgPerPage) {
		this.snsMsgPerPage = snsMsgPerPage;
	}
}
