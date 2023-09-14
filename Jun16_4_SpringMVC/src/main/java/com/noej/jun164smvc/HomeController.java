package com.noej.jun164smvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
		public String home() {
		// String으로된 계산식 계산 
		//		Java는 불가능한데, JavaScript는 가능(eval())
		//		Java가 JavaScript를 가져다 쓰는게 가능
//		try {
//		ScriptEngineManager sem = new ScriptEngineManager();
//		ScriptEngine se = sem.getEngineByName("javascript");
//		String s = "1+2+3+4+5+6+7+8+9";
//			System.out.println(se.eval(s));
//		} catch (ScriptException e) {
//			e.printStackTrace();
//		}
		return "input";
	}
	
}
