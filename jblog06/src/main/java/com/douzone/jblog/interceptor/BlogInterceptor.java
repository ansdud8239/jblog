package com.douzone.jblog.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.vo.BlogVo;


public class BlogInterceptor implements HandlerInterceptor{

	@Autowired
	private BlogService blogService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1. handler 종류 확인
		if (!(handler instanceof HandlerMethod)) {
			// DefaultServletHandler가 처리하는 경우(정적 자원, /assets/**)
			return true;
		}
		Map pathVariable = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		String id = pathVariable.get("id").toString();

		BlogVo blogVo= blogService.getBlog(id);
		request.setAttribute("blogVo", blogVo);
		
		return true;
	}
	
	
	
}
