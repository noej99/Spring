package com.noej.sp.gallery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.noej.sp.TokenGenerator;
import com.noej.sp.member.MemberDAO;
import com.noej.sp.sns.SNSDAO;

@Controller
public class GalleryController {

	@Autowired
	private GalleryDAO gDAO;

	@Autowired
	private MemberDAO mDAO;

	@Autowired
	private TokenGenerator tg;

	@Autowired
	private SNSDAO sDAO;

	@RequestMapping(value = "/gallery.delete", method = RequestMethod.GET)
	public String galleryDelete(Gallery g, HttpServletRequest req) {
		if(mDAO.isLogined(req)) {
			gDAO.delete(g, req);
		}
		tg.generate(req);
		gDAO.get(req);
		req.setAttribute("contentPage", "gallery/gallery.jsp");
		return "index";
	}

	@RequestMapping(value = "/gallery.go", method = RequestMethod.GET)
	public String galleryGo(HttpServletRequest req) {
		if(mDAO.isLogined(req)) {
			tg.generate(req);
			gDAO.get(req);
			req.setAttribute("contentPage", "gallery/gallery.jsp");
		} else {
			tg.generate(req);
			sDAO.get(1, req);
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/gallery.write", method = RequestMethod.POST)
	public String galleryWrite(Gallery g, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			gDAO.write(g, req);
		}
		tg.generate(req);
		gDAO.get(req);
		req.setAttribute("contentPage", "gallery/gallery.jsp");
		return "index";
	}
}
