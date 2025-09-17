package di_01.com.di.no_spring_di_constructor;

// 다른 사용자 정의 클래스를 의존하지 않음
public class NameMain {
	
	public static void main(String[] args) {
		NameService nameService = new NameService();
		// NameController 클래스 입장에서는 생성자를 통해 nameService 의존클래스 주입받고 있음
		NameController control = new NameController(nameService);
		control.show("홍길동");
	}
	
}
