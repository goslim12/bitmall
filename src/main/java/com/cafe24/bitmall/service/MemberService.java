package com.cafe24.bitmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.MemberDao;
import com.cafe24.bitmall.vo.MemberVo;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public void join(MemberVo vo) {
		memberDao.insert(vo);
	}
	public MemberVo getMember(MemberVo vo) {
		return 	memberDao.get(vo);
	}
	public List<MemberVo> getList() {
		return 	memberDao.getList();
	}
	public MemberVo getMemberByLogin(MemberVo vo) {
		return 	memberDao.getByIdAndPassword(vo);
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
