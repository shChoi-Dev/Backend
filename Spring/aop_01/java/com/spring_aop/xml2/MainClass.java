package com.spring_aop.xml2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// 스프링 컨테이너 생성
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config1-2.xml");
		
		// 핵심 기능 Bean 가져오기
		Evaluation eval = context.getBean("evaluation", Evaluation.class);
		eval.showResult();
		
		Circle circle = context.getBean("circle", Circle.class);
		circle.showCircleResult();
		
		// 컨테이너 종료
		context.close();
		
	}
	
}
