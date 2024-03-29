package com.douzone.jblog.initializer;

import javax.servlet.Filter;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.douzone.jblog.config.AppConfig;
import com.douzone.jblog.config.WebConfig;


public class JBlogWebApplicationinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Root Application Context's Configuration Class
		return new Class<?>[] {AppConfig.class};
	}

	// Dispatcher Servlet
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] {new CharacterEncodingFilter("utf-8",false)};
	}

	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {		
		DispatcherServlet servlet= (DispatcherServlet)super.createDispatcherServlet(servletAppContext);
		servlet.setThrowExceptionIfNoHandlerFound(true);
		return servlet;
	}

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		super.onStartup(servletContext);
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(new GenericWebApplicationContext());
//		ServletRegistration.Dynamic servletRegistration =  servletContext.addServlet("spring",dispatcherServlet);
//		servletRegistration.setLoadOnStartup(1);
//		
//		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
//	}
	
	
}
