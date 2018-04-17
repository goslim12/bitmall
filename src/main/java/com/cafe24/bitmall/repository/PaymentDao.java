package com.cafe24.bitmall.repository;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.PaymentVo;
@Repository
public class PaymentDao {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(PaymentVo vo) {
		return sqlSession.insert("payment.insert",vo);
	}
	public int delete(Long no) {
		return sqlSession.delete("payment.delete",no);
	}
//	public List<MemberVo> getList(){
//		return null;
//	}
	public int updateState(PaymentVo vo) {
		return sqlSession.update("payment.updateSate",vo);
	}
	public PaymentVo get(Long no){
		return sqlSession.selectOne("payment.getByNo",no);
	}
//	public MemberVo getByIdAndPassword(MemberVo vo){
//		return sqlSession.selectOne("member.getByIdAndPassword",vo);
//	}
}
