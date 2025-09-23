package com.spring_mvc.project;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping("/redirect")
	public String redirect(Model model) {
		System.out.println("redirect");
		// /showInfo redirect
		// 클라이언트에 302응답코드 전달 및 재요청 신호 -> 클라이언트 재요청 진행
		// redirect: 는 클라이언트 요청이 http로 요청이 들어옴(서버설정 변경 필요)
		return "redirect:/showInfo";
	}
	
	// redirect 시 파라미터 전송 방법
	// 1. 쿼리 스트링 방식으로 url에 포함
	@RequestMapping("/redirectParam1")
	public String redirectParam() throws Exception {
		System.out.println("redirectParam 쿼리스트링");
		String nation="대한민국1";
		nation = URLEncoder.encode(nation,"UTF-8");
		return "redirect:/showRedirectParam/?nation="+ nation;
	}

	// 2. model 객체에 addAttribute 사용해서 전달
	@RequestMapping("/redirectParam2")
	public String redirectParam(Model model){
		System.out.println("redirectParam model 사용");
		String nation="대한민국2";
		model.addAttribute("nation", nation);
		return "redirect:/showRedirectParam";
	}
	
	// 3. RedirectAttributes 객체 메소드 addAttribute 사용
	@RequestMapping("/redirectParam3")
	public String redirectParam2(RedirectAttributes reAttr){
		System.out.println("redirectParam RedirectAttr 활용");
		String nation="대한민국3";
		reAttr.addAttribute("nation", nation);
		return "redirect:/showRedirectParam";
	}
	
	// redirect 요청 메서드
	@RequestMapping("/showRedirectParam")
	public String showRedirectParam(@RequestParam("nation") String nation, Model model){
		model.addAttribute("nation", nation);
		return "showRedirectParam";
	}
}
