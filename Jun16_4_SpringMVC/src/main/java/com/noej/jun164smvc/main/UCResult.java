package com.noej.jun164smvc.main;

public class UCResult {
	private double from;
	private String fromUnit;
	private double to;
	private String toUnit;
	private String what;
	public UCResult() {
	}
	public UCResult(double from, String fromUnit, double to, String toUnit, String what) {
		super();
		this.from = from;
		this.fromUnit = fromUnit;
		this.to = to;
		this.toUnit = toUnit;
		this.what = what;
	}
	public double getFrom() {
		return from;
	}
	public void setFrom(double from) {
		this.from = from;
	}
	public String getFromUnit() {
		return fromUnit;
	}
	public void setFromUnit(String fromUnit) {
		this.fromUnit = fromUnit;
	}
	public double getTo() {
		return to;
	}
	public void setTo(double to) {
		this.to = to;
	}
	public String getToUnit() {
		return toUnit;
	}
	public void setToUnit(String toUnit) {
		this.toUnit = toUnit;
	}
	public String getWhat() {
		return what;
	}
	public void setWhat(String what) {
		this.what = what;
	}
}
