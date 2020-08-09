package com.info.mercedes.benzservices.locator.interceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import com.info.mercedes.benzservices.locator.service.impl.LocatorServiceImpl;

public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {
	
	public static final Logger logger = LoggerFactory.getLogger(LocatorServiceImpl.class);
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		logRequest(request,body);
		ClientHttpResponse response = execution.execute(request, body);
		logResponse(response);
		return response;
	}
	private void logResponse(ClientHttpResponse response) throws IOException {
		logger.info("==============Response begin==============");
		logger.info("Status code		:{}",response.getStatusCode());
		logger.info("Status Text		:{}",response.getStatusText());
		logger.info("Headers			:{}",response.getHeaders());
		logger.info("==============Response END================");
		
	}
	private void logRequest(HttpRequest request, byte[] body) throws IOException {
		logger.info("==============Request begin================");
		logger.info("URI				:{}",request.getURI());
		logger.info("Method				:{}",request.getMethod());
		logger.info("Request Body		:{}",new String(body,"UTF-8"));
		logger.info("==============Request END==================");
		
	}

}
