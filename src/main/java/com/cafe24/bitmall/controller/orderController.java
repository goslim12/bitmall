	package com.cafe24.bitmall.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.CartService;
import com.cafe24.bitmall.service.OrderProductService;
import com.cafe24.bitmall.service.OrderService;
import com.cafe24.bitmall.service.OrdererService;
import com.cafe24.bitmall.service.PaymentService;
import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.service.RecipientService;
import com.cafe24.bitmall.vo.CartVo;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.bitmall.vo.OrderProductVo;
import com.cafe24.bitmall.vo.OrderVo;
import com.cafe24.bitmall.vo.OrdererVo;
import com.cafe24.bitmall.vo.PaymentVo;
import com.cafe24.bitmall.vo.RecipientVo;
import com.cafe24.security.Auth;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping("/order")
public class orderController {
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private RecipientService recipientService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrdererService ordererService;
	@Autowired
	private PaymentService PaymentService;
	@Autowired
	private OrderProductService orderProductService;
	
	@Auth()
	@RequestMapping("")
	public String index(Model model,
			@AuthUser MemberVo authUser) {
		List<CartVo> list = cartService.getListByMemberNo(authUser.getNo());
		Map<Long, Object> map = new HashMap<Long, Object>();
		for(CartVo vo : list) {
			map.put(vo.getProductNo(),productService.getByNo(vo.getProductNo()));
		}
		String name = authUser.getName();
		String[] o_tel = authUser.getTelephone().split("-");
		String[] o_phone = authUser.getPhone().split("-");
		String o_email = authUser.getEmail();
		String[] o_zip = authUser.getZip().split("-");
		String o_juso = authUser.getAddress();
		model.addAttribute("list",list);
		model.addAttribute("map",map);
		model.addAttribute("name",name);
		model.addAttribute("o_tel",o_tel);
		model.addAttribute("o_phone",o_phone);
		model.addAttribute("o_email",o_email);
		model.addAttribute("o_zip",o_zip);
		model.addAttribute("o_juso",o_juso);
		return "order/order";
	}

	@Auth()
	@RequestMapping("/order_pay")
	public String pay(
			Model model,
			@AuthUser MemberVo authUser,
			@RequestParam(value="r_name",required=false)String r_name,
			@RequestParam(value="r_tel1",required=false)String r_tel1,
			@RequestParam(value="r_tel2",required=false)String r_tel2,
			@RequestParam(value="r_tel3",required=false)String r_tel3,
			@RequestParam(value="r_phone1",required=false)String r_phone1,
			@RequestParam(value="r_phone2",required=false)String r_phone2,
			@RequestParam(value="r_phone3",required=false)String r_phone3,
			@RequestParam(value="r_email",required=false)String r_email,
			@RequestParam(value="r_zip1",required=false)String r_zip1,
			@RequestParam(value="r_zip2",required=false)String r_zip2,
			@RequestParam(value="r_juso",required=false)String r_juso,
			@RequestParam(value="o_desc",required=false)String o_desc
			)	 {
			List<CartVo> list = cartService.getListByMemberNo(authUser.getNo());
			Map<Long, Object> map = new HashMap<Long, Object>();
			for(CartVo vo : list) {
				map.put(vo.getProductNo(),productService.getByNo(vo.getProductNo()));
			}
//			System.out.println(r_name);
			String r_tel  = r_tel1+"-"+r_tel2+"-"+r_tel3;
			String r_phone = r_phone1+"-"+r_phone2+"-"+r_phone3;
			String r_zip  = r_zip1+"-"+r_zip2;
			String r_addr = r_juso;
			String o_etc  = o_desc;
			model.addAttribute("r_name",r_name);
			model.addAttribute("r_tel",r_tel);
			model.addAttribute("r_phone",r_phone);
			model.addAttribute("r_email",r_email);
			model.addAttribute("r_zip",r_zip);
			model.addAttribute("r_addr",r_addr);
			model.addAttribute("o_etc",o_etc);
			model.addAttribute("list",list);
			model.addAttribute("map",map);
			return "order/order_pay";   
	}
	@Auth()
	@RequestMapping("/order_ok")
	public String ok(		
			Model model,
			@AuthUser MemberVo authUser,
			@RequestParam(value="sum",required=false)String sum,
			@RequestParam(value="o_name",required=false)String o_name,
			@RequestParam(value="o_tel",required=false)String o_tel,
			@RequestParam(value="o_phone",required=false)String o_phone,
			@RequestParam(value="o_email",required=false)String o_email,
			@RequestParam(value="o_zip",required=false)String o_zip,
			@RequestParam(value="o_addr",required=false)String o_addr,
			@RequestParam(value="r_name",required=false)String r_name,
			@RequestParam(value="r_tel",required=false)String r_tel,
			@RequestParam(value="r_phone",required=false)String r_phone,
			@RequestParam(value="r_email",required=false)String r_email,
			@RequestParam(value="r_zip",required=false)String r_zip,
			@RequestParam(value="r_addr",required=false)String r_addr,
			@RequestParam(value="o_etc",required=false)String o_etc,
			@RequestParam(value="pay_method",required=false)String pay_method,
			@RequestParam(value="card_no1",required=false)String card_no1,
			@RequestParam(value="card_no2",required=false)String card_no2,
			@RequestParam(value="card_no3",required=false)String card_no3,
			@RequestParam(value="card_no4",required=false)String card_no4,
			@RequestParam(value="card_month",required=false)String card_month,
			@RequestParam(value="card_year",required=false)String card_year,
			@RequestParam(value="card_pw",required=false)String card_pw,
			@RequestParam(value="card_halbu",required=false)String card_halbu,
			@RequestParam(value="bank_kind",required=false)String bank_kind,
			@RequestParam(value="bank_sender",required=false)String bank_sender,
			@RequestParam(value="card_kind",required=false)String card_kind
			) {
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddhhmmss");
		String date = dayTime.format(new Date(time));
//		System.out.println(pay_method);
//		System.out.println(card_no1+"-"+card_no2+"-"+card_no3);
//		System.out.println(card_month);
//		System.out.println(card_year);
//		System.out.println(card_pw);
//		System.out.println(card_halbu);
//		System.out.println(bank_kind);
//		System.out.println(bank_sender);
//		System.out.println(card_kind);
		OrdererVo ordererVo = new OrdererVo();
		ordererVo.setName(o_name);
		ordererVo.setTelephone(o_tel);
		ordererVo.setPhone(o_phone);
		ordererVo.setEmail(o_email);
		ordererVo.setZip(o_zip);
		ordererVo.setAddress(o_addr);
	
		
		
		RecipientVo recipientvo = new RecipientVo();
		recipientvo.setName(r_name);
		recipientvo.setTelephone(r_tel);
		recipientvo.setPhone(r_phone);
		recipientvo.setEmail(r_email);
		recipientvo.setZip(r_zip);
		recipientvo.setAddress(r_addr);
		recipientvo.setRequirement(o_etc);
		
		
		PaymentVo paymentVo = new PaymentVo();
		paymentVo.setPrice(Long.parseLong(sum)+2500);
		paymentVo.setWay(pay_method);
		paymentVo.setOrderNo(date);
		paymentVo.setApproval(date);
		paymentVo.setCardKind(card_kind);
		paymentVo.setInstalment(card_halbu);
		paymentVo.setOrderer(o_name);
		paymentVo.setBankKind(bank_kind);


		
		PaymentService.add(paymentVo);
		recipientService.add(recipientvo);
		ordererService.add(ordererVo);

		OrderVo orderVo = new OrderVo();
		orderVo.setMemberNo(authUser.getNo());
		orderVo.setRecipientNo(recipientvo.getNo());
		orderVo.setPaymentNo(paymentVo.getNo());
		orderVo.setOrdererNo(ordererVo.getNo());
		orderService.add(orderVo);
//		System.out.println(paymentVo);
//		System.out.println(recipientvo);
//		System.out.println(ordererVo);
//		System.out.println(orderVo);
		OrderProductVo orderproductVo = new OrderProductVo();
		List<CartVo> list = cartService.getListByMemberNo(authUser.getNo());
		for(CartVo vo : list) {
			orderproductVo.setProductNo(vo.getProductNo()); //상품번호
			orderproductVo.setOrderNo(orderVo.getNo()); //주문번호
			orderproductVo.setCount(vo.getCount());//수량
			orderproductVo.setPrice(productService.getByNo(vo.getProductNo()).getPrice());//해당 주문상품의 개당 가격
			orderProductService.add(orderproductVo);
		}

		//잠시 주석
		cartService.allDeleteByMemberNo(authUser.getNo());
		return "redirect:/order/order_success";	
	}
	@Auth()
	@RequestMapping("/order_success")
	public String ok(		
			) {
//		cartService.allDeleteByMemberNo(authUser.getNo());
		return "order/order_success";	
	}
	
}
