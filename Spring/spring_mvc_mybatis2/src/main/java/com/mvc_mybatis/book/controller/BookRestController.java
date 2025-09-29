package com.mvc_mybatis.book.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvc_mybatis.book.model.BookVO;
import com.mvc_mybatis.book.service.BookService;

// 이 클래스가 RESTful 웹 서비스의 컨트롤러임을 선언
@RestController
public class BookRestController {

	@Autowired
	BookService bookservice;
	
	/**
	 * 도서 검색 기능 (AJAX 요청 처리)
	 * '/api/book/bookSearch' URL로 POST 요청이 오면 이 메소드가 처리
	 * @RequestParam으로 받은 파라미터를 서비스에 넘겨주고,
	 * 결과를 ArrayList<BookVO> 형태로 직접 반환 (JSON으로 자동 변환됨)
	 */
	@RequestMapping("/book/bookSearch3")
	public ArrayList<BookVO> bookSearch3(@RequestParam HashMap<String, Object> param) {
		return bookservice.bookSearch(param);
	}
}