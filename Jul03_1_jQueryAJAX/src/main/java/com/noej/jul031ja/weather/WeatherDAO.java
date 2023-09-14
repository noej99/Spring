package com.noej.jul031ja.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

@Service
public class WeatherDAO {
	
	public String get(String zone) {
		HttpsURLConnection huc = null;
		try {
			String s = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=" + zone;
			URL u = new URL(s);
			huc = (HttpsURLConnection) u.openConnection();
			InputStreamReader isr = new InputStreamReader(huc.getInputStream(), "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			StringBuffer sb =new StringBuffer();
			
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			huc.disconnect();
		}
	}
}
