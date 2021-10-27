package com.wkkmenu.test.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class ITTT000Mapper {

	
	@Autowired
	@Qualifier("sqlSession")
	private SqlSession sqlSession;	
	
	protected final String NAMESPACE = "com.wkkmenu.test.mapper.ITTT000Mapper.";
	
	
	public boolean get1() throws Exception {
		int result = sqlSession.selectOne(NAMESPACE + "get1");
		if(result == 1)
			return true;
		return false;
	}
	
}
