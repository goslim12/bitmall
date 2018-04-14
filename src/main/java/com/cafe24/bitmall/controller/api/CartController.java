	package com.cafe24.bitmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.bitmall.dto.JSONResult;
import com.cafe24.bitmall.service.CartService;
import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.vo.CartVo;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.bitmall.vo.ProductVo;
import com.cafe24.security.AuthUser;

@Controller("cartAPIController")
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	
	@ResponseBody()
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public JSONResult modify(
			@ModelAttribute CartVo vo,
			@AuthUser MemberVo authUser
			) {
		ProductVo productVo = productService.getByNo(vo.getProductNo());
		vo.setMemberNo(authUser.getNo());
		return JSONResult.success(cartService.modifyCount(vo)==1? productVo : null);
	}
	
	@ResponseBody()
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public JSONResult delete(
			@ModelAttribute CartVo vo,
			@AuthUser MemberVo authUser
			) {
		vo.setMemberNo(authUser.getNo());
		
		ProductVo productVo = productService.getByNo(vo.getProductNo());
		int result = cartService.delete(vo);
		return JSONResult.success(result==1? productVo : null);
//		return JSONResult.success(productVo);
	}
	
	@ResponseBody()
	@RequestMapping(value="/alldelete", method=RequestMethod.POST)
	public JSONResult allDelete(
			@AuthUser MemberVo authUser
			) {
		int result = cartService.allDeleteByMemberNo(authUser.getNo());
		return JSONResult.success(result>=1? "all delete" : "delete fail",null);
	}

}
