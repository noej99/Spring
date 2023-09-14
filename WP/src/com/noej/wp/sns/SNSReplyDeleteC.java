package com.noej.wp.sns;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.noej.wp.main.TokenGenerator;
import com.noej.wp.member.MemberDAO;

@WebServlet("/SNSReplyDeleteC")
public class SNSReplyDeleteC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.getMdao().isLogined(request)) {
			SNSDAO.getSdao().deleteReply(request);
		}
		TokenGenerator.generate(request);
		SNSDAO.getSdao().get(1, request);
		request.setAttribute("contentPage", "sns/sns.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
}
