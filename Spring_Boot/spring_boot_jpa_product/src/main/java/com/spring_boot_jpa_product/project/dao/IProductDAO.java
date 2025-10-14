package com.spring_boot_jpa_product.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional; //Null 반환 확신할 수 없을 때 에러방지용으로 사용 

import com.spring_boot_jpa_product.project.entity.ProductEntity;

public interface IProductDAO {
	public ArrayList<ProductEntity> listAllProduct();
	public void insertProduct(ProductEntity entity);
	public void updateProduct(ProductEntity entity);
	public void deleteProduct(String prdNo);
	
	public Optional<ProductEntity> detailViewProduct(String prdNo); // 1개 entity를 조회하는 repo method는 반환타입 Option<T> 임.
	
	public String prdNoCheck(String prdNo);
	
	public ArrayList<ProductEntity> productSearch(HashMap<String, String> map);
}
