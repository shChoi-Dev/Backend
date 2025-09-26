package com.spring_mvc.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	//로그인 폼 열기
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "ajax/loginForm";
	}
	
	//로그인 폼 열기
	@RequestMapping("/loginForm2")
	public String loginForm2() {
		return "ajax/loginForm2";
	}	
	
	//로그인 처리
	@ResponseBody //return 문자열이 view 페이지가 아닌 응답객체 body 속성에 첨부해서 클라이언트에게 전송
	@RequestMapping("/login")
	public String loginCheck(@RequestParam("id") String id,
							 @RequestParam("pw") String pw) {
		String result="";
		System.out.println(id);
		System.out.println(pw);
		
		if(id.equals("abcd") && pw.equals("1234"))
			result="success";
		else
			result="fail";		
		
		return result; //@ResponseBody 없는 상태의 return은 뷰페이지를 결정함
	}
}
