package com.noej.wp.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.noej.db.manager.NoejDBManager;
import com.noej.wp.sns.SNSDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {
	private static final MemberDAO MDAO = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getMdao() {
		return MDAO;
	}

	public void register(HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("img");
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입 실패(파일)");
		}

		SqlSession ss = null;
		try {
			ss = NoejDBManager.getNdbm().connect();
			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String y = mr.getParameter("y");
			String m = mr.getParameter("m");
			int mm = Integer.parseInt(m);
			String d = mr.getParameter("d");
			int dd = Integer.parseInt(d);
			String birth = String.format("%s%02d%02d", y, mm, dd);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date birth2 = sdf.parse(birth);
			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String addr = addr2 + "!" + addr3 + "!" + addr1;
			String photo = mr.getFilesystemName("photo");
			photo = URLEncoder.encode(photo, "utf-8");
			photo = photo.replace("+", " ");

			Member member = new Member(id, pw, name, birth2, addr, photo);

			if (ss.insert("memberMapper.reg", member) == 1) {
				req.setAttribute("result", "가입 성공");
				ss.commit();
			} else {
				req.setAttribute("result", "가입 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입 실패(DB)");
			new File(path + "/" + mr.getFilesystemName("photo")).delete();
		}
		ss.close();
	}

	public void login(HttpServletRequest req) {
		SqlSession ss = null;
		try {
			ss = NoejDBManager.getNdbm().connect();

			req.setCharacterEncoding("utf-8");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");

			Member inputMember = new Member(id, pw, null, null, null, null);

			Member dbMember = ss.selectOne("memberMapper.login", inputMember);

			if (dbMember != null) {
				if (inputMember.getWm_pw().equals(dbMember.getWm_pw())) {
					req.getSession().setAttribute("loginMember", dbMember);
					req.getSession().setMaxInactiveInterval(30*60);
					req.setAttribute("result", "로그인 성공");
				} else {
					req.setAttribute("result", "로그인 실패(pw)");
				}
			} else {
				req.setAttribute("result", "로그인 실패(미가입)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "로그인 실패(DB)");
		}
		ss.close();
	}

	public boolean isLogined(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "member/logined.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}

	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}

	public void bye(HttpServletRequest req) {
		SqlSession ss = null;
		try {
			ss = NoejDBManager.getNdbm().connect();
			Member m = (Member) req.getSession().getAttribute("loginMember");
			// int msgCount = SNSDAO.getSdao().getMemberMsgCount(id);

			if (ss.delete("memberMapper.bye", m) == 1) {
				req.setAttribute("result", "탈퇴성공");
				ss.commit();
				String path = req.getSession().getServletContext().getRealPath("img");
				String photo = URLDecoder.decode(m.getWm_photo(), "utf-8");
				new File(path + "/" + photo).delete();

				// SNSDAO.getSdao().setAllMsgCount(msgCount);
			} else {
				req.setAttribute("result", "탈퇴실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "탈퇴실패(DB)");
		}
		ss.close();
	}

	public void splitAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String addr = m.getWm_addr();
		String[] addrr = addr.split("!");
		req.setAttribute("addr1", addrr[2]);
		req.setAttribute("addr2", addrr[0]);
		req.setAttribute("addr3", addrr[1]);
	}

	public void update(HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("img");
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정 실패(파일)");
			return;
		}
		SqlSession ss = null;
		String oldFile = null;
		String newFile = null;
		try {
			ss = NoejDBManager.getNdbm().connect();
			Member m = (Member) req.getSession().getAttribute("loginMember");
			oldFile = m.getWm_photo();
			newFile = mr.getFilesystemName("photo");
			if (newFile == null) {
				newFile = oldFile;
			} else {
				newFile = URLEncoder.encode(newFile, "utf-8").replace("+", " ");
			}
			String id = m.getWm_id();
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String addr = addr2 + "!" + addr3 + "!" + addr1;

			Member update = new Member(id, pw, name, null, addr, newFile);

			if (ss.update("memberMapper.update", update) == 1) {
				req.setAttribute("result", "수정 성공");
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
				m.setWm_pw(pw);
				m.setWm_name(name);
				m.setWm_addr(addr);
				m.setWm_photo(newFile);
				req.getSession().setAttribute("loginMember", m);
			} else {
				req.setAttribute("result", "수정 실패");
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정 실패(DB)");
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				new File(path + "/" + newFile).delete();
			}
		}
		ss.close();
	}
}
