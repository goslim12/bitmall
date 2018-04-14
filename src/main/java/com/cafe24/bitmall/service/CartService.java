package com.cafe24.bitmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.CartDao;
import com.cafe24.bitmall.vo.CartVo;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	
	public void add(CartVo vo) {
		cartDao.insert(vo);
	}
	public List<CartVo> getListByMemberNo(Long no) {
		return 	cartDao.getList(no);
	}
	public CartVo getByMemberNoAndProductNo(CartVo vo) {
		return 	cartDao.getByMemberNoAndProductNo(vo);
	}
	public int modifyCount(CartVo vo) {
		return cartDao.modifyCount(vo);
	}
	
	public int delete(CartVo vo) {
		return cartDao.delete(vo);
	}
	public int allDeleteByMemberNo(Long no) {
		return cartDao.allDeleteByMemberNo(no);
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
