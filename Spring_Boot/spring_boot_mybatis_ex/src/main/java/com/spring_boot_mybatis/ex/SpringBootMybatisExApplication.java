package com.spring_boot_mybatis.ex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring_boot_mybatis.ex.dao") // DAO 인터페이스 경로 추가
public class SpringBootMybatisExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisExApplication.class, args);
	}

}
