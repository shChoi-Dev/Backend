package com.spring_mvc.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController_A {
	//FORM 파라미터가 전다로디면 처리하는 예제
	
	@RequestMapping("/product/productForm_A")
	public String productForm() {
		
		return "product/productForm_A";
	}
	
	@RequestMapping("/product/newProduct_A")
	public String insertProduct(HttpServletRequest request, Model model) {
		String prdNo = request.getParameter("prdNo");
		
		model.addAttribute("prdNo", prdNo);
		
		return "product/productResult_A";
	}
	
	@RequestMapping("/product/productForm2_A")
	public String productForm2() {
		
		return "product/productForm2_A";
	}
	
	@RequestMapping("/product/newProduct2_A")
	public String insertProduct2(
								// @RequestParam("prdNo") String prdNo, Model model
								String prdNo, //form 태그의 파라미터명과 메소드 파라미터 변숭명이 동일하면 @RequestParam 생략 가능
								Model model
									) {
		model.addAttribute("prdNo", prdNo);
		return "product/productResult2";
	}
	
}
