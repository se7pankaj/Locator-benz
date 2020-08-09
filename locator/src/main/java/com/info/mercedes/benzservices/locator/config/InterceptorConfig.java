package com.info.mercedes.benzservices.locator.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.info.mercedes.benzservices.locator.interceptor.BenzPerformanceMonitoringInterceptor;

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class InterceptorConfig {

	public BenzPerformanceMonitoringInterceptor benzPerformanceMonitoringInterceptor() {
		return new BenzPerformanceMonitoringInterceptor(true);
	}
	
	@Bean
	 public Advisor benzPerformanceMonitorAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* com.info.mercedes.benzservices.locator.service.impl.LocatorServiceImpl.*(..))");
		return new DefaultPointcutAdvisor(pointcut, benzPerformanceMonitoringInterceptor());
	}
}
