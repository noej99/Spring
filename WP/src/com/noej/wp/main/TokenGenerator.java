package com.noej.wp.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class TokenGenerator {
	public static void generate(HttpServletRequest req) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
		req.setAttribute("token", sdf.format(new Date()));
	}
}
