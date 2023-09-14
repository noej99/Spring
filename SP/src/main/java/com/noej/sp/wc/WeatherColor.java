package com.noej.sp.wc;

import java.math.BigDecimal;

public class WeatherColor {
	private BigDecimal swc_temp;
	private BigDecimal swc_humidity;
	private String swc_description;
	private String swc_color;
	public WeatherColor() {
		// TODO Auto-generated constructor stub
	}
	public WeatherColor(BigDecimal swc_temp, BigDecimal swc_humidity, String swc_description, String swc_color) {
		super();
		this.swc_temp = swc_temp;
		this.swc_humidity = swc_humidity;
		this.swc_description = swc_description;
		this.swc_color = swc_color;
	}
	public BigDecimal getSwc_temp() {
		return swc_temp;
	}
	public void setSwc_temp(BigDecimal swc_temp) {
		this.swc_temp = swc_temp;
	}
	public BigDecimal getSwc_humidity() {
		return swc_humidity;
	}
	public void setSwc_humidity(BigDecimal swc_humidity) {
		this.swc_humidity = swc_humidity;
	}
	public String getSwc_description() {
		return swc_description;
	}
	public void setSwc_description(String swc_description) {
		this.swc_description = swc_description;
	}
	public String getSwc_color() {
		return swc_color;
	}
	public void setSwc_color(String swc_color) {
		this.swc_color = swc_color;
	}
}
