package com.noej.sp.wc;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noej.sp.sns.SNSMsg;

@Service
public class WeatherColorDAO {

	@Autowired
	private SqlSession ss;
	
	public void reg(SNSMsg sm) {
		HttpURLConnection huc = null;
		
		try {
			URL u = new URL("https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr");
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			JSONParser jp = new JSONParser();
			JSONObject weatherData = (JSONObject) jp.parse(isr);
			JSONArray weather = (JSONArray) weatherData.get("weather");
			JSONObject weatherO = (JSONObject) weather.get(0);
			JSONObject main = (JSONObject) weatherData.get("main");
			
			WeatherColor wc = new WeatherColor();
			wc.setSwc_temp(new BigDecimal(main.get("temp").toString()));
			wc.setSwc_humidity(new BigDecimal(main.get("humidity").toString()));
			// Object o = weatherO.get("description");
			wc.setSwc_description((String) weatherO.get("description"));
			wc.setSwc_color(sm.getSs_color());
			
			ss.getMapper(WeatherMapper.class).reg(wc);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
