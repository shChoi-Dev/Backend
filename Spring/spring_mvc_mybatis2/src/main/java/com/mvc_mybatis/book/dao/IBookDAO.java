package com.mvc_mybatis.book.dao;

import java.util.ArrayList;

import com.mvc_mybatis.book.model.BookVO;

public interface IBookDAO {
	ArrayList<BookVO> listAllBook(); 	  // 전체 도서 조회
	void insertBook(BookVO vo); 		  // 도서 정보 등록
	void updateBook(BookVO bookVo);	 	  // 도서 정보 수정
	void deleteBook(String bookNo);		  // 도서 정보 삭제
	BookVO detailViewBook(String bookNo); //상세 도서 조회
	String bookNoCheck(String bookNo);    //도서번호 중복 확인
}
