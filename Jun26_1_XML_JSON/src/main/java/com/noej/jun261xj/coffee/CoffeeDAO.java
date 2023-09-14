package com.noej.jun261xj.coffee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeDAO {

	@Autowired
	private SqlSession ss;
	
	// 테이블을 표현하는 객체로 만들어서 리턴
	public Coffees get2() {
		List<Coffee> coffee = ss.getMapper(CoffeeMapper.class).get();
		Coffees coffees = new Coffees(coffee);
		return coffees;
	}
	
	public void get(HttpServletRequest req) {
		req.setAttribute("coffees", ss.getMapper(CoffeeMapper.class).get());
	}
}
