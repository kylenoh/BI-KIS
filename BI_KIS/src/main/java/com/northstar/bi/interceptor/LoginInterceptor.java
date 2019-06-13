package com.northstar.bi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("LOGIN_EMP");
		
		if (obj == null) {
			response.sendRedirect("/bi/login?login=fail");
			return false;
		}
		
		return true;
	}
}
