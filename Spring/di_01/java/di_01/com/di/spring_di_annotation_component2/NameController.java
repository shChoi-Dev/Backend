package di_01.com.di.spring_di_annotation_component2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NameController {
	@Autowired
	private INameService nameService; // 인터페이스 타입 참조객체 변수

//	public void setNameService(INameService nameService) {
//		this.nameService = nameService;
//	}
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
}
