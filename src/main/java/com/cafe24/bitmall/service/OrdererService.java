package com.cafe24.bitmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.OrdererDao;
import com.cafe24.bitmall.vo.OrdererVo;

@Service
public class OrdererService {
	@Autowired
	private OrdererDao ordererDao;
	
	public int add(OrdererVo vo) {
		return ordererDao.insert(vo);
	}
	public int delete(Long no) {
		return ordererDao.delete(no);
	}
	public OrdererVo get(Long no) {
		return 	ordererDao.get(no);
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
