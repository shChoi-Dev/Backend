package com.spring_boot_mybatis.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//@Controller
public class HelloController {
	
//@RequestMapping("/")
//	@ResponseBody
//	@GetMapping("/")
//	public String home() {
//		System.out.println("Hello Boot!!");
//		return "Hello Boot!!"; //view로 인식해서 view를 찾음 404에러 발생, @ResponseBody 사용 Rest 응답
//	}
	
//	@GetMapping("/")
//	public String home(Model model) {
//		System.out.println("Hello Boot!!");
//		model.addAttribute("message", "안녕하세요");
//		return "hello"; // view페이지 결정
//	}
}
