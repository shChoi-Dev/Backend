package di_01.com.di.spring_di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.Resource;

public class NameController {
	//@Resource(name="anotherNameService")
	@Resource() // name 속성 생략 필드명과 동일한 빈을 찾아서 주입
	INameService nameService; // 인터페이스 타입 참조객체 변수

	// setter를 이용한 의존성 주입
	// spring xml을 활용한 setter 의존성 주입일때는 클래스의 기본생성자 외에 다른 형태의 생성자는 있으면 안됨
	// 주입되는 파라미터 타입에 따라 bean이 결정됨
	// 동일 타입의 bean이 있을때는 먼저 구성된 bean을 주입
	
	//@Autowired
	//@Qualifier("anotherNameService") //동일 타입 bean이 있을때 특정 bean이 주입되도록
	public void setNameService(INameService nameService) {
		this.nameService = nameService;
	}
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
}
