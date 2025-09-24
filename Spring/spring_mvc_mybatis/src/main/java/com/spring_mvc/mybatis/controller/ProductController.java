package com.spring_mvc.mybatis.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.mybatis.model.ProductVO;
import com.spring_mvc.mybatis.service.ProductService;

@Controller
public class ProductController {
	//DI 주입
	@Autowired
	ProductService service;
	
	//main 페이지
	@RequestMapping("/")
	public String viewIndex() {
		return "index"; // 메인페이지 뷰
	}
	
	//전체 상품 조회
	@RequestMapping("/product/listAllProduct")
	public String listAllProduct(Model model) {
		// 1. service 메소드 호출
		ArrayList<ProductVO> prdList = service.listAllProduct();
		// 2. model에 prdList 저장
		model.addAttribute("prdList", prdList);
		// 3. 뷰 페이지 결정 후 반환
		return "product/productListView";
	}
	
	// 상품 등록 폼 요청
	@RequestMapping("/product/newProductForm")
	public String newProductForm() {
		return "product/newProductForm";
	}
	
	
}
