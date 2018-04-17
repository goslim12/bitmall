package com.cafe24.bitmall.repository;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.RecipientVo;
@Repository
public class RecipientDao {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(RecipientVo vo) {
		return sqlSession.insert("recipient.insert",vo);
	}
	public int delete(Long no) {
		return sqlSession.delete("recipient.delete",no);
	}
//	public List<MemberVo> getList(){
//		return null;
//	}
	public RecipientVo get(Long no){
		return sqlSession.selectOne("recipient.getByNo",no);
	}
//	public MemberVo getByIdAndPassword(MemberVo vo){
//		return sqlSession.selectOne("member.getByIdAndPassword",vo);
//	}
}
