package com.noej.jun191smb.menu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MenuController {
	
	@Autowired
	private MenuDAO mDAO;
	
	@RequestMapping(value = "/menu.reg", method = RequestMethod.GET)
	public String menuReg(Menu m, HttpServletRequest req) {
		mDAO.reg(m, req);
		mDAO.get(req);
		return "index";
	}
}
