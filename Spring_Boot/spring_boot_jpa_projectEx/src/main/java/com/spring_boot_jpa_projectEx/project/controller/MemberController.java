package com.spring_boot_jpa_projectEx.project.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot_jpa_projectEx.project.dto.MemberDTO;
import com.spring_boot_jpa_projectEx.project.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller 
public class MemberController {
	@Autowired
	MemberService memService; 
	
	// 로그인 폼 열기 
	@RequestMapping("/member/loginForm")
	public String loginForm() {
		return "member/loginForm"; // 뷰 페이지 이름
	}
	
	// 비밀번호 암호화 한 경우 로그인 처리
	@ResponseBody
	@RequestMapping("/member/login")
	public String loginCheck(@RequestParam HashMap<String, Object> param,
											   HttpSession session) {
		
		// 로그인 체크 결과 : id와 pwd 전달하고 로그인 성공하면 로그인 결과 받음(success/fail)
		String result = memService.loginCheck(param);
		
		
		// id와 pwd 일치하면 
		if(result.equals("success")) {
			// 로그인 성공하면 HashMap에서 id값 추출해서 세션 변수 설정
			session.setAttribute("sid", param.get("id"));
		}
			
		return result; // 뷰 페이지 이름이 아닌 데이터 반환 : @ResponseBody
	}
		
	
	// 로그아웃
	@RequestMapping("/member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/"; // 인덱스로 포워딩
	}
	// 회원가입 폼 열기
	// 로그인 폼 열기
	@RequestMapping("/member/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	// ID 중복 체크
	@ResponseBody
	@RequestMapping("/member/idCheck")
	public int idCheck(@RequestParam("id") String id) {
		String id_res = memService.idCheck(id);
		
		int result=0;
		if (id_res != null) {
			result=1;
		}
		
		return result;				
	}
	
	// 회원가입
	// 전화번호 처리 : hp1, hp2, hp3 3개의 값으로 전달되기 때문에
	// memHp에 자동 안 됨
	// 별도로 받아서 추출해서 setter로 vo에 넣어줘야 함
	// (1) @RequestParam 사용
	// (2) HashMap으로 받아서 get() 추출해서 다 더함 
	@RequestMapping("/member/join")	
	public String join(MemberDTO dto,	@RequestParam("memHp1") String memHp1,
									@RequestParam("memHp2") String memHp2,
									@RequestParam("memHp3") String memHp3) { // 전화번호 3개 별도로 받아서(파라미터로), 다 더해서,vo에 저장(setter 사용해서) 
		String memHp = memHp1 + "-" + memHp2 + "-" + memHp3;
		dto.updateHp(memHp);	
		memService.insertMember(dto); 
		return "redirect:/member/loginForm"; 
	}
	
	@RequestMapping("/member/myPage")
	public String myPage() {
		return "member/mypage";
	}
	
	@RequestMapping("/member/myInfoUpdateForm")
	public String myInfoUpdate(HttpSession session, Model model) {
		String memId = (String)session.getAttribute("sid");
		MemberDTO myInfo = memService.myInfoUpdateForm(memId);
		model.addAttribute("myInfo",myInfo);
		return "member/updateForm";
	}
	
	@PostMapping("/member/myInfoUpdate")
	public String myInfoUpdate(MemberDTO dto, Model model, 
			@RequestParam("memHp1") String memHp1,
			@RequestParam("memHp2") String memHp2,
			@RequestParam("memHp3") String memHp3) {  
			String memHp = memHp1 + "-" + memHp2 + "-" + memHp3;
			dto.updateHp(memHp);
			memService.myInfoUpdate(dto);
			model.addAttribute("state", "update");
			return "member/mypage";
	}
	
	@GetMapping("/member/myInfoDelete")
	public String myInfoDelete(HttpSession session) {
		String memId = (String)session.getAttribute("sid");
		memService.myInfoDelete(memId);
		session.invalidate();
		return "redirect:/";
	}
}
