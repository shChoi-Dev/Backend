package com.spring_boot.projectEx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String viewIndex() {
		return "index";
	}
}
