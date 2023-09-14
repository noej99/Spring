package com.noej.sp.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noej.sp.TokenGenerator;
import com.noej.sp.sns.SNSDAO;

@Controller
public class MemberController {

	@Autowired
	private SNSDAO sDAO;
	
	@Autowired
	private TokenGenerator tg;
	
	@Autowired
	private MemberDAO mDAO;

	@RequestMapping(value = "/member.get", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Members memberGet(Member m) {
		return mDAO.getMemberIDByID(m);
	}
	
	@RequestMapping(value = "/member.delete", method = RequestMethod.GET)
	public String memberDelete(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			mDAO.delete(req);
		}
		tg.generate(req);
		sDAO.clearSearch(req);
		sDAO.get(1, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.info.update", method = RequestMethod.POST)
	public String memberInfoUpdate(Member m, HttpServletRequest req) {
		if(mDAO.isLogined(req)) {
			mDAO.update(m, req);
			mDAO.splitAddr(req);
			req.setAttribute("contentPage", "member/info.jsp");
		}
		tg.generate(req);
		sDAO.clearSearch(req);
		sDAO.get(1, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.info.go", method = RequestMethod.GET)
	public String memberInfoGo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			mDAO.splitAddr(req);
			req.setAttribute("contentPage", "member/info.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		tg.generate(req);
		sDAO.clearSearch(req);
		sDAO.get(1, req);
		return "index";
	}

	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String memberLogin(Member m, HttpServletRequest req) {
		mDAO.login(m, req);
		mDAO.isLogined(req);
		tg.generate(req);
		sDAO.clearSearch(req);
		sDAO.get(1, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String memberLogout(Member m, HttpServletRequest req) {
		mDAO.logout(req);
		mDAO.isLogined(req);
		tg.generate(req);
		sDAO.clearSearch(req);
		sDAO.get(1, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.reg", method = RequestMethod.POST)
	public String memberReg(Member m, HttpServletRequest req) {
		mDAO.isLogined(req);
		mDAO.reg(m, req);
		tg.generate(req);
		sDAO.clearSearch(req);
		sDAO.get(1, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.reg.go", method = RequestMethod.GET)
	public String memberRegGo(HttpServletRequest req) {
		req.setAttribute("contentPage", "member/reg.jsp");
		mDAO.isLogined(req);
		return "index";
	}
}
