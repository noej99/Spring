package com.noej.jul031ja.shopping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class ShoppingDAO {

	public String get(HttpServletRequest req) {
		HttpsURLConnection huc = null;
		try {
			String q = req.getParameter("query");
			String start = req.getParameter("s");
			String h1 = req.getHeader("ni");
			String h2 = req.getHeader("ns");
			
			String s = "https://openapi.naver.com/v1/search/shop.xml?query=" + q + "&start=" + start;
			URL u = new URL(s);
			huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("X-Naver-Client-Id", h1);
			huc.addRequestProperty("X-Naver-Client-Secret", h2);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream(), "utf-8"));
			return br.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			huc.disconnect();
		}
	}
}
