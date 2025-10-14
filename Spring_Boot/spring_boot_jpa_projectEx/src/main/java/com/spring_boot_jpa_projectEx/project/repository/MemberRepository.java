package com.spring_boot_jpa_projectEx.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_boot_jpa_projectEx.project.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
	
}
