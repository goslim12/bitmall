package com.cafe24.security;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.bitmall.vo.AdminVo;
import com.cafe24.bitmall.vo.MemberVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

//		System.out.println("============");
//		System.out.println("============");
//		System.out.println("============");
//		System.out.println("============");
//		System.out.println("============");
//		System.out.println(handler);
		// 1.핸들러 종류 확인
		if (handler instanceof HandlerMethod == false) {
			return true;
		}

		// 2. casting
		HandlerMethod handlerMethod = (HandlerMethod) handler;

		// 3. @Auth 받아오기.
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);

//		if(request.getServletPath().contains("admin")==false) {
//			AdminVo authUser = (AdminVo)session.getAttribute("authUser");
//			if (authUser == null) {
//				response.sendRedirect(request.getContextPath() + "/user/member_login");
//				return false;
//			}
//		}
		// 4. Method에 @Auth가 없는 경우
		if (auth == null) {
			return true;
		}
		System.out.println("request.getServletPath() : "+request.getServletPath());

		// 5. @Auth 가 붙어 있는 경우, 인증 여부 체크
		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/user/member_login");
			return false;
		}
		
		MemberVo authUser = (MemberVo) session.getAttribute("authUser");
		if (authUser == null && request.getServletPath().contains("admin")==false) {
			//admin페이지를 제외한 모든페이지  &&  @Auth가 달린 핸들러인경우에 로그인 안됐을때
			response.sendRedirect(request.getContextPath() + "/user/member_login");
			return false;
		}

		if(auth.role()==Auth.Role.USER){ 
			Map pathVariables = (LinkedHashMap)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
			int contextPathLength = request.getContextPath().length();
			int modifyPageLength = contextPathLength+"/user/member_modify".length();
//			System.out.println("request.getRequestURI().length()  : " + request.getRequestURI().length() );
//			System.out.println("=====================");
//			System.out.println("modifyPageLength : "+modifyPageLength);
//			System.out.println("contextPathLength : "+contextPathLength);
			if(request.getRequestURI().length() > modifyPageLength) { //인덱스 범위초과한 경우를 제외하기위해
			String modifyPage = request.getRequestURI().substring(contextPathLength,modifyPageLength);
				if(modifyPage.equals("/user/member_modify")) {
					if(!String.valueOf((authUser.getNo())).equals(pathVariables.get("no"))) { //번호가 다르면
						response.sendRedirect(request.getContextPath());
						return false;	
					}
				}
			}
			
		}
		else if(auth.role()==Auth.Role.ADMIN){
			System.out.println("!%$%$#%$%$%");
			AdminVo authAdmin = (AdminVo) session.getAttribute("authAdmin");
			if (authAdmin == null) {
				response.sendRedirect(request.getContextPath() + "/admin");
				return false;
			}
		}
		//6. 접근 허가
		return true;
	}

}
