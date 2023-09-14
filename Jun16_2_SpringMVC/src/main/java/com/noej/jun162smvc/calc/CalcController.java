package com.noej.jun162smvc.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
  
@Controller
public class CalcController {
	// servlet-context.xml이 이미 aac방식으로 불러와지는중
	// 거기 등록해 놓은 그 하나의 Calculator객체와 자동연결
	@Autowired
	private Calculator c;
	
//	1) JSP st.
//	@RequestMapping(value="/calc.xy", method=RequestMethod.GET)
//	public String calc(HttpServletRequest req, HttpServletResponse res) {
//		int x = Integer.parseInt(req.getParameter("x")); 
//		int y = Integer.parseInt(req.getParameter("y"));
//		System.out.println(x);
//		System.out.println(y);
//		return "output";
//	}

//	2) Spring st.
//	@RequestMapping(value = "/calc.xy", method = RequestMethod.GET)
//	public String calc(@RequestParam(value = "x") int x, @RequestParam(value = "y") int y) {
//		System.out.println(x);
//		System.out.println(y);
//		return "output";
//	}
	
//	3) Spring st. (이걸 주로 쓸것)
	@RequestMapping(value = "/calc.xy", method = RequestMethod.GET)
	public String calc(XY xy, HttpServletRequest req) {
		c.calc(xy, req);
		return "output";
	}
}
