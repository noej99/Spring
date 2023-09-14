package com.noej.sp.dr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.noej.sp.TokenGenerator;
import com.noej.sp.member.MemberDAO;
import com.noej.sp.sns.SNSDAO;

@Controller
public class DRController {

	@Autowired
	private DRDAO dDA0;
	
	@Autowired
	private MemberDAO mDAO;

	@Autowired
	private TokenGenerator tg;

	@Autowired
	private SNSDAO sDAO;

	@RequestMapping(value = "/dr.download", method = RequestMethod.GET)
	public String drDownload(DataroomFile df, HttpServletRequest req, HttpServletResponse res) {
		if (mDAO.isLogined(req)) {
			dDA0.download(df, req, res);
			dDA0.get(req);
			req.setAttribute("contentPage", "dataRoom/dr.jsp");
		} else {
			dDA0.get(req);
			req.setAttribute("contentPage", "dataRoom/dr.jsp");
		}
		tg.generate(req);
		return "index";
	}
	
	@RequestMapping(value = "/dr.delete", method = RequestMethod.GET)
	public String drDelete(DataroomFile df, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			dDA0.delete(df, req);
		}
			tg.generate(req);
			dDA0.get(req);
			req.setAttribute("contentPage", "dataRoom/dr.jsp");
		return "index";
	}

	@RequestMapping(value = "/dr.go", method = RequestMethod.GET)
	public String drGo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			tg.generate(req);
			dDA0.get(req);
			req.setAttribute("contentPage", "dataRoom/dr.jsp");
		} else {
			tg.generate(req);
			sDAO.get(1, req);
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/dr.upload", method = RequestMethod.POST)
	public String drUpload(DataroomFile df, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			dDA0.upload(df, req);
		}
		tg.generate(req);
		dDA0.get(req);
		req.setAttribute("contentPage", "dataRoom/dr.jsp");
		return "index";
	}
}
