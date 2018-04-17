	package com.cafe24.bitmall.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.vo.ProductVo;

@Controller
@RequestMapping("/product")
public class ProductController {
	//anchovy's category no is 1
	@Autowired
	private ProductService productService;
	@RequestMapping("/{path1}")
	public String anchovy(	
			Model model,
			@PathVariable("path1") Long path1) {
		List<ProductVo> list = productService.getListByCategoryNoAndDelete(path1);
		model.addAttribute("list",list);
		return "product/index";
	}	

	//////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/product_detail", method = RequestMethod.GET)
	
	public String detail(
			Model model,
			@RequestParam(value="no",required=false)Long no) {

		ProductVo vo = productService.getByNo(no);
		model.addAttribute("vo",vo);
		model.addAttribute("no",no);
		model.addAttribute("categoryNo",vo.getCategoryNo());
		return "product/product_detail";
	}
	//위에까지는 상품 카테고리 별 매핑
	
}
