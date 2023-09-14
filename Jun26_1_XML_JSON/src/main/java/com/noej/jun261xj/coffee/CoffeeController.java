package com.noej.jun261xj.coffee;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoffeeController {

	@Autowired
	private CoffeeDAO cDAO;

	// 기존 : index.jsp로 가자
	// 지금 : xml응답
	@RequestMapping(value = "/coffee.get", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody Coffees coffeeGet(HttpServletRequest req) {
		Coffees coffees = cDAO.get2();
		// index.jsp로 포워딩안하고 index라는 글자를 응답하고 싶을 때
		return coffees;
	}
}
