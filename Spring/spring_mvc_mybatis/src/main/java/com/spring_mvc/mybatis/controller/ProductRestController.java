package com.spring_mvc.mybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_mvc.mybatis.model.ProductVO;
import com.spring_mvc.mybatis.service.ProductService;

@RestController // 클래스 빈등록, 컨트롤러 의미전달, 메소드는 Rest 방식의 응답처리
public class ProductRestController {
	@Autowired
	ProductService prdService;
	
	//@ResponseBody 없음
	@RequestMapping("/product/productSearch3")
	public ArrayList<ProductVO> productSearch3(@RequestParam HashMap<String, Object> param) {
		ArrayList<ProductVO> prdList= prdService.productSearch(param);
		return prdList;
	}
}
