package com.info.mercedes.benzservices.locator.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;

public class BenzPerformanceMonitoringInterceptor extends AbstractMonitoringInterceptor {

	private static final long serialVersionUID = 1L;
	
	private int BENZ_RESPONSE_SLA = 3000 ;
	
	public BenzPerformanceMonitoringInterceptor() {
		
	}

	public BenzPerformanceMonitoringInterceptor(boolean dynameLogger) {
		setUseDynamicLogger(dynameLogger);
	}
	@Override
	protected Object invokeUnderTrace(MethodInvocation invocation, Log logger) throws Throwable {
		String name = createInvocationTraceName(invocation);
		long start = System.currentTimeMillis();
		try {
			return invocation.proceed();
		}finally {
			long end = System.currentTimeMillis();
			long time = end-start;
			logger.info("Method "+name+"execution elapse time >> "+time+" ms");
			if(time > BENZ_RESPONSE_SLA)
				logger.info("Method execution longer than >> "+BENZ_RESPONSE_SLA+" ms");
		}
		
	}
}
