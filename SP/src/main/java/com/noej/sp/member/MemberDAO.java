package com.noej.sp.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noej.sp.sns.SNSDAO;
import com.noej.sp.sns.SNSMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// 원래
//		1) String 변수명 = req.getParameter("파라메터명");
//		2) 형변환
//		3) JavaBean객체로
//	SpringMVC가 1, 2, 3을 자동으로 해주는데		
//	파일업로드는 mr.getParameter("파라메터명")으로 시작이니..

// 날짜
// input 여러개 합치기
// 파일업로드
@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private SNSDAO sDAO;
	
	private SimpleDateFormat sdf;

	public MemberDAO() {
		sdf = new SimpleDateFormat("yyyyMMdd");
	}

	public Members getMemberIDByID(Member m) {
		return new Members(ss.getMapper(MemberMapper.class).getMemberIDByID(m));
	}
	
	public void delete(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			
			int msgCount = ss.getMapper(SNSMapper.class).getMsgCountByWriter(m);
			
			if (ss.getMapper(MemberMapper.class).delete(m) == 1) {
				req.setAttribute("result", "탈퇴성공");

				sDAO.setAllMsgCount(msgCount);
				
				String path = req.getSession().getServletContext().getRealPath("resources/img");
				String file = URLDecoder.decode(m.getSm_img(), "utf-8");
				new File(path + "/" + file).delete();
				
				logout(req);
				isLogined(req);
				
			} else {
				req.setAttribute("result", "탈퇴실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "탈퇴실패");
		}
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
	
	public void login(Member inputMember, HttpServletRequest req) {
		try {
			Member dbMember = ss.getMapper(MemberMapper.class).getMemberByID(inputMember);

			if (dbMember != null) {
				if (inputMember.getSm_pw().equals(dbMember.getSm_pw())) {
					req.getSession().setAttribute("loginMember", dbMember);
					req.getSession().setMaxInactiveInterval(15*60);
				} else {
					req.setAttribute("result", "잘못된 비밀번호");
				}
			} else {
				req.setAttribute("result", "없는 아이디");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "로그인오류");
		}
	}

	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}

	public void reg(Member m, HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		System.out.println(path);
		try {
			mr = new MultipartRequest(req, path, 31457280, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입실패(프사)");
			return;
		}

		try {
			m.setSm_id(mr.getParameter("sm_id"));
			m.setSm_pw(mr.getParameter("sm_pw"));
			m.setSm_name(mr.getParameter("sm_name"));
			String jumin1 = mr.getParameter("sm_jumin1");
			int jumin2 = Integer.parseInt(mr.getParameter("sm_jumin2"));
			if (jumin2 < 3) {
				jumin1 = "19" + jumin1;
			} else {
				jumin1 = "20" + jumin1;
			}
			m.setSm_birthday(sdf.parse(jumin1));

			String addr1 = mr.getParameter("sm_addr1");
			String addr2 = mr.getParameter("sm_addr2");
			String addr3 = mr.getParameter("sm_addr3");
			m.setSm_addr(addr2 + "!" + addr3 + "!" + addr1);

			String img = mr.getFilesystemName("sm_img");
			img = URLEncoder.encode(img, "utf-8");
			img = img.replace("+", " ");
			m.setSm_img(img);

			if (ss.getMapper(MemberMapper.class).reg(m) == 1) {
				req.setAttribute("result", "가입성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입실패");
			new File(path + "/" + mr.getFilesystemName("sm_img")).delete();
		}
	}

	public void splitAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String addr = m.getSm_addr();
		String[] addr2 = addr.split("!");
		req.setAttribute("addr1", addr2[2]);
		req.setAttribute("addr2", addr2[0]);
		req.setAttribute("addr3", addr2[1]);
	}
	
	public void update(Member newMember, HttpServletRequest req) {
		
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		try {
			mr = new MultipartRequest(req, path, 31457280, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			// 프사를 바꾸려고 하는데, 용량이 너무 큰거 선택했으면
			req.setAttribute("result", "수정실패(프사)");
			return;
		}
		// 프사를 바꾸려고 하는데, 적당한 용량 선택
		// 프사 안바꾸거나
		Member oldMember = (Member) req.getSession().getAttribute("loginMember");
		String oldFile = oldMember.getSm_img();
		String newFile = null;
		try {
			newMember.setSm_id(oldMember.getSm_id());
			newMember.setSm_pw(mr.getParameter("sm_pw"));
			newMember.setSm_name(mr.getParameter("sm_name"));
			String addr1 = mr.getParameter("sm_addr1");
			String addr2 = mr.getParameter("sm_addr2");
			String addr3 = mr.getParameter("sm_addr3");
			newMember.setSm_addr(addr2 + "!" + addr3 + "!" + addr1);
			newFile = mr.getFilesystemName("sm_img");
			if (newFile == null) {
				newFile = oldFile;
			} else {
				newFile = URLEncoder.encode(newFile, "utf-8").replace("+", " ");
			}
			newMember.setSm_img(newFile);
			
			if (ss.getMapper(MemberMapper.class).update(newMember) == 1) {
				req.setAttribute("result", "수정성공");
				if (!newFile.equals(oldFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
				newMember.setSm_birthday(oldMember.getSm_birthday());
				// newMember = ss.getMapper(MemberMapper.class).getMemberByID(newMember);
				req.getSession().setAttribute("loginMember", newMember);
			} else {
				req.setAttribute("result", "수정실패");
				if (!newFile.equals(oldFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패(DB)");
			if (!newFile.equals(oldFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				} catch (UnsupportedEncodingException e1) {
				}
			}
		}
	}
}
