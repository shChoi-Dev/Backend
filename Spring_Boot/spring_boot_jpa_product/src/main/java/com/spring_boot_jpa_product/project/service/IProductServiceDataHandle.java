package com.spring_boot_jpa_product.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.spring_boot_jpa_product.project.entity.ProductEntity;

public interface IProductServiceDataHandle {
	
		// 전체 상품 조회 : DAO에게 요청 -> DB에서 전체 상품(VO 여러 개(ArrayList)) 찾아서 반환
		public ArrayList<ProductEntity> listAllProduct(); 
		
		public void insertProduct(ProductEntity entity);

		public void updateProduct(ProductEntity entity);
		
		public void deleteProduct(String prdNo); 
		
		// 상세 상품 정보 조회 : detailViewProduct() : 1개의 상품 정보(기본키만 필요)를 전달 받아서 DAO에게 전달 
		//-> DB에 해당 상품 1개 찾아서 반환.
		public Optional<ProductEntity> detailViewProduct(String prdNo);
		
		//상품번호 중복 체크 
		public String prdNoCheck(String prdNo); // 상품번호 전달해서 이 번호가 존재하는지 확인
		
		// 상품 검색 방법1
		public ArrayList<ProductEntity> productSearch(HashMap<String, String> map);
		
		// 상품 검색 방법2
		//public List<ProductEntity> productSearch(HashMap<String, Object> map);
}
