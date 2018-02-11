package com.spring.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 以java的形式修改web配置
 * @author wang_donggang
 */
@Configuration
@EnableWebMvc // 注解用于启动Spring MVC特性
public class WebAdapter extends WebMvcConfigurerAdapter {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// 加入自定义的拦截器
		registry.addInterceptor(new WebInterceptor());
		
		super.addInterceptors(registry);
	}
	
}
