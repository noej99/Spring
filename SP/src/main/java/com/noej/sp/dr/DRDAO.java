package com.noej.sp.dr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noej.sp.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class DRDAO {

	@Autowired
	private SqlSession ss;

	public void delete(DataroomFile df, HttpServletRequest req) {
		try {
			String file = ss.getMapper(DRMapper.class).getFile(df);
			if (ss.getMapper(DRMapper.class).delete(df) == 1) {
				req.setAttribute("result", "삭제성공");
				String path = req.getSession().getServletContext().getRealPath("resources/file");
				file = URLDecoder.decode(file, "utf-8");
				new File(path + "/" + file).delete();
			} else {
				req.setAttribute("result", "삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "삭제실패");
		}
	}

	public void download(DataroomFile df, HttpServletRequest req, HttpServletResponse res) {
		// byte단위로
		FileInputStream fis = null;	// 파일에서 내용 읽어내서(쌩 java로)
		ServletOutputStream sos = null;	// 클라이언트에게 응답(tomcat)
		try {
			String folder = req.getSession().getServletContext().getRealPath("resources/file");
			String file = df.getSd_file(); // 한글처리되어있는 상태
			String fileOG = URLDecoder.decode(file, "utf-8"); // 원래대로
			System.out.println(fileOG);
			fis = new FileInputStream(folder + "/" + fileOG);
			
			// 응답에 혹시 뭔가 들어가있을까봐
			res.reset(); // 응답객체 비우기
			
			// html을 응답할게 아니고, 파일을 줄거니까
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition", "attachment;filename=" + file);	// tomcat쪽이라서 인코딩된걸로
			
			sos = res.getOutputStream();
			
			byte[] b = new byte[4096];	// 4096byte(4kbyte)씩 처리하려고
										// 왜 4096? 다른숫자 넣어도 되는데 남들 다 저렇게 해서
										// (연구결과 저만큼씩 하는게 제일 낫다)
			int data = 0;
			// 0~4095번까지 읽어서 b에 저장
			// b에 저장한거를 data에 저장
			// data가 저장된게 없지 않을동안 반복
			while ((data = fis.read(b, 0, b.length)) != -1) {
				// b에 저장된거를 응답
				sos.write(b, 0, b.length);
			}
			sos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			sos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void get(HttpServletRequest req) {
		try {
			List<DataroomFile> df1 = ss.getMapper(DRMapper.class).get1();
			req.setAttribute("df1", df1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			List<DataroomFile> df2 = ss.getMapper(DRMapper.class).get2();
			req.setAttribute("df2", df2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			List<DataroomFile> df3 = ss.getMapper(DRMapper.class).get3();
			req.setAttribute("df3", df3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			List<DataroomFile> df4 = ss.getMapper(DRMapper.class).get4();
			req.setAttribute("df4", df4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upload(DataroomFile df, HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		System.out.println(path);
		try {
			mr = new MultipartRequest(req, path, 31457280, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "업로드실패");
		}
		try {
			String token = mr.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("successToken");
			if (lastToken != null && token.equals(lastToken)) {
				req.setAttribute("result", "새로고침 오류");
				return;
			}

			Member m = (Member) req.getSession().getAttribute("loginMember");
			df.setSd_uploader(m.getSm_id());
			df.setSd_title(mr.getParameter("sd_title"));
			df.setSd_category(mr.getParameter("sd_category"));
			String sd_file = URLEncoder.encode(mr.getFilesystemName("sd_file"), "utf-8").replace("+", " ");
			df.setSd_file(sd_file);

			if (ss.getMapper(DRMapper.class).upload(df) == 1) {
				req.setAttribute("result", "업로드성공");
				req.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "업로드실패");
			new File(path + "/" + mr.getFilesystemName("sd_file")).delete();
		}
	}
}
