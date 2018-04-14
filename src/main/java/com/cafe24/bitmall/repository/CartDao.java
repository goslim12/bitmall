package com.cafe24.bitmall.repository;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.CartVo;
import com.cafe24.bitmall.vo.ProductVo;
@Repository
public class CartDao {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(CartVo vo) {
		return sqlSession.insert("cart.insert",vo);
	}
	public List<CartVo> getList(Long no){
		return sqlSession.selectList("cart.getListByMemberNo",no);
	}
	
	public int modifyCount(CartVo vo) {
		return sqlSession.update("cart.modifyCount",vo);
	}
	
	public int delete(CartVo vo) {
		return sqlSession.delete("cart.delete",vo);
	}
	
	public int allDeleteByMemberNo(Long no) {
		return sqlSession.delete("cart.allDeleteByMemberNo",no);
	}
	
	public CartVo getByMemberNoAndProductNo(CartVo vo) {
		return sqlSession.selectOne("cart.getByMemberNoAndProductNo",vo);
	}
}
