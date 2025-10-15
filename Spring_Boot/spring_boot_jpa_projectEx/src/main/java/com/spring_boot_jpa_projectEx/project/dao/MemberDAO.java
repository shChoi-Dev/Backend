package com.spring_boot_jpa_projectEx.project.dao;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot_jpa_projectEx.project.entity.MemberEntity;
import com.spring_boot_jpa_projectEx.project.repository.MemberRepository;

import jakarta.transaction.Transactional;

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
		// return memRepo.findById(id).get().getMemId();
		return memRepo.searchById(id);
	}

	@Override
	public void insertMember(MemberEntity entity) {
		memRepo.save(entity); // Repo의 기본 메소드
	}

	@Override
	public Optional<MemberEntity> myInfoUpdateForm(String memId) {
		return memRepo.findById(memId);
	}

	@Override
	@Transactional
	public void myInfoUpdate(MemberEntity entity) {
		//update 진행 - 기본 제공 메소드 save()
		String tmpPwd = memRepo.findById(entity.getMemId()).get().getMemPwd();
		entity.keepPwd(tmpPwd);
		memRepo.save(entity);
	}

	@Override
	public void myInfoDelete(String memId) {
		memRepo.deleteById(memId); // db 주문 내역관련이 없는 경우만 삭제됨 아니면 오류
	}

}
