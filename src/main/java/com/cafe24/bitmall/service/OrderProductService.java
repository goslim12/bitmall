package com.cafe24.bitmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.OrderProductDao;
import com.cafe24.bitmall.vo.OrderProductVo;

@Service
public class OrderProductService {
	@Autowired
	private OrderProductDao orderProductDao;
	
	public int add(OrderProductVo vo) {
		return orderProductDao.insert(vo);
	}
	public int delete(Long no) {
		return orderProductDao.delete(no);
	}
	public List<OrderProductVo> getList(Long no) {
		return 	orderProductDao.getList(no);
	}
//	public MemberVo getMemberByLogin(MemberVo vo) {
//		return 	recipientDao.getByIdAndPassword(vo);
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
//	}
}
