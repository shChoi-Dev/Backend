package com.spring_boot_jpa_projectEx.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String viewIndex() {
		return "index";
	}
}
