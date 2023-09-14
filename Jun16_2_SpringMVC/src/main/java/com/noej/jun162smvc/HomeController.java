package com.noej.jun162smvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// JSP Model 2 : C가 Servlet
//			주소/프로젝트폴더명/컨트롤러명
//				doGet, doPost

// 주소/패키지마지막자리/마음대로
@Controller
public class HomeController {
	
	// te.st로 GET방식 요청받으면 이 메소드가 실행되게
	@RequestMapping(value="/te.st" , method=RequestMethod.GET)
	public void test() {
		System.out.println("요청");
	}

	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String goInput() {
		return "input"; // input.jsp로 포워딩
	}
	
	
}
