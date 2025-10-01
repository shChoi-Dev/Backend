package com.spring_boot_mybatis.ex.dao;

import java.util.HashMap;

import com.spring_boot_mybatis.ex.model.MemberVO;

public interface IMemberDAO {
	//public String loginCheck(HashMap<String, Object> map);
	public String loginCheck(String id);
	public String idCheck(String id);
	public void insertMember(MemberVO vo);
	public MemberVO getMemberInfo(String username);
}
