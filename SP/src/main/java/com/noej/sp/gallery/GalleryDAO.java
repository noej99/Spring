package com.noej.sp.gallery;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noej.sp.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class GalleryDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void delete(Gallery g, HttpServletRequest req) {
		try {
			String img = ss.getMapper(GalleryMapper.class).getImg(g);
			if (ss.getMapper(GalleryMapper.class).delete(g) == 1) {
				req.setAttribute("result", "삭제성공");
				String path = req.getSession().getServletContext().getRealPath("resources/img");
				img = URLDecoder.decode(img, "utf-8");
				new File(path + "/" + img).delete();
			} else {
				req.setAttribute("result", "삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "삭제실패");
		}
	}
	
	public void get(HttpServletRequest req) {
		try {
			List<Gallery> images = ss.getMapper(GalleryMapper.class).get();
			req.setAttribute("images", images);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write(Gallery g, HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		try {
			mr = new MultipartRequest(req, path, 31457280, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "작성실패");
		}
		try {
			String token = mr.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("successToken");
			if (lastToken != null && token.equals(lastToken)) {
				req.setAttribute("result", "새로고침 오류");
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			g.setSg_writer(m.getSm_id());
			System.out.println(m.getSm_id());
			g.setSg_txt(mr.getParameter("sg_txt").replace("\r\n", "<br>"));
			String sg_img = URLEncoder.encode(mr.getFilesystemName("sg_img"), "utf-8").replace("+", " ");
			g.setSg_img(sg_img);
			
			if (ss.getMapper(GalleryMapper.class).write(g) == 1) {
				req.setAttribute("result", "작성성공");
				req.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "작성실패");
			new File(path + "/" + mr.getFilesystemName("sg_img")).delete();
		}
	}
}
