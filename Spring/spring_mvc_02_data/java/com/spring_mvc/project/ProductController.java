package com.spring_mvc.project;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	// productForm3 페이지로 이동하는 요청 처리
	@RequestMapping("/product/productForm3")
	public String productForm3() {
		return "product/productForm3";
	}

	// productForm4 페이지로 이동하는 요청 처리
	@RequestMapping("/product/productForm4")
	public String productForm4() {
		return "product/productForm4";
	}
	
	// productForm5 페이지로 이동하는 요청 처리
	@RequestMapping("/product/productForm5")
	public String productForm5() {
		return "product/productForm5";
	}
	
	// productSearchForm 페이지로 이동하는 요청 처리
	@RequestMapping("/product/productSearchForm")
	public String productSearchForm() {
		return "product/productSearchForm";
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
	public String insertProduct2(@RequestParam("prdNo") String prdNo, @RequestParam("prdName") String prdName,
			@RequestParam("prdPrice") int prdPrice, @RequestParam("prdCompany") String prdCompany,
			@RequestParam("prdDate") String prdDate, @RequestParam("prdStock") int prdStock, Model model) {
		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdCompany);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdStock", prdStock);

		return "product/productResult2";
	}

	// command 객체 활용 파라미터
	@RequestMapping("/product/newProduct3")
	public String insertProduct3(Product product) { // 폼태그 통해 전달된 데이터가 객체로 자동 주입 -> model 객체에도 자동 저장
		System.out.println(product.getPrdNo());
		System.out.println(product.getPrdName());
		System.out.println(product.getPrdPrice());
		System.out.println(product.getPrdCompany());
		System.out.println(product.getPrdDate());
		System.out.println(product.getPrdStock());
		// command 객체 통해서 파라미터 값 바로 추출해서 객체에 저장 가능한 이유?
		// 파라미터명과 객체의 필드명이 동일하기 때문에 모듈이 파라미터명과 필드명으로 매칭을 시킴
		// 두 name이 다르면 매칭되지 않아 값 활용 불가능
		return "product/productResult3";
	}

	// view로 전달되는 command 객체 명 변경 어노테이션 @ModelAttribute
	@RequestMapping("/product/newProduct4")
	public String insertProduct4(@ModelAttribute("productInfo") Product product) {
		return "product/productResult4";
	}
	
	// uri 구성시 {변수명} -> 파라미터처럼 변수명이 사용되어져서 stdNo위치의 문자열은 전송 value로 사용 가능
		@RequestMapping("/product/productDetailView/{prdName}")
		public String productDetailView(@PathVariable String prdName) { //url로 전달된 값을 사용 @PathVariable 어노테이션 사용
			System.out.println(prdName);
			return "product/productResult";
		}
		
		@RequestMapping("/product/productDetailView/{prdName}/{prdStock}/{prdNo}")
		public String productDetailView1(
											@PathVariable String prdName, 
											@PathVariable String prdStock,
											@PathVariable String prdNo
											) { //url로 전달된 값을 사용 @PathVariable 어노테이션 사용
			System.out.println(prdName);
			System.out.println(prdStock);
			System.out.println(prdNo);
			return "product/productResult";
		}
		
		// select 태그의 type 파라미터와 input 태그의 keyword 파라미터가 전달
		@RequestMapping("/product/productSearch")
		public String productSearch(@RequestParam HashMap<String, Object> param, Model model) {
			//param 참조변수 통해 전달된 파라미터 출력
			System.out.println(param.get("type"));
			System.out.println(param.get("keyword"));
			// 서비스를 통해서 dbms연결 후 keyword를 통한 select 진행 후 결과 반환받는 코드
			
			//name 갤럭시로 검색한 결과가 2개 존재
			Product product = new Product();
			product.setPrdNo("16");
			product.setPrdName("아이폰16");
			product.setPrdPrice(1150000);
			product.setPrdMaker("애플코리아");

			Product product2 = new Product();
			product2.setPrdNo("17");
			product2.setPrdName("아이폰17pro");
			product2.setPrdPrice(1790000);
			product2.setPrdMaker("애플코리아");
			
	        //ArrayList 활용해서 검색 결과 저장
	        ArrayList<Product> prdList = new ArrayList<Product>();
	        prdList.add(product);
	        prdList.add(product2);
	        
	        //Model 객체에 collection 저장 후 view로 전달
	        model.addAttribute("prdList", prdList);
			
			return "product/productSearchResult";
		}
}
