package di_01.com.di.no_spring_no_di;

// 다른 사용자 정의 클래스를 의존하지 않음
public class NameMain {
	
	public static void main(String[] args) {
		NameController control = new NameController();
		control.show("홍길동");
	}
	
}
