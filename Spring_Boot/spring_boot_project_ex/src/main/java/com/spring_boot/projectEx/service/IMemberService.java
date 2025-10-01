package com.spring_boot.projectEx.service;

import java.util.HashMap;

import com.spring_boot.projectEx.model.MemberVO;

public interface IMemberService {
	public String loginCheck(HashMap<String, Object> map);
	public String idCheck(String id);
	public void insertMember(MemberVO vo);
}
