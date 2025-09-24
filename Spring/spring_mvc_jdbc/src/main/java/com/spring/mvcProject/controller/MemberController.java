package com.spring.mvcProject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvcProject.dao.MemberDAO;
import com.spring.mvcProject.dto.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	MemberDAO memDao;	//DAO 객체 주입
	
	//시작 시 index 페이지 응답
	@RequestMapping("/")
	public String viewIndex() {
		return "index"; //view 결정
	}
	
	@RequestMapping("/member/memberSelect")
	public String selectMember(Model model) {
		// 1. 서비스의 처리 기능
		ArrayList<MemberDTO> memList = memDao.memberSelect();
		
		// 2. 반환된 결과를 model객체에 저장
		model.addAttribute("memList", memList);
		
		// 3. model과 함께 view페이지 반환
		return "memberSelect";
	}
	
	
}
