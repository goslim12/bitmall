package com.cafe24.bitmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.PaymentDao;
import com.cafe24.bitmall.vo.PaymentVo;

@Service
public class PaymentService {
	@Autowired
	private PaymentDao paymentDao;
	
	public void add(PaymentVo vo) {
		paymentDao.insert(vo);
	}
	public PaymentVo get(Long no) {
		return 	paymentDao.get(no);
	}
//	public List<ProductVo> getList() {
//		return 	paymentDao.getList();
//	}
//	public List<ProductVo> getListByCategoryNo(Long no) {
//		return 	paymentDao.getList(no);
//	}
//	public ProductVo getByNo(Long no) {
//		return 	paymentDao.get(no);
//	}
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
	
}
