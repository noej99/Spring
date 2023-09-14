package com.noej.jul072rac.coffee;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeDAO {
	
	@Autowired
	private SqlSession ss;
	
	public Coffees get() {
		return new Coffees(ss.getMapper(CoffeeMapper.class).get());
	}
	
	public String reg(Coffee c) {
		try {
			if(ss.getMapper(CoffeeMapper.class).reg(c) == 1) {
				return "{\"result\":\"성공\"}";
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"실패\"}";
		}
	}
}
