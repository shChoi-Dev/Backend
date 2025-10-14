package com.spring_boot.projectEx.service;

import java.util.HashMap;

import com.spring_boot.projectEx.model.MemberVO;

public interface IMemberService {
	public String loginCheck(HashMap<String, Object> map);
	public String idCheck(String id);
	public void insertMember(MemberVO vo);
	
	// (추가) 회원 정보 조회
	MemberVO getMemberInfo(String memId); 
	
	// (추가) 회원 정보 수정
	void updateMember(MemberVO vo);
	
	// (추가) 회원 탈퇴
	void deleteMember(String memId);
}
