package com.spring.mvcProject2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvcProject2.dao.ProductDAO;
import com.spring.mvcProject2.dto.ProductDTO;

@Controller
public class ProductController {

	@Autowired
	ProductDAO prdDao;

	// 시작 시 index 페이지 응답
	@RequestMapping("/")
	public String viewIndex() {
		return "index"; // view 결정
	}

	@RequestMapping("/product/productSelect")
	public String selectProduct(Model model) {
		// 1. 서비스의 처리 기능
		ArrayList<ProductDTO> prdList = prdDao.productSelect();
		
		// 2. 반환된 결과를 model객체에 저장
		model.addAttribute("prdList", prdList);
		
		// 3. model과 함께 view페이지 반환
		return "productSelect";
	}
}
