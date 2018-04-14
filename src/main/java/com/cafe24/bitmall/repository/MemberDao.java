package com.cafe24.bitmall.repository;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.MemberVo;
@Repository
public class MemberDao {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(MemberVo vo) {
		return sqlSession.insert("member.insert",vo);
	}
	public List<MemberVo> getList(){
		return sqlSession.selectList("member.getList");
	}
	public MemberVo get(MemberVo vo){
		return sqlSession.selectOne("member.getById",vo);
	}
	public MemberVo getByIdAndPassword(MemberVo vo){
		return sqlSession.selectOne("member.getByIdAndPassword",vo);
	}
}
