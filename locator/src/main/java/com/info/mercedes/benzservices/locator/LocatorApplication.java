package com.info.mercedes.benzservices.locator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
public class LocatorApplication {
	public final static Logger logger = LoggerFactory.getLogger(LocatorApplication.class);
	
	public static void main(String[] args) {
		logger.info("LocatorApplication init started ->>");
		
		SpringApplication.run(LocatorApplication.class, args);
		
		logger.info("LocatorApplication init completed ->>");
	}

@Bean
public WebMvcConfigurer configurer() {
	return new WebMvcConfigurer() {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			// TODO Auto-generated method stub
			WebMvcConfigurer.super.addCorsMappings(registry);
		}
	};
}
}
