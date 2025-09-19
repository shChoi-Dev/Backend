package com.spring_mvc.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

	// Model 사용 방식
	@RequestMapping("/bookInfoView1")
	public String showBookInfo1(Model model) {
		// Model 객체에 key-value 형태로 데이터 전달
		model.addAttribute("title", "스프링 프레임워크");
		model.addAttribute("price", 20000);
		return "book/bookInfoView"; // 실제 경로는 /WEB-INF/views/book/bookInfoView.jsp
	}

	// ModelAndView 사용 방식
	@RequestMapping("/bookInfoView2")
	public ModelAndView showBookInfo2(ModelAndView mv) {
		// addObject 메소드로 데이터를 전달
		mv.addObject("title", "스프링 프레임워크2");
		mv.addObject("price", 25000);
		mv.setViewName("book/bookInfoView"); // setViewName 메소드로 뷰 경로를 지정 /WEB-INF/views/book/bookInfoView.jsp
		return mv; // ModelAndView 객체를 반환
	}
}
