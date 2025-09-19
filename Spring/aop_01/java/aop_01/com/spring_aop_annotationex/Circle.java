package aop_01.com.spring_aop_annotationex;

public class Circle {
	private double r;
	final double pie=3.14;
	
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	
	public void showResult() {
		System.out.println("원의 넓이 : " + (r*r*pie));
		System.out.println("원의 둘레 : " + (r*2*pie));
	}
}
