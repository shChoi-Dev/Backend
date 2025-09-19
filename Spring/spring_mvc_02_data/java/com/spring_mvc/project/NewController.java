package com.spring_mvc.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewController {
	@RequestMapping("/")
	public String index() { //기본 요청을 처리하는 메소드(메뉴)
		return "index";
	}
	
	// showInfo 요청 : 컨트롤러에서 데이터를 model객체에 저장해서 view로 전달하는 메소드
	@RequestMapping("/showInfo")
	public String showInfo(Model model) { //데이터를 뷰로 전달 : model 객체를 통해서
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 30);
		return "showInfo"; //뷰페이지 이름 - /WEB-INF/views/showInfo.jsp
	}
	
	//ModelAndView 객체 : 데이터와 view 정보를 객체에 임시저장
	//데이터 : addAttribute, view 정보 : setViewName("뷰페이지명")
	//ModelAndView 객체 반환
	@RequestMapping("/showInfo2")
	public ModelAndView showInfo2(ModelAndView mv) {
		mv.addObject("name", "이몽룡");
		mv.addObject("address", "서울");
		mv.setViewName("showInfoMV"); // WEB-INF/views/showInfoMV.jsp
		return mv;
	}
	
	//Model, ModelAndView 객체 모두 주입
	@RequestMapping("/showInfo3")
	public ModelAndView showInfo3(Model model, ModelAndView mv) {
		model.addAttribute("name", "이몽룡");
		//mv.addObject("name", "성춘향"); // ModelAndView 우선(return mv)
		mv.addObject("age", 23);
		mv.setViewName("showInfo3");
		model.addAttribute("address", "남원");
		return mv;
	}
}
