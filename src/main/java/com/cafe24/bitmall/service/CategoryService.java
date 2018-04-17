package com.cafe24.bitmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.CategoryDao;
import com.cafe24.bitmall.vo.CategoryVo;

@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
//	public void add(CartVo vo) {
//		cartDao.insert(vo);
//	}
	public CategoryVo get(Long no) {
		return 	categoryDao.get(no);
	}
	public List<CategoryVo> getList() {
		return 	categoryDao.getList();
	}
}
