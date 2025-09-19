package com.spring_mvc.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	//bean 생성 및 클래스의 용도도 전달
public class NewController {
	
	// 컨트롤러의 요청과 응답
	// 컨트롤러가 요청을 받기위해
	// 처리할 uri : context path / 처리 uri
	@RequestMapping("/newView") // contextpath/newView로 들어온 요청이 메소드로 전달(호출되면서 관련 정보객체가 전달됨)
	public String newView() {
		
		return "newView"; //view 파일 결정해서 반환
	}
	
}
