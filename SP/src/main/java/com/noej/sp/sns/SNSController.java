package com.noej.sp.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.noej.sp.TokenGenerator;
import com.noej.sp.member.MemberDAO;

@Controller
public class SNSController {

	@Autowired
	private TokenGenerator tg;

	@Autowired
	private MemberDAO mDAO;

	@Autowired
	private SNSDAO sDAO;

	@RequestMapping(value = "/sns.reply.delete", method = RequestMethod.GET)
	public String snsReplyDelete(SNSReply sr, @RequestParam(value = "page") int page, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.deleteReply(sr, req);
		}
		tg.generate(req);
		sDAO.get(page, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.delete", method = RequestMethod.GET)
	public String snsDelete(SNSMsg sm, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.delete(sm, req);
		}
		tg.generate(req);
		sDAO.get(1, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.search", method = RequestMethod.GET)
	public String snsSearch(HttpServletRequest req) {
		mDAO.isLogined(req);
		tg.generate(req);
		sDAO.search(req);
		sDAO.get(1, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.page.change", method = RequestMethod.GET)
	public String snsPage(@RequestParam(value = "page") int page, HttpServletRequest req) {
		mDAO.isLogined(req);
		tg.generate(req);
		// int page = Integer.parseInt(req.getParameter("page"));
		sDAO.get(page, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.update", method = RequestMethod.GET)
	public String snsUpdate(SNSMsg sm, @RequestParam(value = "page") int page, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.update(sm, req);
		}
		tg.generate(req);
		sDAO.get(page, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.reply.update", method = RequestMethod.GET)
	public String snsReplyUpdate(SNSReply sr, @RequestParam(value = "page") int page, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.updateReply(sr, req);
		}
		tg.generate(req);
		sDAO.get(page, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.write", method = RequestMethod.GET)
	public String snsWrite(SNSMsg sm, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.write(sm, req);
		}
		tg.generate(req);
		sDAO.clearSearch(req);
		sDAO.get(1, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.reply.write", method = RequestMethod.GET)
	public String snsReplyWrite(SNSReply sr, @RequestParam(value = "page") int page, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.writeReply(sr, req);
		}
		tg.generate(req);
		sDAO.get(page, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

}
