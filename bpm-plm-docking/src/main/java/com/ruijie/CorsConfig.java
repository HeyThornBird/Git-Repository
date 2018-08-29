package com.ruijie;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zhangchunhui
 * @date 2018-08-27
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

	/**
	 * 允许跨域
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*")
		.allowCredentials(true)
		.allowedMethods("*")
		.allowedHeaders("*")
		.maxAge(3600);
	}
}