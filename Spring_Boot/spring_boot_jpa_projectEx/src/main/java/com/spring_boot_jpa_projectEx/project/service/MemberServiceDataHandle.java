package com.spring_boot_jpa_projectEx.project.service;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot_jpa_projectEx.project.dao.MemberDAO;
import com.spring_boot_jpa_projectEx.project.dto.MemberDTO;
import com.spring_boot_jpa_projectEx.project.entity.MemberEntity;

@Service
public class MemberServiceDataHandle implements IMemberServiceDataHandle {
	@Autowired
	MemberDAO dao;
	
	@Override
	public String loginCheck(String id) {
		Optional<MemberEntity> entity = dao.loginCheck(id);
		String pwd = entity.get().getMemPwd();
		return pwd;
	}

	@Override
	public String idCheck(String id) {
		return dao.idCheck(id);
	}

	@Override
	public void insertMember(MemberEntity entity) {
		dao.insertMember(entity);
	}

	@Override
	public Optional<MemberEntity> myInfoUpdateForm(String memId) {
		return dao.myInfoUpdateForm(memId);
	}

	@Override
	public void myInfoUpdate(MemberEntity entity) {
		dao.myInfoUpdate(entity);
	}

	@Override
	public void myInfoDelete(String memId) {
		dao.myInfoDelete(memId);
	}

}
