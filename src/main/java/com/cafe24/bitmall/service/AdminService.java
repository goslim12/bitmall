package com.cafe24.bitmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.AdminDao;
import com.cafe24.bitmall.vo.AdminVo;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	public AdminVo get(AdminVo vo) {
		return adminDao.get(vo);
	}
}
