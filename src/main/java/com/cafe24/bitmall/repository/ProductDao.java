package com.cafe24.bitmall.repository;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.bitmall.vo.ProductVo;
@Repository
public class ProductDao {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(ProductVo vo) {
		return sqlSession.insert("product.insert",vo);

	}
	public List<ProductVo> getList(){
		return sqlSession.selectList("product.getList");
	}
	public List<ProductVo> getList(Long no){
		return sqlSession.selectList("product.getListByCategoryNo",no);
	}
	public ProductVo get(Long no){
		return sqlSession.selectOne("product.getByNo",no);
	}
}
