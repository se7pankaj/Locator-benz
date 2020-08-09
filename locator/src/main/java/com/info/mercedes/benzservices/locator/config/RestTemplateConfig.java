package com.info.mercedes.benzservices.locator.config;

import java.util.Collections;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
/**
 * This class would do the configuration for rest template which can be use for calling rest api.
 * 
 * @author Pankaj Kumar
 *
 */
import org.springframework.web.client.RestTemplate;

import com.info.mercedes.benzservices.locator.interceptor.RequestResponseLoggingInterceptor;
@Configuration
public class RestTemplateConfig {

	private final static Logger logger = LoggerFactory.getLogger(RestTemplateConfig.class);
	
	@Bean(name = "benzAPIRestTemplate")
	public RestTemplate getBenzAPIRestTemplate() {
		logger.info("create rest template object >>");
		//CredentialsProvider credProvider = new BasicCredentialsProvider();
		//credProvider.setCredentials(authscope, credentials);
		//return null;
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
		HttpClient httpClient = clientBuilder.disableCookieManagement().build();
		
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setHttpClient(httpClient);
		factory.setConnectTimeout(15000);
		factory.setConnectionRequestTimeout(20000);
		factory.setReadTimeout(15000);
		RestTemplate restTemp = new RestTemplate();
		restTemp.setRequestFactory(new BufferingClientHttpRequestFactory(factory));
		restTemp.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
		return restTemp;
		
	}	
}
