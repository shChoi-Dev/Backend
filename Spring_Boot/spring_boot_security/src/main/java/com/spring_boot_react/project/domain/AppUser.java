package com.spring_boot_react.project.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

//Entity 클래스에 의해 ddl 자동 구성되어져서 db에 테이블 생성
@Entity
@SequenceGenerator(
		name = "MEMBER_SEQUENCE_GENERATOR", // 자바에서 사용할 시퀀스제너레이터 명
		sequenceName = "MEMBER_SEQUENCE" // DB에 생성해놓은 시퀀스 명
		)

public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MEMBER_SEQUENCE_GENERATOR") // 입력값을 db에서 자동 생성 어노테이션
	@Column(nullable = false, updatable = false)
	private Long id;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String role;

	public AppUser() {
	}

	public AppUser(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
