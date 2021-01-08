package com.example.interceptorsdemo.config;

import com.example.interceptorsdemo.interceptor.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	TestInterceptor testInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(testInterceptor);
	}
}