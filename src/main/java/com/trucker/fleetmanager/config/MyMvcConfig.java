package com.trucker.fleetmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig {
	
	@Bean
	public WebMvcConfigurer webMvcConfig() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry corsRegistry) {
				corsRegistry.addMapping("/**").allowedMethods("GET", "PUT", "POST", "DELETE", "PATCH").allowedHeaders("*");
			}
		};
	}
}
