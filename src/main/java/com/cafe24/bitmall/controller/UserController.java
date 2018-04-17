package com.cafe24.bitmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.security.Auth;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/member_agree")
	public String index() {
		return "user/member_agree";
	}
	
	@RequestMapping(value="/member_join", method = RequestMethod.GET)
	public String join_info() {
		return "user/member_join";
	}
	
	@RequestMapping(value="/member_joinend", method = RequestMethod.POST)
	public String join(
			@RequestParam(value="id",required=false)String id,
			@RequestParam(value="password1",required=false)String password1,
			@RequestParam(value="password2",required=false)String password2,
			@RequestParam(value="name",required=false)String name,
			@RequestParam(value="birthday1",required=false)String birth1,
			@RequestParam(value="birthday2",required=false)String birth2,
			@RequestParam(value="birthday3",required=false)String birth3,
			@RequestParam(value="tel1",required=false)String tel1,
			@RequestParam(value="tel2",required=false)String tel2,
			@RequestParam(value="tel3",required=false)String tel3,
			@RequestParam(value="phone1",required=false)String phone1,
			@RequestParam(value="phone2",required=false)String phone2,
			@RequestParam(value="phone3",required=false)String phone3,
			@RequestParam(value="zip1",required=false)String zip1,
			@RequestParam(value="zip2",required=false)String zip2,
			@RequestParam(value="address",required=false)String address,
			@RequestParam(value="email",required=false)String email
			) {
		if(password1.equals(password2)) {
			MemberVo memberVo = new MemberVo();
			memberVo.setId(id);
			memberVo.setPassword(password1);
			memberVo.setName(name);
			memberVo.setBirth(birth1+"-"+birth2+"-"+birth3);
			memberVo.setTelephone(tel1+"-"+tel2+"-"+tel3);
			memberVo.setPhone(phone1+"-"+phone2+"-"+phone3);
			memberVo.setZip(zip1+"-"+zip2);
			memberVo.setAddress(address);
			memberVo.setEmail(email);
			memberService.join(memberVo);
			return "redirect:/user/member_joinend";
		}

		return "redirect:/user/member_joinend"; //실패로 수정할것
	}
	@RequestMapping(value = "/member_joinend", method = RequestMethod.GET)
	public String joinsuccess() {
		return "user/member_joinend";
	}
	
	@RequestMapping("/member_login")
	public String loginPage() {
		return "user/member_login";
	}
	
	@Auth()
	@RequestMapping("/member_modify/{no}")
	public String modify(
			Model model,
			@AuthUser MemberVo authUser,
			@PathVariable("no") String memberNo
			) {
		String[] birthday = authUser.getBirth().split("-");
		String[] telephone = authUser.getTelephone().split("-");
		String[] phone = authUser.getPhone().split("-");
		String[] zip = authUser.getZip().split("-");
		model.addAttribute("birthday1",birthday[0]);
		model.addAttribute("birthday2",birthday[1]);
		model.addAttribute("birthday3",birthday[2]);
		model.addAttribute("tel1",telephone[0]);
		model.addAttribute("tel2",telephone[1]);
		model.addAttribute("tel3",telephone[2]);
		model.addAttribute("phone1",phone[0]);
		model.addAttribute("phone2",phone[1]);
		model.addAttribute("phone3",phone[2]);
		model.addAttribute("zip1",zip[0]);
		model.addAttribute("zip2",zip[1]);
		model.addAttribute("vo",authUser);
		return "user/member_modify";
	}
	

}
