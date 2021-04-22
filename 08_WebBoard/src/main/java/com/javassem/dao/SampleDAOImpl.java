package com.javassem.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("sampleDAO")
public class SampleDAOImpl implements SampleDAO{

	// DB 커넥션을 담당
	@Autowired
	SqlSessionTemplate mybatis;
	
	@Override
	public String sample() {
		// TODO Auto-generated method stub
		return mybatis.selectOne("ss", "getDate");
	}

}
