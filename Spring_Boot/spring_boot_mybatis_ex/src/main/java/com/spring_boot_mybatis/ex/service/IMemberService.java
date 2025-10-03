package com.spring_boot_mybatis.ex.service;

import java.util.HashMap;

import com.spring_boot_mybatis.ex.model.MemberVO;

public interface IMemberService {
	public String idCheck(String id);
	public void insertMember(MemberVO vo);
	String loginCheck(HashMap<String, Object> map);
}
