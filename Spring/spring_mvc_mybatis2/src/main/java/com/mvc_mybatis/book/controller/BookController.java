package com.mvc_mybatis.book.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc_mybatis.book.model.BookVO;
import com.mvc_mybatis.book.service.BookService;

//이 클래스가 컨트롤러 역할을 하도록 지정
@Controller
public class BookController {
	// BookService 타입의 Bean을 자동으로 주입 (DI)
	@Autowired
	BookService service;

	// 루트("/") URL 요청 시 main 페이지 보여줌
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}

	/**
	 * 전체 도서 정보 조회 
	 * /book/listAllBook URL 요청을 처리하는 메소드
	 */
	@RequestMapping("/book/listAllBook")
	public String listAllBook(Model model) {
		// 1. BookService의 listAllBook 메소드를 호출하여 모든 도서 정보를 ArrayList로 받아옴
		ArrayList<BookVO> bookList = service.listAllBook();
		// 2. 받아온 도서 목록을 "bookList"라는 이름으로 Model에 추가하여 View로 전달
		model.addAttribute("bookList", bookList);
		// 3. 용자에게 보여줄 View 페이지(book/bookListView.jsp)를 지정하여 반환
		return "book/bookListView";
	}

	/**
	 * 도서 등록 폼 요청 
	 * /book/newBookForm URL 요청 시 도서 등록 페이지를 보여줌
	 */
	@RequestMapping("/book/newBookForm")
	public String newProductForm() {
		return "book/newBookForm";
	}

	/**
	 * 도서 정보 등록 처리 
	 * /book/insertBook URL로 POST 요청이 오면 이 메소드가 처리 
	 * 폼에서 입력된 값들은 BookVO 객체(vo)에 자동으로 매핑됨
	 */
	@RequestMapping("/book/insertBook")
	public String insertProduct(BookVO vo) {
		// 1. BookService의 insertBook 메소드를 호출하여 도서 정보를 DB에 저장
		service.insertBook(vo);
		// 2. 도서 등록 후, 전체 도서 목록 페이지로 리다이렉트하여 등록 결과를 바로 확인할 수 있게 함
		return "redirect:/book/listAllBook";
	}

	/**
	 * 도서 상세 정보 조회 
	 * /book/detailViewBook/{bookNo} 형태의 URL 요청을 처리 
	 * {bookNo} 부분은 @PathVariable을 통해 변수로 받아옴
	 */
	@RequestMapping("/book/detailViewBook/{bookNo}")
	public String detailViewBook(@PathVariable String bookNo, Model model) {
		// 1. URL로 전달받은 bookNo를 이용해 BookService에서 특정 도서 정보를 조회
		BookVO book = service.detailViewBook(bookNo);
		// 2. 조회된 도서 정보를 "book"이라는 이름으로 Model에 추가하여 View로 전달
		model.addAttribute("book", book);
		// 3. 사용자에게 보여줄 상세 정보 View 페이지(book/bookDetailView.jsp)를 지정
		return "book/bookDetailView";
	}

	/**
	 * 도서 정보 수정 폼 요청 
	 * /book/updateBookForm/{bookNo} URL 요청 시, 기존 도서 정보를 담은 수정 페이지를 반환
	 */
	@RequestMapping("/book/updateBookForm/{bookNo}")
	public String updateBookForm(@PathVariable String bookNo, Model model) {
		// 1. {bookNo}를 사용해 수정할 도서의 현재 정보를 DB에서 조회
		BookVO book = service.detailViewBook(bookNo);
		// 2. 조회된 정보를 "book"이라는 이름으로 Model에 담아 View(JSP)로 전달
		model.addAttribute("book", book);
		// 3. 사용자에게 보여줄 View 페이지(book/updateBookForm.jsp)를 지정
		return "book/updateBookForm";
	}

	/**
	 * 도서 정보 수정 로직 처리 
	 * updateBookForm.jsp에서 '수정' 버튼을 누르면 이 메소드가 /book/updateBook 요청을 받아 처리
	 * 폼의 input 값들은 BookVO 객체(book)에 자동으로 바인딩됨
	 */
	@RequestMapping("/book/updateBook")
	public String updateBook(BookVO book) {
		// 1. 폼에서 전달받은 book 객체를 서비스로 넘겨 DB 업데이트를 수행
		service.updateBook(book);
		// 2. 수정 완료 후, 전체 도서 목록 페이지로 리다이렉트하여 변경된 내용을 확인
		return "redirect:/book/listAllBook";
	}

	/**
	 * 도서 정보 삭제 로직 처리 
	 * /book/deleteBook/{bookNo} URL 요청을 받아 특정 도서 정보를 삭제
	 */
	@RequestMapping("/book/deleteBook/{bookNo}")
	public String deleteBook(@PathVariable String bookNo) {
		// 1. {bookNo}에 해당하는 도서 정보를 서비스에 요청하여 DB에서 삭제
		service.deleteBook(bookNo);
		// 2. 삭제 완료 후, 전체 도서 목록 페이지로 리다이렉트
		return "redirect:/book/listAllBook";
	}
}
