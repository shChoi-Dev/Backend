package com.spring_mvc.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	
	// productForm 페이지로 이동하는 요청 처리
	@RequestMapping("/product/productForm")
	public String productForm() {
		return "product/productForm";
	}
	
	// productForm2 페이지로 이동하는 요청 처리
	@RequestMapping("/product/productForm2")
	public String productForm2() {
		return "product/productForm2";
	}
	
	// request 객체 사용 : 메소드 파라미터로 정의
	@RequestMapping("/product/newProduct")
	public String insertStudent(HttpServletRequest request, Model model) {
		// 클라이언트 -> 컨트롤러
		String prdNo = request.getParameter("prdNo");
		String prdName = request.getParameter("prdName");
		String prdPrice = request.getParameter("prdPrice");
		String prdCompany = request.getParameter("prdCompany");
		String prdDate = request.getParameter("prdDate");
		String prdStock = request.getParameter("prdStock");
		
		// 컨트롤러 -> view
		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdCompany);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdStock", prdStock);
		
		return "product/productResult";
	}
	
	// @RequestParam 이용 : 파라미터명과 값을 받을 변수명이 동일하면 어노테이션 생략 가능
	@RequestMapping("/product/newProduct2")
	public String insertProduct2(@RequestParam("prdNo") String prdNo,
            					 @RequestParam("prdName") String prdName,
            					 @RequestParam("prdPrice") int prdPrice,
            					 @RequestParam("prdCompany") String prdCompany,
            					 @RequestParam("prdDate") String prdDate,
            					 @RequestParam("prdStock") int prdStock,
            					 Model model) {
		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdCompany);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdStock", prdStock);
		
		return "product/productResult";
	}
}
