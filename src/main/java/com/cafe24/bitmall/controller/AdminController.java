package com.cafe24.bitmall.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.bitmall.etc.AdminJumunList;
import com.cafe24.bitmall.service.AdminService;
import com.cafe24.bitmall.service.CartService;
import com.cafe24.bitmall.service.CategoryService;
import com.cafe24.bitmall.service.FileUploadService;
import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.service.OrderProductService;
import com.cafe24.bitmall.service.OrderService;
import com.cafe24.bitmall.service.OrdererService;
import com.cafe24.bitmall.service.PaymentService;
import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.service.RecipientService;
import com.cafe24.bitmall.vo.AdminVo;
import com.cafe24.bitmall.vo.CategoryVo;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.bitmall.vo.OrderProductVo;
import com.cafe24.bitmall.vo.OrderVo;
import com.cafe24.bitmall.vo.PaymentVo;
import com.cafe24.bitmall.vo.ProductVo;
import com.cafe24.security.Auth;

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
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("")
	public String loginPage(
			) {
		return "admin/login";
	}
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/ad/member", method=RequestMethod.GET)
	public String member(Model model) {
		List<MemberVo> list = memberService.getList();
		model.addAttribute("list",list);
		model.addAttribute("count",list.size());
		return "admin/member";
	}
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/ad/member_modify", method=RequestMethod.GET)
	public String memberModify(
			Model model,
			@RequestParam(value="no",required=true)Long no
			) {
		MemberVo vo = memberService.getByNo(no);
		String[] birthday = vo.getBirth().split("-");
		String[] telephone = vo.getTelephone().split("-");
		String[] phone = vo.getPhone().split("-");
		String[] zip = vo.getZip().split("-");
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
		model.addAttribute("vo",vo);
		return "admin/member_modify";
	}
	
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/ad/member_modifying/{no}", method = RequestMethod.POST)
	public String memberModifying(
			@PathVariable("no") Long memberNo,
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
			memberVo.setNo(memberNo);
			memberVo.setId(id);
			memberVo.setPassword(password1);
			memberVo.setName(name);
			memberVo.setBirth(birth1+"-"+birth2+"-"+birth3);
			memberVo.setTelephone(tel1+"-"+tel2+"-"+tel3);
			memberVo.setPhone(phone1+"-"+phone2+"-"+phone3);
			memberVo.setZip(zip1+"-"+zip2);
			memberVo.setAddress(address);
			memberVo.setEmail(email);
			memberService.modify(memberVo);
			return "redirect:/admin/ad/member";
		}

		return "redirect:/admin/ad/member"; //실패로 수정할것
	}
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/ad/product", method=RequestMethod.GET)
	public String product1(Model model) {
		Map<Long, Object> map = new HashMap<Long, Object>();
		
		List<ProductVo> list = productService.getList();
		for(ProductVo vo : list) {
			map.put(vo.getNo(),categoryService.get(vo.getCategoryNo()));
		}
		
		model.addAttribute("list",list);
		model.addAttribute("map",map);
		return "admin/product";
	}
//	@RequestMapping(value="/ad/product", method=RequestMethod.POST)
//	public String product(Model model) {
//		Map<Long, Object> map = new HashMap<Long, Object>();
//		
//		List<ProductVo> list = productService.getListByDelete();
//		for(ProductVo vo : list) {
//			map.put(vo.getNo(),categoryService.get(vo.getCategoryNo()));
//		}
//		
//		model.addAttribute("list",list);
//		model.addAttribute("map",map);
//		return "admin/product";
//	}
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/ad/jumun", method=RequestMethod.GET)
	public String jumun(
			Model model) {
//			@AuthUser MemberVo authUser) {

		List<OrderVo> list = orderService.getList();
//		for(OrderVo vo : list) {
//			System.out.println(vo);
//		}
		AdminJumunList[] adminJumunList = new AdminJumunList[list.size()];
		for(int i=0;i<adminJumunList.length;i++) {
			adminJumunList[i] = new AdminJumunList();
			OrderVo orderVo = list.get(i);
			PaymentVo tmp = paymentService.get(orderVo.getPaymentNo());
			String orderNo = tmp.getOrderNo();
			String orderName = (ordererService.get(Long.valueOf(orderVo.getOrdererNo()))).getName();
			String date = orderNo.substring(0, 8);
			String price = String.valueOf(tmp.getPrice());
			List<OrderProductVo> orderProductVoList = orderProductService.getList(orderVo.getNo());
			if(orderProductVoList.size()>0) {
				ProductVo productVo =new ProductVo();
				productVo = productService.get(orderProductVoList.get(0).getProductNo());
//				jumunList[i].setTitle();
				adminJumunList[i].setTitle(productVo.getTitle());
				if(orderProductVoList.size()>=1) {
					int tmpNum = orderProductVoList.size();
					adminJumunList[i].setCount((long) tmpNum);	
					if(tmpNum>1)
						adminJumunList[i].setTitle(productVo.getTitle()+" (외 "+(tmpNum-1)+")");
				}	
			}
			adminJumunList[i].setDate(date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8));
			adminJumunList[i].setOrderNo(orderNo);
			adminJumunList[i].setPrice(price);
			adminJumunList[i].setState(tmp.getState());
			adminJumunList[i].setOrderKeyNo(orderVo.getNo());
			adminJumunList[i].setOrderName(orderName);
			adminJumunList[i].setWay(tmp.getWay());
				
		}
		Arrays.sort(adminJumunList);//역정렬
		model.addAttribute("list",adminJumunList);
		model.addAttribute("count",adminJumunList.length);
		return "admin/jumun";
	}
	
	
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/ad/jumunmodify", method=RequestMethod.POST)
	public String modifyJumun(
			@RequestParam(value="state") String state,
			@RequestParam(value="orderKeyNo") Long orderKeyNo
			) {
		OrderVo tmp = orderService.getByNo(orderKeyNo);
		PaymentVo vo = paymentService.get(tmp.getPaymentNo());
		vo.setState(state);
		paymentService.updateState(vo);
		return "redirect:/admin/ad/jumun";
	}
	
	@RequestMapping(value="/ad/faq", method=RequestMethod.GET)
	public String faq1() {
		return "admin/faq";
	}
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/ad/product_new", method=RequestMethod.GET)
	public String product_new(Model model) {
		List<CategoryVo> list = categoryService.getList();
		model.addAttribute("list",list);
		return "admin/product_new";
	}
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/ad/product_new", method=RequestMethod.POST
			)
	public String productNewPost(
			Model model,
			@RequestParam(value="menu",required=true) Long menu,
			@RequestParam(value="name",required=true) String name,
			@RequestParam(value="price",required=true) Long price,
			@RequestParam(value="file",required=true)MultipartFile multipartFile
			){
		String path = fileUploadService.restore(multipartFile);
		ProductVo vo = new ProductVo();
		vo.setCategoryNo(menu);
		vo.setTitle(name);
		vo.setPrice(price);;
		vo.setPath(path);
//		model.addAttribute("list",list);
		if(path == null)
			return "redirect:/admin/ad/product_new";
		
		productService.add(vo);
		return "redirect:/admin/ad/product";
	}
	
	
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/ad/product_edit", method=RequestMethod.GET)
	public String product_edit(Model model,
			@RequestParam(value="no") Long no) {
		ProductVo vo = productService.get(no);
		List<CategoryVo> list = categoryService.getList();
		
		
		model.addAttribute("vo",vo);
		model.addAttribute("list",list);
		return "admin/product_edit";
	}
	
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/ad/product_edit", method=RequestMethod.POST)
	public String product_edit(
			@RequestParam(value="no",required=true) String no,
			@RequestParam(value="menu",required=true) Long menu,
			@RequestParam(value="name",required=true) String name,
			@RequestParam(value="price",required=true) Long price,
			@RequestParam(value="image1",required=true)MultipartFile multipartFile
			) {
		System.out.println("!!!!!!!!!!!!");
		ProductVo vo = productService.getByNo(Long.valueOf(no));
		String path = fileUploadService.restore(multipartFile);
		if(path == null)
			vo.setPath(vo.getPath());
		vo.setTitle(name);
		vo.setCategoryNo(Long.valueOf(menu));
		vo.setPrice(price);
//		System.out.println(menu);
//		System.out.println(vo);`
		productService.update(vo);
		return "redirect:/admin/ad/product";
	}
	
}
