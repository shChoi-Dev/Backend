package com.spring_boot_jpa_product.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot_jpa_product.project.entity.ProductEntity;
import com.spring_boot_jpa_product.project.repository.ProductRepository;

@Service
public class ProductDAO implements IProductDAO {

	ProductRepository prdRepo;
	
	@Autowired
	public ProductDAO(ProductRepository prdRepo) {
		this.prdRepo = prdRepo;
	}
	
	@Override
	public ArrayList<ProductEntity> listAllProduct() {
		// findAll(); 매핑된 테이블의 모든 레코드를 반환
		return (ArrayList<ProductEntity>)prdRepo.findAll();
	}

	@Override
	public void insertProduct(ProductEntity entity) {
		prdRepo.save(entity);
		// 엔티티의 id가 이미 존재한다면 update 진행
		// 아니면 insert 진행
	}

	@Override
	public void updateProduct(ProductEntity entity) {
		// update save 메소드 사용
		prdRepo.save(entity);
		
	}

	@Override
	public void deleteProduct(String prdNo) {
		prdRepo.deleteById(prdNo);
	}

	@Override
	public Optional<ProductEntity> detailViewProduct(String prdNo) {
		// 1개의 entity를 조회 메서드 : findById(id)
		return prdRepo.findById(prdNo);
	}

	@Override
	public String prdNoCheck(String prdNo) {
		return prdRepo.searchById(prdNo);
	}

	@Override
	public ArrayList<ProductEntity> productSearch(HashMap<String, String> map) {
		String type = map.get("type");
		String keyword = map.get("keyword");
		return prdRepo.productSearch(type, keyword);
	}



	
	
}
