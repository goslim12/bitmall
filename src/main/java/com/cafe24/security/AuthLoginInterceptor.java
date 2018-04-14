package com.cafe24.security;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.vo.MemberVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

//	@Autowired
//	private UserService userService;
	
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object handler)
			throws Exception {
//		return super.preHandle(request, response, handler);

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPassword(password); //아직 암호화 안된 패스워드
		
		ApplicationContext ac = 
		WebApplicationContextUtils.
		getWebApplicationContext(
				request.getServletContext()
				);  // 웹어플리케이션컨텍스트 객체 가져오기
		MemberService memberService = ac.getBean(MemberService.class);

		
		MemberVo authUser = memberService.getMemberByLogin(vo); //
		if(authUser == null) {
			request.setAttribute("result", "fail");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/member_login.jsp");
			rd.forward(request, response);
			return false;
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		response.sendRedirect(request.getContextPath()+"/main");
		return false;
	}

}
