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
	
	public int add(ProductVo vo) {
		return productDao.insert(vo);
	}
	public int delete(Long no) {
		return productDao.delete(no);
	}
	public int update(ProductVo vo) {
		return productDao.update(vo);
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
	public List<ProductVo> getListByDelete() {
		return 	productDao.getListByDelete();
	}
	public List<ProductVo> getListByCategoryNoAndDelete(Long no) {
		return 	productDao.getListByDelete(no);
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
