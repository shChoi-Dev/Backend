package aop_01.com.spring_aop_annotationex;

import java.text.SimpleDateFormat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // advice 클래스(Proxy 역할)
public class PerfomanceAspect {
	//where : aop_01.com.spring_aop_annotationex 패키지 하위의 모든 클래스에 advice 적용
	@Pointcut("within(aop_01.com.spring_aop_annotationex.*)")
	private void pointcutMethod() {
		
	}
	// what : trace(), when:around(핵심기능 수행 전과 후)
	@Around("pointcutMethod()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		// JoinPoint : 특정포인트(핵심 기능 메소드 호출 시 삽입)
		Signature s = joinPoint.getSignature(); // 설정되어 있는 핵심기능에 대한 정보를 추출
		String methodName = s.getName(); // 핵심기능 메소드명
		
		Object result = null; //반환결과 저장 변수
		
		// 공통작업 코드
		System.out.println("-----------------------------------------------------------------");
		System.out.println("[Log] Before : " + methodName + "() 실행 시작");
		
		long curLong = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.SSS");
		String curTime = sdf.format(curLong);
		System.out.println("[Log] 시작시간 " + curTime );
		
		System.out.println("-----------------------------------------------------------------");
		long startTime = System.nanoTime(); // 현재 시간과는 상관없이 시작시간과 종료시간의 차이로 수행시간 계산시 사용(성능확인용)
		
		try {
			joinPoint.proceed(); // 핵심 기능 수행
		}catch(Exception e) {
			System.out.println("[Log] Exception : " + methodName);
		}
		
		long endTime = System.nanoTime();
		
		long curLong2 = System.currentTimeMillis();
		String curTime2 = sdf.format(curLong2);
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println("[Log] After : " + methodName + "() 실행 종료");
		System.out.println("[Log] 종료시간 " + curTime2 );
		System.out.println("[Log] After : " + methodName + "() 실행시간 : " + (endTime-startTime) + "ns");
		System.out.println("-----------------------------------------------------------------");
		
		return result;
	}
}
