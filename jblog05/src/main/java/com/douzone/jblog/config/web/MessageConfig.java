package com.douzone.jblog.config.web;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageConfig {
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.addBasenames("com/douzone/jblog/web/messages/messages_ko","com/douzone/jblog/web/messages/messages_en");
		messageSource.setDefaultEncoding("utf-8");
		return messageSource;		
	}
}
