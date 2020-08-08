package com.cbl.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry corsRegistry){
		
		corsRegistry.addMapping("/**").allowedOrigins("*").maxAge(3600L).allowedHeaders("*").exposedHeaders("Authorization").allowCredentials(true);
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INf/views/", ".jsp");
	}
	
	
}
