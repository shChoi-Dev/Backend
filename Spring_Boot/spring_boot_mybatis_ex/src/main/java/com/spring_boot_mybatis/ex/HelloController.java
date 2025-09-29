package com.spring_boot_mybatis.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/")
	public String home(Model model) {
		System.out.println("Hello Boot!!");
		model.addAttribute("message", "안녕하세요");
		return "hello"; // view페이지 결정
	}
}
