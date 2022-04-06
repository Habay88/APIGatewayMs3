package com.habay.request;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfiguration {
    @Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor
	(@Value("${service.security.secure-key-username}")String username,
	@Value("${service.security.secure-key-password}")String password		) 
    {
	
		
		return new BasicAuthRequestInterceptor(username,password);
		
	}
}
