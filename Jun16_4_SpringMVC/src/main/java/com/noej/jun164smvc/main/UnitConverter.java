package com.noej.jun164smvc.main;

import java.util.ArrayList;
import java.util.HashMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

// @Service
public class UnitConverter {
	private HashMap<String, ArrayList<String>> hm;
	private ScriptEngine se;

	public UnitConverter() {
//		hm = new HashMap<String, ArrayList<String>>();
//		hm.put("len", new String[] { "cm", "inch", "n * 0.393701" });
//		hm.put("size", new String[] { "㎡", "평", "n * 0.3025" });
//		hm.put("temp", new String[] { "℃", "℉", "(n * (9 / 5)) + 32" });
//		hm.put("spd", new String[] { "km/h", "mi/h", "n * 0.621371" });
		se = new ScriptEngineManager().getEngineByName("javascript");
	}

	public HashMap<String, ArrayList<String>> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, ArrayList<String>> hm) {
		this.hm = hm;
	}

	public void convert(UCResult ucr, HttpServletRequest request) {
		try {
			double from = ucr.getFrom();
			ArrayList<String> unitAr = hm.get(ucr.getWhat());
			ucr.setFromUnit(unitAr.get(0));
			ucr.setToUnit(unitAr.get(1));
			String sik = unitAr.get(2).replace("n", from + "");
			Object o = se.eval(sik);
			double i = (Double) o;
			ucr.setTo(i);

			request.setAttribute("ucr", ucr);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
}
