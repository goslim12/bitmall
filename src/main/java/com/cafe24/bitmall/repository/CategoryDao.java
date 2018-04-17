package com.cafe24.bitmall.repository;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.CartVo;
import com.cafe24.bitmall.vo.CategoryVo;
@Repository
public class CategoryDao {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(CartVo vo) {
		return sqlSession.insert("category.insert",vo);
	}
//	public List<CartVo> getList(Long no){
//		return sqlSession.selectList("cart.getListByMemberNo",no);
//	}
	public CategoryVo get(Long no){
		return sqlSession.selectOne("category.getByNo",no);
	}
	public List<CategoryVo> getList(){
		return sqlSession.selectList("category.getList");
	}
}
