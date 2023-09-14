package com.noej.sp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.noej.sp.member.MemberDAO;
import com.noej.sp.sns.SNSDAO;

@Controller
public class HomeController {
	private boolean isFirstReq;
	
	@Autowired
	private SNSDAO sDAO;
	
	@Autowired
	private TokenGenerator tg;
	
	@Autowired
	private MemberDAO mDAO;
	
	// JVM이 OS위에 올라가고
	// -> static들 만들어지고
	// -> main으로 가서 시작
	
	// JSP Model 2 : 직접 다
	//		DAO singleton을 수동으로 작업
	//		-> static영역에
	//		-> DAO가 만들어지고 -> HomeController만들어짐
	
	// (Spring + Maven + MyBatis) Framework : 자동으로
	//		DAO singleton을 Spring이 자동으로
	//		-> static영역이 아님
	//		DAO를 servlet-context.xml에 하나 등록해놨음
	//		C도 servlet-context.xml에 하나 등록해놨음
	//		SqlSession도 servlet-context.xml에 하나 등록해놨음
	
	//		Spring : servlet-context.xml에 등록해놓으면 자동으로 객체 만들어줌
	//		DAO가 먼저? C가 먼저? SqlSession이 먼저?
	//		SqlSession -> DAO -> C
	public HomeController() {
		// sDAO.setAllMsgCount();
		isFirstReq = true;
	}
	
	// 서비스 시작해놓고
	// 어떤 사용자가 첫 접속때
	// 불리언으로 조정
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		if (isFirstReq) {
			sDAO.setAllMsgCount();
			isFirstReq = false;
		}
		mDAO.isLogined(req);
		tg.generate(req);
		sDAO.clearSearch(req);
		sDAO.get(1, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String indexDo(HttpServletRequest req) {
		return home(req);
	}
	
	
}
