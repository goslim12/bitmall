	package com.cafe24.bitmall.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.etc.JumunList;
import com.cafe24.bitmall.service.CartService;
import com.cafe24.bitmall.service.OrderProductService;
import com.cafe24.bitmall.service.OrderService;
import com.cafe24.bitmall.service.OrdererService;
import com.cafe24.bitmall.service.PaymentService;
import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.service.RecipientService;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.bitmall.vo.OrderProductVo;
import com.cafe24.bitmall.vo.OrderVo;
import com.cafe24.bitmall.vo.PaymentVo;
import com.cafe24.bitmall.vo.ProductVo;
import com.cafe24.security.Auth;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping("/jumun")
public class JumunController {
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
	
	@Auth()
	@RequestMapping("")
	public String index(
			Model model,
			@AuthUser MemberVo authUser) {

		List<OrderVo> list = orderService.getListByMemNo(authUser.getNo());
		JumunList[] jumunList = new JumunList[list.size()];
		for(int i=0;i<jumunList.length;i++) {
			jumunList[i] = new JumunList();
			OrderVo orderVo = list.get(i);
			PaymentVo tmp = paymentService.get(orderVo.getPaymentNo());
			String orderNo = tmp.getOrderNo();
			String date = orderNo.substring(0, 8);
			String price = String.valueOf(tmp.getPrice());
			List<OrderProductVo> orderProductVoList = orderProductService.getList(orderVo.getNo());
			if(orderProductVoList.size()>0) {
				ProductVo productVo =new ProductVo();
				productVo = productService.get(orderProductVoList.get(0).getProductNo());
//				jumunList[i].setTitle();
				jumunList[i].setTitle(productVo.getTitle());
				if(orderProductVoList.size()>1) {
					jumunList[i].setTitle(productVo.getTitle()+" (외 "+(orderProductVoList.size()-1)+")");
				}	
			}
			jumunList[i].setDate(date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8));
			jumunList[i].setOrderNo(orderNo);
			jumunList[i].setPrice(price);
			jumunList[i].setState("주문신청");
			jumunList[i].setOrderKeyNo(orderVo.getNo());
		}
		Arrays.sort(jumunList);//역정렬
		model.addAttribute("list",jumunList);
//		model.addAttribute("list",list);
		
		return "jumun/jumun";
	}
	
	@Auth()
	@RequestMapping("/info")
	public String info(
			Model model,
			@AuthUser MemberVo authUser,
			@RequestParam(value="no",required=true)Long orderNo) {
		OrderVo orderVo = orderService.getByNo(orderNo);
		List<OrderProductVo> orderProductVoList = orderProductService.getList(orderVo.getNo());
		
		Map<Long, Object> map = new HashMap<Long, Object>();
		for(OrderProductVo vo : orderProductVoList) {
			map.put(vo.getProductNo(),productService.getByNo(vo.getProductNo()));
		}
		model.addAttribute("orderProductVoList",orderProductVoList);
		model.addAttribute("payment",paymentService.get(orderVo.getPaymentNo()));
		model.addAttribute("orderer",ordererService.get(orderVo.getOrdererNo()));
		model.addAttribute("recipient",recipientService.get(orderVo.getRecipientNo()));
		model.addAttribute("map",map);
		
		return "jumun/jumun_info";
	}
	
}
