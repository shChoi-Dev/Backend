package com.spring_boot_jpa_miniProject.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring_boot_jpa_miniProject.project.dto.ProductDTO;
import com.spring_boot_jpa_miniProject.project.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService prdService;
	
	@GetMapping("/") 	// http://localhost:8080/ 요청을 받으면
    public String index(Model model) { // Model 객체를 파라미터로 받음
        // 1. 서비스에 상품 목록을 요청
		List<ProductDTO> prdList = prdService.listAllProducts();
		
		// 2. 모델에 상품 목록을 "prdList"로 담음
		model.addAttribute("prdList", prdList);
		
		// 3. 뷰(JSP)로 전달
        return "index";
    }
}
