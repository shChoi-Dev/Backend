package com.spring_mvc.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController_Answer {
	@RequestMapping("/bookInfoView1_A")	//http://localhost:80/project.bookInfoView1
	public String showBookInfo(Model model) {
		model.addAttribute("title", "스프링프레임워크");
		model.addAttribute("price", 20000);
		return "book/bookInfoView_A"; //해당 문자열이 프런트컨트롤럴로 반환되면서 model 객체도 같이 전송됨
	}
	
	@RequestMapping("/bookInfoView2_A")
	public ModelAndView showBookInfo2(ModelAndView mView) {
			mView.addObject("title","스프링프레임워크2");
			mView.addObject("price", 20000);
			mView.setViewName("book/bookInfoView_A");
		return mView;
	}
	
	//다중맵핑
	@RequestMapping(value= {"/book/bookInfoView3","book/bookInfoView4"})
	public String showBookInfo34(HttpServletRequest request, Model model) {
		if(request.getServletPath().equals("book/bookInfoView3")) {
			model.addAttribute("title", "스프링프레임워크3");
			model.addAttribute("price", 20000);
		} else {
			model.addAttribute("title", "스프링프레임워크4");
			model.addAttribute("price", 20000);
		}
		return "book/bookInfoView_A";
	}
}
