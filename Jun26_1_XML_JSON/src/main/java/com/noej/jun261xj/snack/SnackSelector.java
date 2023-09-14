package com.noej.jun261xj.snack;

import java.math.BigDecimal;

public class SnackSelector {
	private BigDecimal start;
	private BigDecimal end;
	public SnackSelector() {
		// TODO Auto-generated constructor stub
	}
	public SnackSelector(BigDecimal start, BigDecimal end) {
		super();
		this.start = start;
		this.end = end;
	}
	public BigDecimal getStart() {
		return start;
	}
	public void setStart(BigDecimal start) {
		this.start = start;
	}
	public BigDecimal getEnd() {
		return end;
	}
	public void setEnd(BigDecimal end) {
		this.end = end;
	}
}
