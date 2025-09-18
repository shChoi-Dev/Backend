package com.spring_aop.xml2;

public class Circle {
	private int radius;
	
	   public void setRadius(int radius) {
	        this.radius = radius;
	    }
	   
	    public void showCircleResult() {
	        double area = Math.PI * radius * radius;
	        double circumference = 2 * Math.PI * radius;
	        System.out.println("------ 원의 정보 ------");
	        System.out.printf("반지름 %d의 면적: %.2f\n", radius, area);
	        System.out.printf("반지름 %d의 둘레: %.2f\n", radius, circumference);
	        System.out.println("-----------------------");
	    }
}
