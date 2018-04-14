package com.cafe24.bitmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.CartService;
import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.service.OrderProductService;
import com.cafe24.bitmall.service.OrderService;
import com.cafe24.bitmall.service.OrdererService;
import com.cafe24.bitmall.service.PaymentService;
import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.service.RecipientService;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.security.Auth;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private OrderProductService orderProductService;
	@Autowired
	private OrdererService ordererService;
	@Autowired
	private RecipientService recipientService;
	@Autowired
	private CartService cartService;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping({"/login",""})
	public String loginPage() {
		return "admin/login";
	}
	
	@RequestMapping(value="/ad/product", method=RequestMethod.POST)
	public String login() {
		return "redirect:/admin/ad/product";
	}
	@RequestMapping(value="/ad/member", method=RequestMethod.GET)
	public String member() {
//		memberService.get
		return "admin/member";
	}

	@RequestMapping(value="/ad/product", method=RequestMethod.GET)
	public String product() {
		return "admin/product";
	}
	
	@RequestMapping(value="/ad/jumun", method=RequestMethod.GET)
	public String jumun() {
		return "admin/jumun";
	}
	
	@RequestMapping(value="/ad/faq", method=RequestMethod.GET)
	public String faq1() {
		return "admin/faq";
	}
	
}
