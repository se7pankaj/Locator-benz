package com.info.mercedes.benzservices.locator.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.info.mercedes.benzservices.locator.service.cachekeygenerator.SearchLocationKeyGenerator;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public CacheManager cachemManager() {
		return new ConcurrentMapCacheManager();
	}
	
	@Bean("SearchLocationKeyGenerator")
	public KeyGenerator keyGenerator() {
		return new SearchLocationKeyGenerator();
	}
}
