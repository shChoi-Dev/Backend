package com.spring_boot.projectEx.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot.projectEx.model.MemberVO;
import com.spring_boot.projectEx.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memService;
	
	// 로그인 폼 요청 처리
	@GetMapping("/member/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	// 로그인 처리 : 비밀번호 암호화 하지 않은 경우
	/*	@ResponseBody
		@RequestMapping("/member/login")
		public String loginCheck(@RequestParam HashMap<String, Object> param,
												   HttpSession session) {
			// 로그인 체크 결과 : id와 pwd 전달하고 로그인 성공하면 id 반환
			String memId = memService.loginCheck(param);
			System.out.println(memId);
			String result = "fail";
			// id와 pwd 일치하면 
			if(memId != null) {
				// 로그인 성공하면 세션 변수 설정
				session.setAttribute("sid", memId);
				result = "success";
		}
				
			return result; // 뷰 페이지 이름이 아닌 데이터 반환 : @ResponseBody
		}
		*/
	
	// 로그인 처리(비밀번호 암호화 한 경우) : 로그인 여부 서비스가 결정
	@ResponseBody
	@PostMapping("/member/login")
	public String loginCheck(@RequestParam HashMap<String, Object> param, HttpSession session) {
		
		String result=memService.loginCheck(param);
		
		if(result.equals("success")) {
			// 로그인 조건에 만족하면 로그인 처리(세션을 활용) : 세션변수에 id값을 저장
			session.setAttribute("sid", (String)param.get("id"));
		}
		return result;
	}
	
	// 로그아웃 처리(세션유효성 종료)
	@GetMapping("/member/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// 회원 가입 폼 요청 처리
	@GetMapping("/member/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	// id 중복 확인 처리
	@ResponseBody
	@PostMapping("/member/idCheck")
	public int idCheck(@RequestParam("id") String id) {
		int result=0;
		String id_res = memService.idCheck(id);
		
		if(id_res != null) {
			result=1;
		}
		return result;
	}
	
	// 회원 가입 요청 처리
	@PostMapping("/member/join")
	public String join(MemberVO vo,
					   @RequestParam("memHp1") String memHp1,
					   @RequestParam("memHp2") String memHp2,
					   @RequestParam("memHp3") String memHp3
						) {
		String memHp = memHp1 + "-" + memHp2 + "-" + memHp3;
		vo.setMemHP(memHp);
		memService.insertMember(vo);
		return "redirect:/member/loginForm";
	}
	
	// (추가) 마이페이지 뷰를 반환하는 메소드
    @GetMapping("/member/myPage")
    public String myPage() {
        return "mypage";
    }
	
    // (추가) 회원 정보 수정 폼으로 이동
    @GetMapping("/member/myInfoUpdateForm")
    public String myInfoUpdateForm(HttpSession session, Model model) {
        String memId = (String) session.getAttribute("sid");
        // 서비스를 통해 현재 로그인된 회원의 모든 정보를 가져옵니다.
        MemberVO memVo = memService.getMemberInfo(memId);
        
        // 전화번호를 '-' 기준으로 분리합니다.
        String[] hp = memVo.getMemHP().split("-");
        
        model.addAttribute("memVo", memVo);
        model.addAttribute("hp1", hp[0]);
        model.addAttribute("hp2", hp[1]);
        model.addAttribute("hp3", hp[2]);
        
        return "member/myInfoUpdateForm"; // 해당 경로에 JSP 파일을 생성해야 합니다.
    }
    
    // (추가) 회원 정보 수정 처리
    @PostMapping("/member/updateMember")
    public String updateMember(MemberVO vo,
                               @RequestParam("memHp1") String memHp1,
                               @RequestParam("memHp2") String memHp2,
                               @RequestParam("memHp3") String memHp3) {
        String memHp = memHp1 + "-" + memHp2 + "-" + memHp3;
        vo.setMemHP(memHp);
        
        memService.updateMember(vo);
        
        // 정보 수정 후 마이페이지로 리다이렉트
        return "redirect:/member/myPage"; 
    }
    
    // (추가) 회원 탈퇴 폼으로 이동
    @GetMapping("/member/deleteForm")
    public String deleteForm() {
        return "member/deleteForm";
    }
    
    // (추가) 회원 탈퇴 처리
    @PostMapping("/member/deleteMember")
    public String deleteMember(@RequestParam("pwd") String pwd, HttpSession session) {
        String memId = (String) session.getAttribute("sid");
        
        // 비밀번호 확인 로직
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", memId);
        map.put("pwd", pwd);
        
        String result = memService.loginCheck(map); // 기존 로그인 체크 로직 재활용
        
        if (result.equals("success")) {
            // 비밀번호가 일치하면 회원 탈퇴 처리
            memService.deleteMember(memId);
            session.invalidate(); // 세션 무효화
            return "redirect:/"; // 메인 페이지로 리다이렉트
        } else {
            // 비밀번호 불일치 시, 다시 탈퇴 폼으로
            return "redirect:/member/deleteForm"; 
        }
    }
}
