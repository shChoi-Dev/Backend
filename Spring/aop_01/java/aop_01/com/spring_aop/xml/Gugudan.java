package aop_01.com.spring_aop.xml;

public class Gugudan {
	// 핵심기능 포함 클래스
	private int dan;
	
	public int getDan() {
		return dan;
	}
	
	public void setDan(int dan) {
		this.dan = dan;
	}
	
	public void showResult() {
		for(int i=1; i<=9; i++) {
			System.out.println(dan + "*" + i + "=" + (dan*i));
		}
	}
}
