	package com.cafe24.bitmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.bitmall.dto.JSONResult;
import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.service.OrderProductService;
import com.cafe24.bitmall.service.OrderService;
import com.cafe24.bitmall.service.OrdererService;
import com.cafe24.bitmall.service.PaymentService;
import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.service.RecipientService;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.bitmall.vo.OrderVo;
import com.cafe24.bitmall.vo.ProductVo;

@Controller("adminAPIController")
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderProductService orderProductService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private RecipientService recipientService;
	@Autowired
	private OrdererService ordererService;
	@Autowired
	private ProductService productService;
	
	@ResponseBody()
	@RequestMapping(value="/member/delete", method=RequestMethod.POST)
	public JSONResult memberDelete(@ModelAttribute MemberVo vo) {
		return JSONResult.success(memberService.delete(vo.getNo())==1? "delete" : "can't delete");
	}
	@ResponseBody()
	@RequestMapping(value="/product/delete", method=RequestMethod.POST)
	public JSONResult productDelete(@RequestParam(value="no",required=true) Long no) {
		ProductVo vo = productService.getByNo(no);
		vo.setDelete(true);
		return JSONResult.success(productService.update(vo)==1? "delete" : "can't delete");
	}
	@ResponseBody	()
	@RequestMapping(value="/jumun/delete", method=RequestMethod.POST)
	public JSONResult jumunDelete(
			@RequestParam(value="no",required=true) Long orderNo) {
		
		OrderVo vo  = orderService.getByNo(orderNo);
		boolean result = false;
		result = orderProductService.delete(orderNo)>=1;
		if(result==false) {
			System.out.println("orderProductService delete fail");
			return JSONResult.success("fail");
		}
		result = orderService.delete(orderNo) >= 1;
		if(result==false) {
			System.out.println("orderService delete fail");
 			return JSONResult.success("fail");
		}
		result = paymentService.delete(vo.getPaymentNo()) >= 1;
		if(result==false) {
			System.out.println("paymentService delete fail");
			return JSONResult.success("fail");
		}
		result = recipientService.delete(vo.getRecipientNo()) >= 1;
		if(result==false) {
			System.out.println("recipientService delete fail");
			return JSONResult.success("fail");
		}
		result = ordererService.delete(vo.getOrdererNo()) >= 1;
		if(result==false) {
			System.out.println("ordererService delete fail");
			return JSONResult.success("fail");
		}

			
		return JSONResult.success("delete");
	}
	
}
