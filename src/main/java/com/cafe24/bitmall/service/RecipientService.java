package com.cafe24.bitmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.RecipientDao;
import com.cafe24.bitmall.vo.RecipientVo;

@Service
public class RecipientService {
	@Autowired
	private RecipientDao recipientDao;
	
	public int add(RecipientVo vo) {
		return recipientDao.insert(vo);
	}
	public RecipientVo get(Long no) {
		return 	recipientDao.get(no);
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
