package com.noej.jun261xj.snack;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SnackController {
	
	@Autowired
	private SnackDAO sDAO;
	
	@RequestMapping(value = "/snack.get", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Snacks snackGet(@RequestParam(value="page") int page, HttpServletResponse res) {
		// 외부인에게 XML/JSON응답하게 *은 IP주소자리
		res.setHeader("Access-Control-Allow-Origin", "*");
		return sDAO.get2(page);
	}
}
