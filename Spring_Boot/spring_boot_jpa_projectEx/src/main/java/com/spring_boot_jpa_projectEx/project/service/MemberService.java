package com.spring_boot_jpa_projectEx.project.service;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring_boot_jpa_projectEx.project.dao.IMemberDAO;
import com.spring_boot_jpa_projectEx.project.dto.MemberDTO;
import com.spring_boot_jpa_projectEx.project.entity.MemberEntity;

import lombok.Builder;

@Service
public class MemberService implements IMemberService {

	@Autowired
	MemberServiceDataHandle memberServiceDataHandle;
	
	@Autowired 
	PasswordEncoder pwdEncoder;
	
	// 암호화한 비밀번호로 로그인 체크
	// (1) id를 전달해서 존재하면 DB에 있는 비밀번호(암호화된 비밀번호)를 반환 받음 
	// (2) 입력해서 전달받은 평문의 비밀번호와 암호화된 비밀번호 비교해서 일치하는지 체크
	@Override
	public String loginCheck(HashMap<String, Object> map) {		
		// (1) id를 전달해서 존재하면 DB에 있는 비밀번호(암호화된 비밀번호)를 반환 받음 
		String encodedPwd = memberServiceDataHandle.loginCheck((String)map.get("id"));
		
		// (2) 입력해서 전달받은 평문의 비밀번호와 암호화된 비밀번호 비교해서 일치하는지 체크
		// matches(평문, 암호문) : 일치 여부 반환
		String result = "fail";
		if(encodedPwd != null && pwdEncoder.matches((String)map.get("pwd"), encodedPwd)) {
			result = "success";
		}
		return result;
	}

	@Override
	public String idCheck(String id) {
		// TODO Auto-generated method stub
		return memberServiceDataHandle.idCheck(id);
	}
	


	@Override 
	public void insertMember(MemberDTO dto) { 
		//vo에서 비밀번호 추출해서 암호화 한 후 
		//setter 사용해서 암호화된 값으로 설정한 다음 
		// vo를 mapper에게 전달
		String encodedPwd = pwdEncoder.encode(dto.getMemPwd()); 
		//dto.setMemPwd(encodedPwd);	 
		//memberServiceDataHandle.insertMember(dto); 
	
	}
	
	@Override
	public MemberDTO myInfoUpdateForm(String memId) {
		// TODO Auto-generated method stub
		memberServiceDataHandle.myInfoUpdateForm(memId);
		return null;
	}

	@Override
	public void myInfoUpdate(MemberDTO myInfo) {
		// TODO Auto-generated method stub
		//memberServiceDataHandle.myInfoUpdate(myInfo);		
	}	


}
