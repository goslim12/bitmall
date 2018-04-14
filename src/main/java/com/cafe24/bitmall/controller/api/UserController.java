	package com.cafe24.bitmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.bitmall.dto.JSONResult;
import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.vo.MemberVo;

@Controller("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private MemberService memberService;
	
	@ResponseBody()
	@RequestMapping(value="/checkid", method=RequestMethod.GET)
	public JSONResult checkId(@ModelAttribute MemberVo vo) {
		return JSONResult.success(memberService.getMember(vo)==null? "not exist" : "exist");
	}
}
