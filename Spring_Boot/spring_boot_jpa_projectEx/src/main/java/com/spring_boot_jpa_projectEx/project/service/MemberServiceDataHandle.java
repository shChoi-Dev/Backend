package com.spring_boot_jpa_projectEx.project.service;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring_boot_jpa_projectEx.project.dao.MemberDAO;
import com.spring_boot_jpa_projectEx.project.dto.MemberDTO;
import com.spring_boot_jpa_projectEx.project.entity.MemberEntity;

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
