package com.spring_boot_jpa_projectEx.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring_boot_jpa_projectEx.project.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
	
	@Query(value="SELECT m.memId FROM MemberEntity m WHERE m.memId=:id")
	String searchById(@Param("id") String memId); //param 있는 경우 param name이 우선
	
}
