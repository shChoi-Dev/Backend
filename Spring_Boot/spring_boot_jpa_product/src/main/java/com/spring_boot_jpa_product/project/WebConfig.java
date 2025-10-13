package com.spring_boot_jpa_product.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 프로젝트 외부 경로 이미지 맵핑 설정 
		// 맵핑 이름 : prd_images
		registry.addResourceHandler("/product_images/**")
		.addResourceLocations("file:///C:/Users/Web-dev/workspaceSpring/product_images/");
		
		// upload 폴더의 이미지 출력하기 위해 맵핑 설정 / audio 추가
		registry.addResourceHandler("/images/**", "/audio/**")
		.addResourceLocations("file:///C:/springWorkspace/upload/");
	}
}
