package di_01.com.di.no_spring_di_setter;

public class NameMain {
	
	public static void main(String[] args) {
		NameService nameService = new NameService();
		NameController control = new NameController();
		control.setNameService(nameService); //의존성 주입을 위한 인스턴스 전달
		control.show("홍길동");
	}
	
}
