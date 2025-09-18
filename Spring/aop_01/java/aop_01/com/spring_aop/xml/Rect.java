package aop_01.com.spring_aop.xml;

public class Rect {
	// 핵심기능 포함 클래스
	private int width;
	private int height;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	// 핵심기능 : 사각형의 넓이를 구해서 출력
	public void showRectResult() {
		System.out.println("넓이 : " +  (width * height));
		System.out.println("둘레 : " +  (2*(width + height)));
	}
}
