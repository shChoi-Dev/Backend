package com.di.spring_di_xml_constructor_ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		// 스프링 컨테이너(IoC 컨테이너)를 생성
		AbstractApplicationContext context = new GenericXmlApplicationContext("Application-context1_1.xml");
		
		// 컨테이너로부터 필요한 객체(bean)를 요청
		TV tv = context.getBean("tv", TV.class);
		
		// 객체의 메서드를 호출
		tv.volumeUp();
		tv.volumeDown();
		
		// 컨테이너 닫기
		context.close();
		
	}
	
}
