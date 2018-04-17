package com.cafe24.security;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.bitmall.service.AdminService;
import com.cafe24.bitmall.vo.AdminVo;
import com.cafe24.bitmall.vo.MemberVo;

public class AdminLoginInterceptor extends HandlerInterceptorAdapter {

//	@Autowired
//	private UserService userService;
	
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object handler)
			throws Exception {
//		return super.preHandle(request, response, handler);

		String id = request.getParameter("adminid");
		String password = request.getParameter("adminpw");
		
		AdminVo vo = new AdminVo();
		vo.setId(id);
		vo.setPassword(password); //아직 암호화 안된 패스워드
		
		ApplicationContext ac = 
		WebApplicationContextUtils.
		getWebApplicationContext(
				request.getServletContext()
				);  // 웹어플리케이션컨텍스트 객체 가져오기
		AdminService adminService = ac.getBean(AdminService.class);

		
		AdminVo authAdmin = adminService.get(vo); //
		System.out.println("!!!!!!!");
		System.out.println("!!!!!!!");
		System.out.println("!!!!!!!");
		System.out.println(authAdmin);
		if(authAdmin == null) {
			request.setAttribute("result", "fail");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/admin/login.jsp");
			rd.forward(request, response);
			return false;
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("authAdmin", authAdmin);
		response.sendRedirect(request.getContextPath()+"/admin/ad/product");
		return false;
	}

}
