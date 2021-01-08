package com.example.interceptorsdemo.interceptor;

import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		System.out.println("preHandle");

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		boolean hasGetMappingAnnotation = method.isAnnotationPresent(GetMapping.class);

		System.out.println(request.getContextPath());
		System.out.println(handlerMethod.getMethod().getName());
		System.out.println("hasGetMappingAnnotation: " + hasGetMappingAnnotation);
		System.out.println(request.getCookies());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		if (modelAndView != null)
			modelAndView.addObject("session", request.getSession());

		System.out.println("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		System.out.println("afterCompletion");
	}
}
