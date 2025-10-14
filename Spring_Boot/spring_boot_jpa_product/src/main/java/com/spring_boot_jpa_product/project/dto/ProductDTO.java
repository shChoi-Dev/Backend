package com.spring_boot_jpa_product.project.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring_boot_jpa_product.project.entity.ProductEntity;

import lombok.AllArgsConstructor; // 클래스의 모든 필드를 인자로 포함하고 있는 생성자를 구성해주는 어노테이션 클래스
import lombok.NoArgsConstructor; // 인자가 없는 기본생성자 구성 어노테이션 클래스

import lombok.Builder; //DTO <-> Entity 변환

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Setter //Setter 자동 생성
//@Data //@Getter / @Setter /@ToString / @NoArgsConstructor 등을 합쳐놓은 annotation
@Getter //Getter 자동 생성
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class ProductDTO {
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private String prdCompany;
	private int prdStock;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date prdDate;
    
    //Entity -> DTO 변환 메소드
    public static ProductDTO toDto(ProductEntity entity) {
    	return ProductDTO.builder() //builder 클래스 객체 인스턴스 생성
    			.prdNo(entity.getPrdNo())
    			.prdName(entity.getPrdName())
    			.prdPrice(entity.getPrdPrice())
    			.prdCompany(entity.getPrdCompany())
    			.prdStock(entity.getPrdStock())
    			.prdDate(entity.getPrdDate())
    			.build(); //ProductDTO 객체 생성자 호출
    }

}
