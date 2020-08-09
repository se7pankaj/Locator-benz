package com.info.mercedes.benzservices.locator.service.cachekeygenerator;

import java.lang.reflect.Method;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

import com.info.mercedes.benzservices.locator.service.impl.LocatorServiceImpl;

public class SearchLocationKeyGenerator implements KeyGenerator{

	public static final Logger logger = LoggerFactory.getLogger(LocatorServiceImpl.class);
	
	@Override
	public Object generate(Object target, Method method, Object... params) {
		logger.info("Target Class: {} Method: {} Params: {}",target.getClass().getSimpleName(),method.getName(),StringUtils.arrayToDelimitedString(params, "_"));
		
		String searchKey = (String) params[0];
		StringBuffer cacheKey = new StringBuffer();
		
		cacheKey.append(searchKey).append(":").append(StringUtils.arrayToDelimitedString(params, "_"));
		
		
		logger.info("SearchLocationKeyGenerator:Generated Key {} on {}", cacheKey.toString(), new Date().toString());
		return cacheKey.toString();
		
		
	}

}
