package di_01.com.di.spring_di_xml_constructor;

public class NameController {
	NameService nameService;
	// NameControllern 클래스는 NameSerivce에 의존적인 클래스
	// NameService nameService = new NameService();
	// 객체 생성 직접 하지 않고 생성자를 통해서 객체 인스턴스를 전달받음
	// 의미 : 생성자를 통한 외부에서 주입받음
	// 생성자를 이용한 의존성 주입
	
	public NameController(NameService nameService) {
		this.nameService = nameService;
	}
	
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name));
	}
}
