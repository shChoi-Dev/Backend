package com.spring_mvc.mybatis.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_mvc.mybatis.dao.IProductDAO;
import com.spring_mvc.mybatis.model.ProductVO;

@Service
public class ProductService implements IProductService {
	@Autowired
	@Qualifier("IProductDAO")
	IProductDAO dao;
	
	@Override
	public ArrayList<ProductVO> listAllProduct() {
		return dao.listAllProduct();
	}

	@Override
	public void insertProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(ProductVO prdVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(String prdNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductVO detailViewProduct(String prdNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
