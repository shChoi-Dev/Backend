package com.spring_boot_jpa_projectEx.project.dao;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot_jpa_projectEx.project.entity.MemberEntity;
import com.spring_boot_jpa_projectEx.project.repository.MemberRepository;

@Service
public class MemberDAO implements IMemberDAO {
	@Autowired
	MemberRepository memRepo;
	
	@Override
	public Optional<MemberEntity> loginCheck(String id) {
		// 특정 회원에 대한 정보를 추출 findByid(id) -> Optional<Entity> -> 특정회원의 레코드
		return memRepo.findById(id);
	}

	@Override
	public String idCheck(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember(MemberEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<MemberEntity> myInfoUpdateForm(String memId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void myInfoUpdate(MemberEntity entity) {
		// TODO Auto-generated method stub
		
	}

}
