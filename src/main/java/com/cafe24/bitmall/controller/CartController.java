	package com.cafe24.bitmall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.CartService;
import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.vo.CartVo;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.security.Auth;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	
	@Auth()
	@RequestMapping("")
	public String index(Model model,
			@AuthUser MemberVo authUser) {
		List<CartVo> list = cartService.getListByMemberNo(authUser.getNo());
		Map<Long, Object> map = new HashMap<Long, Object>();
		for(CartVo vo : list) {
			map.put(vo.getProductNo(),productService.getByNo(vo.getProductNo()));
		}
		model.addAttribute("list",list);
		model.addAttribute("map",map);
		return "cart/cart";
	}
	@Auth()
	@RequestMapping(value="/cartadd",method=RequestMethod.GET)
	public String insert(
			Model model,
			@RequestParam(value="num",required=false)Long num,
			@RequestParam(value="no",required=false)Long no,
			@AuthUser MemberVo authUser
			) {
		CartVo vo = new CartVo();
		vo.setMemberNo(authUser.getNo());
		vo.setProductNo(no);
		CartVo existVo = cartService.getByMemberNoAndProductNo(vo);
		if(existVo==null) {
			vo.setCount(num);
			cartService.add(vo);
		}else {
			vo.setCount(num+existVo.getCount());
			cartService.modifyCount(vo);
		}
		return "redirect:/cart";
	}
}
