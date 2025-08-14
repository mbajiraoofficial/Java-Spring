package com.sample.app1.config;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception
	{
		HttpSession session=request.getSession(false);
		boolean isLoggedIn=
				(session!=null && 
				session.getAttribute("LoggedInnUser")!=null);
		
		if(!isLoggedIn)
		{
			response.sendRedirect("/login");
			return false;
		}
			
		
		return true;
	}
	
}
