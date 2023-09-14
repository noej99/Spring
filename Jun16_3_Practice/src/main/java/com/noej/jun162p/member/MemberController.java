package com.noej.jun162p.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	// GET : 파라메터가 주소에
	//		인터넷 주소에는 한글들어가면 안됨
	//		ㅋ -> %2A(URL인코딩)
	//		ㅋ -utf-8-> %2A -utf-8-> ㅋ : 톰캣이 자동으로 함
	// => 톰캣설정(server.xml)으로 해결
	
	// POST : 파라메터가 내부적으로
	// 		파라메터 읽기전에 req.setCharacterEncoding("utf-8");
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value="/member.reg", method=RequestMethod.POST)
	public String memberReg(Member m, HttpServletRequest req) {
			mDAO.reg(m, req);
		return "output";
	}
}
