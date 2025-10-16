package com.spring_boot_react.project.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
	
	@RequestMapping("/error")
	public String errorHandle(HttpServletRequest request) {
		
		Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		String returnView = "";
		
		System.out.println(statusCode);
		
		if(statusCode.toString().equals("404")) {
			returnView="index";
		}
		
		return returnView;
	}
}
