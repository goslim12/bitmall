package com.cafe24.bitmall.repository;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.AdminVo;
@Repository
public class AdminDao {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;
	
	public AdminVo get(AdminVo vo){
		return sqlSession.selectOne("admin.get",vo);
	}
}
