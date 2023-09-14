package com.noej.wp.sns;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.noej.db.manager.NoejDBManager;
import com.noej.wp.member.Member;

public class SNSDAO {
	private int allMsgCount;
	private int MsgPerPage;
	private static final SNSDAO SDAO = new SNSDAO();
	
	public SNSDAO() {
		MsgPerPage = 5;
	}

	public static SNSDAO getSdao() {
		return SDAO;
	}

	public void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}

	public void delete(HttpServletRequest req) {
		SqlSession ss = null;
		try {
			ss = NoejDBManager.getNdbm().connect();
			int no = Integer.parseInt(req.getParameter("no"));
			
			SNSMsg sm = new SNSMsg(new BigDecimal(no), null, null, null, null);
			
			if (ss.delete("snsMapper.delete", sm) == 1) {
				req.setAttribute("result", "글삭제 성공");
				ss.commit();
				allMsgCount--;
			} else {
				req.setAttribute("result", "글삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "글삭제 실패");
		}
		ss.close();
	}

	public void deleteReply(HttpServletRequest req) {
		SqlSession ss = null;
		try {
			ss = NoejDBManager.getNdbm().connect();
			int no = Integer.parseInt(req.getParameter("no"));
			
			SNSReply sr = new SNSReply(new BigDecimal(no), null, null, null, null);
			
			if (ss.delete("snsMapper.deleteReply", sr) == 1) {
				req.setAttribute("result", "댓글삭제 성공");
				ss.commit();
			} else {
				req.setAttribute("result", "댓글삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "댓글삭제 실패");
		}
		ss.close();
	}

	// Connection : 연결
	// PrepareStatement : DB작업 총괄 매니저(1회용)

	public void get(int page, HttpServletRequest req) {
		SqlSession ss = null;
		try {
			ss = NoejDBManager.getNdbm().connect();
			String search = (String) req.getSession().getAttribute("search");
			int msgCount = allMsgCount;
			if (search == null) {
				search = "";
			} else {
				SNSSelector sel2 = new SNSSelector(search, null, null);
				msgCount = ss.selectOne("snsMapper.getMsgCount", sel2);
			}
			int pageCount = (int) Math.ceil(msgCount / (double) MsgPerPage);
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("page", page);

			int start = (page - 1) * MsgPerPage + 1;
			int end = MsgPerPage * page;

			SNSSelector sel = new SNSSelector(search, new BigDecimal(start), new BigDecimal(end));
			List<SNSMsg> msgs = ss.selectList("snsMapper.get", sel);
			for (SNSMsg snsMsg : msgs) {
				snsMsg.setReplys(
						reply(snsMsg.getWs_no())
						);
			}
			req.setAttribute("msgs", msgs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}

	public List<SNSReply> reply(BigDecimal ws_no) {
		SqlSession ss = null;
		try {
			ss = NoejDBManager.getNdbm().connect();
			
			SNSReply sr = new SNSReply(null, ws_no, null, null, null);
			
			List<SNSReply> replys = ss.selectList("snsMapper.getReply", sr);
			return replys;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ss.close();	
		}
	}

	public void search(HttpServletRequest req) {
		String search = req.getParameter("search");
		req.getSession().setAttribute("search", search);
	}

	public void setAllMsgCount() {
		SqlSession ss = null;
		try {
			ss = NoejDBManager.getNdbm().connect();
			SNSSelector sel = new SNSSelector("", null, null);
			allMsgCount = ss.selectOne("snsMapper.getAllMsgCount", sel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}

	public void setAllMsgCount(int MsgCount) {
		System.out.println(allMsgCount);
		System.out.println(MsgCount);
		allMsgCount -= MsgCount;
		System.out.println(allMsgCount);
	}

	public void update(HttpServletRequest req) {
		SqlSession ss = null;
		try {
			ss = NoejDBManager.getNdbm().connect();
			
			int no = Integer.parseInt(req.getParameter("no"));
			String txt = req.getParameter("txt");

			SNSMsg sm = new SNSMsg(new BigDecimal(no), null, txt, null, null);

			if (ss.update("snsMapper.update", sm) == 1) {
				req.setAttribute("result", "글 수정 성공");
				ss.commit();
			} else {
				req.setAttribute("result", "글 수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "글 수정 실패");
		}
		ss.close();
	}

	public void updateReply(HttpServletRequest req) {
		SqlSession ss = null;
		try {
			ss = NoejDBManager.getNdbm().connect();
			
			int no = Integer.parseInt(req.getParameter("no"));
			String txt = req.getParameter("txt");

			SNSReply sr = new SNSReply(new BigDecimal(no), null, null, txt, null);
			
			if (ss.update("snsMapper.updateReply", sr) == 1) {
				req.setAttribute("result", "댓글 수정 성공");
				ss.commit();
			} else {
				req.setAttribute("result", "댓글 수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "댓글 수정 실패");
		}
		ss.close();
	}

	public void write(HttpServletRequest req) {
		SqlSession ss = null;
		try {
			String token = req.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("lastToken");

			if (lastToken != null && token.equals(lastToken)) {
				req.setAttribute("result", "글쓰기 실패(새로고침)");
				return;
			}
			ss = NoejDBManager.getNdbm().connect();
			Member m = (Member) req.getSession().getAttribute("loginMember");
			String writer = m.getWm_id();
			String txt = req.getParameter("txt");
			txt = txt.replace("\r\n", "<br>");

			SNSMsg sm = new SNSMsg(null, writer, txt, null, null);

			if (ss.insert("snsMapper.write", sm) == 1) {
				req.setAttribute("result", "글쓰기 성공");
				ss.commit();
				allMsgCount++;
				req.getSession().setAttribute("lastToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "글쓰기 실패");
		}
		ss.close();
	}

	public void writeReply(HttpServletRequest req) {
		SqlSession ss = null;
		try {
			String token = req.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("lastToken");
			if (lastToken != null && token.equals(lastToken)) {
				req.setAttribute("result", "댓글쓰기 실패");
				return;
			}

			ss = NoejDBManager.getNdbm().connect();
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			String id = m.getWm_id();
			int wsNo = Integer.parseInt(req.getParameter("ws_no"));
			String txt = req.getParameter("txt");

			SNSReply sr = new SNSReply(null,new BigDecimal(wsNo), id, txt, null);
			
			if (ss.insert("snsMapper.writeReply", sr) == 1) {
				req.setAttribute("result", "댓글쓰기 성공");
				req.getSession().setAttribute("lastToken", token);
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "댓글쓰기 실패");
		}
		ss.close();
	}
}
