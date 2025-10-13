package com.spring_boot_jpa_product.project.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



public class ProductDTO {
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private String prdCompany;
	private int prdStock;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date prdDate;
    

}
