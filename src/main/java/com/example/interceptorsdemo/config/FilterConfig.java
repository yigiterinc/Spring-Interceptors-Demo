package com.example.interceptorsdemo.config;

import com.example.interceptorsdemo.filter.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<LoggingFilter> filterRegistrationBean() {
		FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
		LoggingFilter loggingFilter = new LoggingFilter();

		registrationBean.setFilter(loggingFilter);

		return registrationBean;
	}
}
