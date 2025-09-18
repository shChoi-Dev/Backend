package aop_01.com.spring_aop.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		// 스프링 컨테이너 객체 생성
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");

		// 핵심 기능 bean 등록되어 있음
		Rect rect = context.getBean("rect", Rect.class); 
		rect.showRectResult();
		
		Gugudan gg = context.getBean("gugudan", Gugudan.class); 
		gg.showResult();
	}

}
