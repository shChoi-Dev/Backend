package com.spring_mvc.project;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //bean 등록 컨트롤러 지정
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// "/" -> 서버주소:포트/컨텍스트패스/ -> localhost/project/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) { // 컨테이너로부터 요청 전달 Model 객체 전달
		logger.info("Welcome home! The client locale is {}.", locale); // log 기록(이클립스는 로그 콘솔에 기록)
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "jsp/home"; //view 파일 결정 후 리턴
	}
	
}
