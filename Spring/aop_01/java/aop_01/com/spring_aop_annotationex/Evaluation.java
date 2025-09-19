package aop_01.com.spring_aop_annotationex;

public class Evaluation {
	private int kor;
	private int math;
	private int eng;
	
	
	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public void showEvlResult() {
		int total = kor+math+eng;
		double avg = total/3;
		
		System.out.println("세과목의 총점 : " + total);
		System.out.println("세과목의 평균 : " + avg);
	}
}
