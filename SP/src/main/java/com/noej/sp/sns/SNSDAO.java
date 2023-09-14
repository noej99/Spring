package com.noej.sp.sns;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noej.sp.SPAttribute;
import com.noej.sp.member.Member;
import com.noej.sp.wc.WeatherColorDAO;

@Service
public class SNSDAO {

	@Autowired
	private SPAttribute sa;

	@Autowired
	private SqlSession ss;

	@Autowired
	private WeatherColorDAO wcDAO;
	
	

	private int allMsgCount;

	public void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}
	public String replaceParameter(String param) {

		String result = param;

		if(param != null) {

			result = result.replaceAll("<","&lt;");

			result = result.replaceAll(">","&gt;");

			result = result.replaceAll("$","&#36;");

			result = result.replaceAll("(","&#40;");

			result = result.replaceAll(")","&#41;");

		}

		return result;

	}


	
	public void delete(SNSMsg sm, HttpServletRequest req) {
		try {
			if(ss.getMapper(SNSMapper.class).delete(sm) == 1) {
				req.setAttribute("result", "삭제성공");
				allMsgCount--;
			} else {
				req.setAttribute("result", "삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "삭제실패");
		}
	}
	
	public void deleteReply(SNSReply sr, HttpServletRequest req) {
		try {
			if (ss.getMapper(SNSMapper.class).deleteReply(sr) == 1) {
				req.setAttribute("result", "댓글삭제성공");
			} else {
				req.setAttribute("result", "댓글삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "댓글삭제실패");
		}
	}
	
	public void get(int page, HttpServletRequest req) {
		try {
			int msgCount = allMsgCount;
			String search = (String) req.getSession().getAttribute("search");
			SNSSelector sSel = new SNSSelector(search, null, null);
			if (search == null) {
				sSel.setSearch("");
			} else {
				msgCount = ss.getMapper(SNSMapper.class).getMsgCount(sSel);
			}
			
			int pageCount = (int) Math.ceil(msgCount / (double) sa.getSnsMsgPerPage());
			int start = (page - 1) * sa.getSnsMsgPerPage() + 1;
			int end = sa.getSnsMsgPerPage() * page;
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("page", page);

			sSel.setStart(new BigDecimal(start));
			sSel.setEnd(new BigDecimal(end));

			List<SNSMsg> msgs = ss.getMapper(SNSMapper.class).get(sSel);
			for (SNSMsg snsMsg : msgs) {
				snsMsg.setSs_reply(ss.getMapper(SNSMapper.class).getReply(snsMsg));
			}
			req.setAttribute("msgs", msgs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setAllMsgCount() {
		SNSSelector sSel = new SNSSelector("", null, null);
		allMsgCount = ss.getMapper(SNSMapper.class).getMsgCount(sSel);
		System.out.println(allMsgCount);
	}

	public void setAllMsgCount(int msgCount) {
		allMsgCount -= msgCount;
	}

	public void search(HttpServletRequest req) {
		req.getSession().setAttribute("search", req.getParameter("search"));
	}

	public void update(SNSMsg sm, HttpServletRequest req) {
		try {
			String ss_txt = sm.getSs_txt();
			ss_txt = ss_txt.replace("\r\n", "<br>");
			sm.setSs_txt(ss_txt);
			
			if(ss.getMapper(SNSMapper.class).update(sm) == 1) {
				req.setAttribute("result", "수정성공");
			} else {
				req.setAttribute("result", "수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
		}
	}
	
	public void updateReply(SNSReply sr, HttpServletRequest req) {
		try {
			if(ss.getMapper(SNSMapper.class).updateReply(sr) == 1) {
				req.setAttribute("result", "댓글수정성공");
			} else {
				req.setAttribute("result", "댓글수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "댓글수정실패");
		}
	}
	
	public void write(SNSMsg sm, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("successToken");
			if (lastToken != null && token.equals(lastToken)) {
				req.setAttribute("result", "새로고침 오류");
				return;
			}

			Member m = (Member) req.getSession().getAttribute("loginMember");
			sm.setSs_writer(m.getSm_id());
			sm.setSs_txt(sm.getSs_txt().replace("\r\n", "<br>"));

			if (ss.getMapper(SNSMapper.class).write(sm) == 1) {
				req.setAttribute("result", "글쓰기성공");
				req.getSession().setAttribute("successToken", token);
				wcDAO.reg(sm);
				allMsgCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "글쓰기실패");
		}
	}
	

	public void writeReply(SNSReply sr, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("successToken");
			if (lastToken != null && token.equals(lastToken)) {
				req.setAttribute("result", "새로고침 오류");
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			sr.setSsr_writer(m.getSm_id());
			
			if (ss.getMapper(SNSMapper.class).writeReply(sr) == 1) {
				req.setAttribute("result", "댓글 성공");
				req.getSession().setAttribute("successToken", token);
			} else {
				req.setAttribute("result", "댓글 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "댓글 실패");
		}
	}
}
