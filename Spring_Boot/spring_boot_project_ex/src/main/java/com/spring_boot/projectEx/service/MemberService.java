package com.spring_boot.projectEx.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dao.IMemberDAO;
import com.spring_boot.projectEx.model.MemberVO;

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
		// 로그인 여부 서비스가 결정(id만 dao로 전달해서 id의 레코드가 있으면 비밀번호를 전달)
		String encodedPwd = dao.loginCheck((String)map.get("id"));
		
		String result = "fail";
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

	 // (추가) 회원 정보 조회
	@Override
	public MemberVO getMemberInfo(String memId) {
		return dao.getMemberInfo(memId);
	}

	@Override
	public void updateMember(MemberVO vo) {
	// 비밀번호가 입력되었을 경우에만 암호화하여 저장
        if (vo.getMemPwd() != null && !vo.getMemPwd().isEmpty()) {
            String encodedPwd = pwdEncoder.encode(vo.getMemPwd());
            vo.setMemPwd(encodedPwd);
        }
        dao.updateMember(vo);
    }

	// (추가) 회원 탈퇴
	@Override
	public void deleteMember(String memId) {
		dao.deleteMember(memId);
	}
		
}
