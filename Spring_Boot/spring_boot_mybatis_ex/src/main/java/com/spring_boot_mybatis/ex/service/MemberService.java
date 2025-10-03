package com.spring_boot_mybatis.ex.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring_boot_mybatis.ex.dao.IMemberDAO;
import com.spring_boot_mybatis.ex.model.MemberVO;

@Service
public class MemberService implements IMemberService{
	@Autowired
	@Qualifier("IMemberDAO")
	IMemberDAO dao;
	
	@Autowired
	PasswordEncoder pwdEncoder;
	
	// 비밀번호를 암호화 하지 않은 경우의 처리
//	@Override
//	public String loginCheck(HashMap<String, Object> map) {
//		return dao.loginCheck(map);
//	}
	
	@Override
	public String loginCheck(HashMap<String, Object> map) {
		// 1. 전달받은 아이디로 DB에서 암호화된 비밀번호를 조회
		String encodedPwd = dao.loginCheck((String)map.get("id"));
		
		String result = "fail";
		// 2. DB에 비밀번호가 존재하고, 입력된 평문 비밀번호와 일치하는지 확인
		if(encodedPwd != null && pwdEncoder.matches((String)map.get("pwd"), encodedPwd)) {
			result = "success";
		}
		return result;
	}

	@Override
	public String idCheck(String id) {
		return dao.idCheck(id);
	}

	@Override
	public void insertMember(MemberVO vo) {
		// 비밀번호 암호화 처리
		String encodedPwd = pwdEncoder.encode(vo.getMemPwd());
		vo.setMemPwd(encodedPwd);
		
		dao.insertMember(vo);
	}
		
}
