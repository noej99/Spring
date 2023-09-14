package com.noej.wp.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateManager {

	public static void getCurYear(HttpServletRequest req) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int cy = Integer.parseInt(sdf.format(new Date()));
		req.setAttribute("cy", cy);
	}
}
