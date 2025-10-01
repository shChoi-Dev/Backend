package com.spring_boot_mybatis.ex.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot_mybatis.ex.model.BookVO;
import com.spring_boot_mybatis.ex.service.BookService;

/**
 * 도서 관리 웹 애플리케이션의 메인 컨트롤러
 * 페이지 요청 및 반환, 비동기 데이터 요청 처리 등 대부분의 흐름을 제어
 */
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
	 * 전체 도서 정보 조회 /book/listAllBook URL 요청을 처리하는 메소드
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
	 * 도서 등록 폼 요청 /book/newBookForm URL 요청 시 도서 등록 페이지를 보여줌
	 */
	@RequestMapping("/book/newBookForm")
	public String newProductForm() {
		return "book/newBookForm";
	}

	/**
	 * 도서 정보 등록 처리 /book/insertBook URL로 POST 요청이 오면 이 메소드가 처리 폼에서 입력된 값들은 BookVO
	 * 객체(vo)에 자동으로 매핑됨
	 */
	@RequestMapping("/book/insertBook")
	public String insertProduct(BookVO vo) {
		// 1. BookService의 insertBook 메소드를 호출하여 도서 정보를 DB에 저장
		service.insertBook(vo);
		// 2. 도서 등록 후, 전체 도서 목록 페이지로 리다이렉트하여 등록 결과를 바로 확인할 수 있게 함
		return "redirect:/book/listAllBook";
	}

	/**
	 * 도서 상세 정보 조회 /book/detailViewBook/{bookNo} 형태의 URL 요청을 처리 {bookNo}
	 * 부분은 @PathVariable을 통해 변수로 받아옴
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
	 * 도서 정보 수정 폼 요청 /book/updateBookForm/{bookNo} URL 요청 시, 기존 도서 정보를 담은 수정 페이지를 반환
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
	 * 도서 정보 수정 로직 처리 updateBookForm.jsp에서 '수정' 버튼을 누르면 이 메소드가 /book/updateBook 요청을
	 * 받아 처리 폼의 input 값들은 BookVO 객체(book)에 자동으로 바인딩됨
	 */
	@RequestMapping("/book/updateBook")
	public String updateBook(BookVO book) {
		// 1. 폼에서 전달받은 book 객체를 서비스로 넘겨 DB 업데이트를 수행
		service.updateBook(book);
		// 2. 수정 완료 후, 전체 도서 목록 페이지로 리다이렉트하여 변경된 내용을 확인
		return "redirect:/book/listAllBook";
	}

	/**
	 * 도서 정보 삭제 로직 처리 /book/deleteBook/{bookNo} URL 요청을 받아 특정 도서 정보를 삭제
	 */
	@RequestMapping("/book/deleteBook/{bookNo}")
	public String deleteBook(@PathVariable String bookNo) {
		// 1. {bookNo}에 해당하는 도서 정보를 서비스에 요청하여 DB에서 삭제
		service.deleteBook(bookNo);
		// 2. 삭제 완료 후, 전체 도서 목록 페이지로 리다이렉트
		return "redirect:/book/listAllBook";
	}

	// ========================================================================= //
	// AJAX: 도서 번호 중복 확인 (6가지 비동기 방식)
	// ========================================================================= //

	/**
	 * (방법1) 도서정보 중복 확인 (Ajax - POST 방식)
	 * bookNo 클라이언트로부터 받은 도서 번호
	 * 사용 가능 여부 문자열 ("available" or "no_available")
	 */
	@ResponseBody
	@RequestMapping("/book/bookNoCheck")
	public String bookNoCheck(@RequestParam("bookNo") String bookNo) {
		String bookNo_result = service.bookNoCheck(bookNo);
		String result = "available";
		if (bookNo_result != null) {
			result = "no_available";
		}
		return result;
	}

	/**
	 * (방법2) 도서정보 중복 확인 (Ajax - GET 방식)
	 * bookNo URL 경로에 포함된 도서 번호
	 */
	@ResponseBody
	@RequestMapping("/book/bookNoCheck1/{bookNo}")
	public String bookNoCheck1(@PathVariable String bookNo) {
		String bookNo_result = service.bookNoCheck(bookNo);
		String result = "available";
		if (bookNo_result != null) {
			result = "no_available";
		}
		return result;
	}

	/**
	 * (방법3) 도서정보 중복 확인 (Fetch - GET 방식)
	 * bookNo URL 경로에 포함된 도서 번호
	 */
	@ResponseBody
	@RequestMapping("/book/bookNoCheck2/{bookNo}")
	public String bookNoCheck2(@PathVariable String bookNo) {
		String prdNo_result = service.bookNoCheck(bookNo);
		String result = "available";
		if (prdNo_result != null) {
			result = "no_available";
		}
		return result;
	}

	/**
	 * (방법4) 도서정보 중복 확인 (Fetch - POST 방식)
	 * bookNo 요청 본문(body)에 담겨온 도서 번호
	 */
	@ResponseBody
	@RequestMapping("/book/bookNoCheck3")
	public String prdNoCheck3(@RequestBody String bookNo) {
		String bookNo_result = service.bookNoCheck(bookNo);
		String result = "available";
		if (bookNo_result != null) {
			result = "no_available";
		}
		return result;
	}

	/**
	 * (방법5) 도서정보 중복 확인 (Axios - GET 방식)
	 * bookNo URL 경로에 포함된 도서 번호
	 */
	@ResponseBody
	@RequestMapping("/book/bookNoCheck4/{bookNo}")
	public String bookNoCheck4(@PathVariable String bookNo) {
		String bookNo_result = service.bookNoCheck(bookNo);
		String result = "available";
		if (bookNo_result != null) {
			result = "no_available";
		}
		return result;
	}

	/**
	 * (방법6) 도서정보 중복 확인 (Axios - POST 방식)
	 * map 요청 본문(body)에 담겨온 JSON 데이터를 HashMap으로 변환하여 받음
	 */
	@ResponseBody
	@RequestMapping("/book/bookNoCheck5")
	public String bookNoCheck5(@RequestBody HashMap<String, String> map) {
		String bookNo = map.get("bookNo");
		String bookNo_result = service.bookNoCheck(bookNo);
		String result = "available";
		if (bookNo_result != null) {
			result = "no_available";
		}
		return result;
	}
	
	
	// ========================================================================= //
	// 도서 검색 기능 (3가지 방법)
	// ========================================================================= //

	// [검색 방법 1] 도서 검색 폼 페이지를 요청 (결과는 JSON으로 받음)
	@RequestMapping("/book/bookSearchForm1")
	public String productSearchFrom1() {
		return "book/bookSearchForm1";
	}
	
	// [검색 방법 1] Ajax 요청을 받아 검색 결과를 JSON 데이터로 반환
	@ResponseBody
	@RequestMapping("/book/bookSearch1")
	public ArrayList<BookVO> bookSearch1(@RequestParam HashMap<String, Object> param, Model model) {
		// BookService를 호출하여 검색 조건(param)에 맞는 도서 목록을 조회
		ArrayList<BookVO> bookList = service.bookSearch(param);
		return bookList; // 방법 1 데이터(JSON) 반환
	}

	
	// [검색 방법 2] 도서 검색 폼 페이지를 요청 (결과는 HTML로 받음)
	@RequestMapping("/book/bookSearchForm2")
	public String bookSearchForm2() {
		return "book/bookSearchForm2";
	}

	// [검색 방법 2] Ajax 요청을 받아 검색 결과를 JSP로 렌더링한 HTML으로 반환
	@RequestMapping("/book/bookSearch2")
	public String bookSearch2(@RequestParam HashMap<String, Object> param, Model model) {
		ArrayList<BookVO> bookList = service.bookSearch(param);
		model.addAttribute("bookList", bookList);

		return "book/bookSearchResultView"; // 방법 2 결과(HTML) 반환
	}

	
	// [검색 방법 3] 도서 검색 폼 페이지를 요청 (@RestController 사용)
	@RequestMapping("/book/bookSearchForm3")
	public String bookSearchForm3() {
		return "book/bookSearchForm3";
	}
}
