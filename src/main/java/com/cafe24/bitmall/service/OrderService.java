package com.cafe24.bitmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.OrderDao;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.bitmall.vo.OrderVo;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	
	public int add(OrderVo vo) {
		return orderDao.insert(vo);
	}
	public List<OrderVo> getListByMemNo(Long no){
		return orderDao.getListByMemNo(no);
	}
	public OrderVo getByNo(Long no){
		return orderDao.getByNo(no);
	}
//	public MemberVo getMember(MemberVo vo) {
//		return 	recipientDao.get(vo);
//	}
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
