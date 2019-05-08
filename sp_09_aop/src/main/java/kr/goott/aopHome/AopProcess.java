package kr.goott.aopHome;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//aop 처리를 하는 클래스
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopProcess {
	Object obj =null;
	//pointcut : aop 처리대상 클래스
	@Pointcut("within(kr.goott.aopHome.*)") //저기안에 있으면 모두
	private void pointcutMethod() {
		
	}
	//around : aop 처리를 하는 메소드
	//object 리턴으로 해야함 , 		매개변수 무조건 이거로
	@Around("pointcutMethod()")
	public Object aopProcess(ProceedingJoinPoint joinpoint) throws Throwable {
		//메소드 실행전
		System.out.println("method 실행 전==========================");
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		
		//클래스 매소드 정보 불러오기(클래스명,메소드명)
		String signature = joinpoint.getSignature().toShortString();
		System.out.println("signature="+signature);
		
		//메소드 실행
		joinpoint.proceed();
		
		//메소드실행후
		System.out.println("메소드 실행후 ======================================");
		long endTime = System.currentTimeMillis();
		System.out.println(endTime);
		
		System.out.println("메소드 실행시간 : "+ (endTime-startTime));
		
		return obj;
	}
	
}
