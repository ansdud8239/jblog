package com.douzone.jblog.config;

import java.util.List;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.douzone.jblog.interceptor.BlogInterceptor;
import com.douzone.jblog.security.AuthInterceptor;
import com.douzone.jblog.security.AuthUserHandlerMethodArgumentResolver;
import com.douzone.jblog.security.LoginInterceptor;
import com.douzone.jblog.security.LogoutInterceptor;



@SpringBootConfiguration
public class WebConfig implements WebMvcConfigurer{
	
	// Interceptors
	@Bean
	public HandlerInterceptor blogInterceptor() {
		return new BlogInterceptor();
	}
	// Interceptors	
	@Bean
	public HandlerInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}	
	@Bean
	public HandlerInterceptor logoutInterceptor() {
		return new LogoutInterceptor();
	}
	@Bean
	public HandlerInterceptor authInterceptor() {
		return new AuthInterceptor();
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(blogInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/user/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/asserts/**" );
		registry.addInterceptor(loginInterceptor()).addPathPatterns("/user/auth");
		registry.addInterceptor(logoutInterceptor()).addPathPatterns("/user/logout");
		registry.addInterceptor(authInterceptor())
				.addPathPatterns("/**/admin/**")
				.excludePathPatterns("/user/auth","/user/logout","/asserts/**" );
	}
	// argument resolver
		@Bean
		public HandlerMethodArgumentResolver handlerMethodArgumentResolver() {
			return new AuthUserHandlerMethodArgumentResolver();
		}

		@Override
		public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
			resolvers.add(handlerMethodArgumentResolver());
		}

}
