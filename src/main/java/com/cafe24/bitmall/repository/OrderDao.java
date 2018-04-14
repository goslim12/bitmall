package com.cafe24.bitmall.repository;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.OrderVo;
@Repository
public class OrderDao {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(OrderVo vo) {
		return sqlSession.insert("order.insert",vo);

	}
	public List<OrderVo> getListByMemNo(Long no){
		return sqlSession.selectList("order.getListByMemNo",no);
	}
	public OrderVo getByNo(Long no){
		return sqlSession.selectOne("order.getByNo",no);
	}
//	public MemberVo getByIdAndPassword(MemberVo vo){
//		return sqlSession.selectOne("member.getByIdAndPassword",vo);
//	}
}
