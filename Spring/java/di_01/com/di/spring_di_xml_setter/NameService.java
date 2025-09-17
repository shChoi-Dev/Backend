package di_01.com.di.spring_di_xml_setter;

public class NameService {
	public String showName(String name) {
		System.out.println("NameService showName() 메서드");
		String myName = "내이름은 " + name + "입니다";
		return myName;
	}
}
