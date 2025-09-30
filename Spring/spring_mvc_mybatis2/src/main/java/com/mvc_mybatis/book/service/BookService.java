package com.mvc_mybatis.book.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mvc_mybatis.book.dao.IBookDAO;
import com.mvc_mybatis.book.model.BookVO;

//이 클래스가 서비스 역할을 하는 Bean임을 선언
@Service
public class BookService implements IBookService {
	// IBookDAO 타입의 Bean을 자동으로 주입 (DI)
	@Autowired
	@Qualifier("IBookDAO")
	IBookDAO dao;
	
	// 모든 도서 정보를 조회하는 메소드
	@Override
	public ArrayList<BookVO> listAllBook() {
		// DAO의 listAllBook 메소드를 호출하여 DB로부터 모든 도서 정보를 받아와 반환
		return dao.listAllBook();
	}

	// 새로운 도서 정보를 등록하는 메소드
	@Override
	public void insertBook(BookVO vo) {
		// 컨트롤러로부터 받은 BookVO 객체를 DAO로 전달하여 DB에 삽입
		dao.insertBook(vo);
		
	}

	// 도서 정보를 수정하는 메소드
	@Override
	public void updateBook(BookVO bookVo) {
		// 컨트롤러로부터 받은 BookVO 객체를 받아 DAO의 updateBook 메소드를 호출
		dao.updateBook(bookVo);
		
	}

	// 도서 정보를 삭제하는 메소드
	@Override
	public void deleteBook(String bookNo) {
		// 컨트롤러로부터 bookNo를 받아 DAO의 deleteBook 메소드를 호출
		dao.deleteBook(bookNo);
		
	}

	// 특정 도서의 상세 정보를 조회하는 메소드
	@Override
	public BookVO detailViewBook(String bookNo) {
		// 컨트롤러로부터 받은 bookNo를 DAO로 전달하여 특정 도서 정보를 DB에서 찾아 반환
		return dao.detailViewBook(bookNo);
	}

	@Override
	public String bookNoCheck(String bookNo) {
		// TODO Auto-generated method stub
		return dao.bookNoCheck(bookNo);
	}

}
