package com.spring_mvc.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	
	@RequestMapping("/student/studentForm")
	public String studentFormView() {
		return "student/studentForm";
	}
	
	@RequestMapping("/student/studentForm2")
	public String studentFormView2() {
		return "student/studentForm2";
	}
	
	// 클라이언트로부터 전송된 폼데이터를 받는 방식
	// 1.request 객체 사용 : 메소드 파라미터로 정의
	@RequestMapping("/student/newStudent")
	public String insertStudent(HttpServletRequest request, Model model) {
		// 클라이언트 -> 컨트롤러
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		
		// 컨트롤러 -> view
		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("year", year);
		
		return "student/studentResult";
	}
	
	// 2. @RequestParam 이용 : 파라미터명과 값을 받을 변수명이 동일하면 어노테이션 생략 가능
	@RequestMapping("/student/newStudent2")
	public String insertStudent2(@RequestParam("no") String no, 
								@RequestParam("name") String name,
								@RequestParam("year") String year,
								Model model) {
		// 컨트롤러 -> view
		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("year", year);
		return "student/studentResult";
	}
}
