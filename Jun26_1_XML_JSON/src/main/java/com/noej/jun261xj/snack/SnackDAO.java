package com.noej.jun261xj.snack;

import java.math.BigDecimal;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnackDAO {

	@Autowired
	private SqlSession ss;
	
	public Snacks get2(int page) {
		int snackCount = ss.getMapper(SnackMapper.class).count();
		int	perPage = 5;
		
		int pageCount = (int) Math.ceil(snackCount / (double)perPage);
		if (page > pageCount) {
			return null;
		}
		int start = (page - 1) * perPage;
		int end = page * perPage;
		SnackSelector sss = new SnackSelector(new BigDecimal(start), new BigDecimal(end));
		return new Snacks(ss.getMapper(SnackMapper.class).get(sss));
	}
}
