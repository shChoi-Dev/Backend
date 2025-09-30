package com.spring_boot_mybatis.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.spring_boot_mybatis.project.controller.ProductController;

@SpringBootApplication	// 현재 프로젝트가 스프링부트 어플리케이션으로 설정
//@ComponentScan(basesPackageClasses=ProductController.class) // 개별 클래스 빈 등록
@ComponentScan(basePackages= {"com.spring_boot_mybatis.project"})
@MapperScan(basePackages= {"com.spring_boot_mybatis.project"})
public class SpringBootMybatisApplication {

	public static void main(String[] args) {	// 반드시 포함되어야 함 스프링 부트 프로젝트의 시작점
		SpringApplication.run(SpringBootMybatisApplication.class, args);
	}

}
