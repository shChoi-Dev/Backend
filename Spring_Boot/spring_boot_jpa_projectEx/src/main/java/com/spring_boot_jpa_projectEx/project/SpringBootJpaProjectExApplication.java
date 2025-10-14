package com.spring_boot_jpa_projectEx.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spring_boot_jpa_projectEx.project"})
public class SpringBootJpaProjectExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaProjectExApplication.class, args);
	}

}
