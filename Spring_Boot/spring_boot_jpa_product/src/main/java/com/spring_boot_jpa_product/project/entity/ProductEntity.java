package com.spring_boot_jpa_product.project.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring_boot_jpa_product.project.dto.ProductDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor; 
import lombok.NoArgsConstructor; 

import lombok.Builder; 

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
public class ProductEntity {
	@Id
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private String prdCompany;
	private int prdStock;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date prdDate;

    //DTO -> Entity 변환
    public static ProductEntity toEntity(ProductDTO dto) {
    	return ProductEntity.builder()
    			.prdNo(dto.getPrdNo())
    			.prdName(dto.getPrdName())
    			.prdPrice(dto.getPrdPrice())
    			.prdCompany(dto.getPrdCompany())
    			.prdStock(dto.getPrdStock())
    			.prdDate(dto.getPrdDate())
    			.build();
    }
    
}
