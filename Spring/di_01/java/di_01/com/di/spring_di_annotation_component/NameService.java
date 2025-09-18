package di_01.com.di.spring_di_annotation_component;

import org.springframework.stereotype.Component;

// 다른 사용자 정의 크래스를 의존하지 않음
// 주입되어지는 클래스
// bean 등록 : 자동등록
@Component
public class NameService implements INameService {
	@Override
	public String showName(String name) {
		System.out.println("NameService showName() 메서드");
		String myName = "내이름은 " + name + "입니다";
		return myName;
	}
}
