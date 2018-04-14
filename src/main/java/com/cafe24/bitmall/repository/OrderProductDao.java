package com.cafe24.bitmall.repository;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.OrderProductVo;
@Repository
public class OrderProductDao {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(OrderProductVo vo) {
		return sqlSession.insert("orderproduct.insert",vo);

	}
//	public List<MemberVo> getList(){
//		return null;
//	}
	public List<OrderProductVo> getList(Long no){
		return sqlSession.selectList("orderproduct.getListByOrderNo",no);
	}
//	public MemberVo getByIdAndPassword(MemberVo vo){
//		return sqlSession.selectOne("member.getByIdAndPassword",vo);
//	}
}
