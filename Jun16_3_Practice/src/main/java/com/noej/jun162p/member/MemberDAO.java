package com.noej.jun162p.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

// 날짜
// DB필드 1 : <input> x n
// 파일업로드
@Service
public class MemberDAO {
	private SimpleDateFormat sdf;
	private SimpleDateFormat sdf2;

	public MemberDAO() {
		sdf = new SimpleDateFormat("yyyyMMdd");
		sdf2 = new SimpleDateFormat("yyyy");
	}

	public void reg(Member m, HttpServletRequest req) {
		try {
			m.setBirth(sdf.parse(req.getParameter("birth2")));
			
			int birthYear = Integer.parseInt(sdf2.format(m.getBirth()));
			
			int curYear = Integer.parseInt(sdf2.format(new Date()));
			
			m.setAge(curYear - birthYear + 1);
			
			req.setAttribute("m", m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
