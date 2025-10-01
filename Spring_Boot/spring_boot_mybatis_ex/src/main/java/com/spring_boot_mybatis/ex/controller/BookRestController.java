package com.spring_boot_mybatis.ex.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_mybatis.ex.model.BookVO;
import com.spring_boot_mybatis.ex.service.BookService;


/**
 * 도서 관련 RESTful API 요청을 전담하는 컨트롤러
 * @RestController는 클래스 내 모든 메소드에 @ResponseBody가 적용되어,
 * 뷰(View)가 아닌 데이터(JSON)를 반환하는 데 특화되어 있음
 */
@RestController
public class BookRestController {

	@Autowired
	BookService bookservice;
	
	/**
	 * [검색 방법 3] REST 방식으로 도서 검색 요청을 처리
	 * param 'type'과 'keyword'를 담은 HashMap
	 * 검색된 도서 목록 (Spring에 의해 JSON 배열로 자동 변환)
	 */
	@RequestMapping("/book/bookSearch3")
	public ArrayList<BookVO> bookSearch3(@RequestParam HashMap<String, Object> param) {
		return bookservice.bookSearch(param);
	}
}