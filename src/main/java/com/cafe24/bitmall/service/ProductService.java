package com.cafe24.bitmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.ProductDao;
import com.cafe24.bitmall.vo.ProductVo;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	public void add(ProductVo vo) {
		productDao.insert(vo);
	}
	public ProductVo get(ProductVo vo) {
		return 	productDao.get(vo.getNo());
	}
	public ProductVo get(Long no) {
		return 	productDao.get(no);
	}
	public List<ProductVo> getList() {
		return 	productDao.getList();
	}
	public List<ProductVo> getListByCategoryNo(Long no) {
		return 	productDao.getList(no);
	}
	public ProductVo getByNo(Long no) {
		return 	productDao.get(no);
	}
//	@Transactional
//	public boolean modify(UserVo vo,UserVo authUser,String newPassword) {
//		UserVo tempAuthUser = memberDao.get(vo); //이메일과 비밀번호일치하는 유저가 있는지 확인
//		if(tempAuthUser!=null) {
//			vo.setPassword(newPassword);
//			memberDao.update(vo);
//			authUser.setName(tempAuthUser.getName());
//			authUser.setPassword(getUser(tempAuthUser.getNo()).getPassword());
//			authUser.setName(tempAuthUser.getName());
//			return true;
//		}
//		return 	false;
//	}
}
