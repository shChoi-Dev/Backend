package com.mvc_mybatis.book.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mvc_mybatis.book.dao.IBookDAO;
import com.mvc_mybatis.book.model.BookVO;

@Service
public class BookService implements IBookService {
	@Autowired
	@Qualifier("IBookDAO")
	IBookDAO dao;
	
	
	@Override
	public ArrayList<BookVO> listAllBook() {
		return dao.listAllBook();
	}

	@Override
	public void insertBook(BookVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook(BookVO bookVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(String bookNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BookVO detailViewBook(String bookNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
