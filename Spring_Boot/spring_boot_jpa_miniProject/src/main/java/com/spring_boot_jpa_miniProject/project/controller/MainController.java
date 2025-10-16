package com.spring_boot_jpa_miniProject.project.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
	// http://localhost:8080/ 요청을 받으면
    @GetMapping("/")
    public String index() {
        // "index" 라는 이름의 뷰(JSP)를 반환
        return "index";
    }
}
