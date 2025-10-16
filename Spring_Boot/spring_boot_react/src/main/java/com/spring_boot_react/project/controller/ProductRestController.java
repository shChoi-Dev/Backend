package com.spring_boot_react.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_react.project.model.ProductVO;
import com.spring_boot_react.project.service.ProductService;

@CrossOrigin("*") // 자원 요청 주체가 현재 서버가 응답한 페이지가 아니어도 요청에 응답
@RestController
public class ProductRestController {
	@Autowired
	ProductService prdService;
	
	@GetMapping("hello")
	public String hello() {
		return "안녕하세요";
	}
	
	//전체상품조회
	@GetMapping("/product/productList")
	public ArrayList<ProductVO> viewProductList(){
		return prdService.listAllProduct();
		// 서버 반환 형식이 ArrList면 react에서 response.data 사용가능
		
	}
	
	// 상품 상세 정보 조회
	@GetMapping("/product/productDetailView/{prdNo}")
	public ProductVO detailViewProduct(@PathVariable String prdNo) {
		return prdService.detailViewProduct(prdNo);
	}
	
	// 상품 등록
	@PostMapping("/product/insert")
	public void insertProduct(ProductVO vo) {
		prdService.insertProduct(vo);		
	}
	
	// 상품정보 수정
	//@PostMapping("/product/update")
	//@RequestMapping("/product/update", method=RequestMethod.PUT)
	@PutMapping("/product/update")
	public void updateProduct(ProductVO vo) {
		prdService.updateProduct(vo);		
	}
	
	// 상품정보 삭제
	//@GetMapping("/product/delete/{prdNo}")
	@DeleteMapping("/product/delete/{prdNo}")
	public void deleteProduct(@PathVariable String prdNo) {
		prdService.deleteProduct(prdNo);		
	}
	
}
