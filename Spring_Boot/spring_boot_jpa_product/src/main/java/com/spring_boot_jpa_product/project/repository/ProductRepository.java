package com.spring_boot_jpa_product.project.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring_boot_jpa_product.project.entity.ProductEntity;

//@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
	// JpaRepository를 통해서 기본 CRUD 기능 자동 추가 됨 - 관련 method 사용
	
	// 사용자 정의 Repo 메소드
	// @Query를 이용 sql 구문 활용
	@Query(value="SELECT p.prdNo FROM ProductEntity p WHERE p.prdNo=:prdNo")
	String searchById(@Param("prdNo") String prd_No);
	
	@Query(value="SELECT p FROM ProductEntity p "
			+ "WHERE(:type='prdName' AND p.prdName LIKE CONCAT('%',:keyword, '%')) "
			+ "OR (:type='prdCompany' AND p.prdCompany LIKE CONCAT('%',:keyword,'%'))")
	ArrayList<ProductEntity> productSearch(@Param("type") String type, @Param("keyword") String keyword);
}
