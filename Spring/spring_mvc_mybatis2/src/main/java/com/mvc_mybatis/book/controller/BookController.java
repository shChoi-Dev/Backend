package com.mvc_mybatis.book.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc_mybatis.book.model.BookVO;
import com.mvc_mybatis.book.service.BookService;

@Controller
public class BookController {
	// DI 주입
	@Autowired
	BookService service;

	// main 페이지
	@RequestMapping("/")
	public String viewIndex() {
		return "index"; // 메인페이지 뷰
	}

	// 전체 도서 정보 조회
	@RequestMapping("/book/listAllBook")
	public String listAllBook(Model model) {
		// 1. service 메소드 호출
		ArrayList<BookVO> bookList = service.listAllBook();
		// 2. model에 bookList 저장
		model.addAttribute("bookList", bookList);
		// 3. 뷰 페이지 결정 후 반환
		return "book/bookListView";
	}
	
	// 도서 등록 폼 요청
	@RequestMapping("/book/newBookForm")
	public String newProductForm() {
		return "book/newBookForm";
	}
}
