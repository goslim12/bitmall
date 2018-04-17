package com.cafe24.bitmall.repository;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.OrdererVo;
@Repository
public class OrdererDao {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(OrdererVo vo) {
		return sqlSession.insert("orderer.insert",vo);

	}
	public int delete(Long no) {
		return sqlSession.delete("orderer.delete",no);
		
	}
//	public List<MemberVo> getList(){
//		return null;
//	}
	public OrdererVo get(Long no){
		return sqlSession.selectOne("orderer.getByNo",no);
	}
//	public MemberVo getByIdAndPassword(MemberVo vo){
//		return sqlSession.selectOne("member.getByIdAndPassword",vo);
//	}
}
