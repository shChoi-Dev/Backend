package com.spring_aop.xml2;

public class Evaluation {
	private int kor;
	private int eng;
	private int math;

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public void showResult() {
		int total = kor + eng + math;
		double average = total / 3.0;
		System.out.println("--- 점수 결과 ---");
		System.out.println("총점: " + total);
		System.out.printf("평균: %.2f\n", average);
		System.out.println("-----------------");
	}

}
