package com.noej.jun162smvc.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

// M/DAO : singleton

// servlet-context.xml에 자동등록
@Service
public class Calculator {
	
	public void calc(XY xy, HttpServletRequest req) {
		int z = xy.getX() + xy.getY();
		req.setAttribute("z", z);
	}
}
