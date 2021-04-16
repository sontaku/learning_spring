package aop2_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {
	
	@Before("execution (public * aop2_annotation.*.*Hello(..))")
	public void before(JoinPoint point) throws Throwable {
		String methodName = point.getSignature().getName();
		System.out.println("[*********** 사전작업] : " + methodName);
	}

	@Around("execution (public * aop2_annotation.*.*Hello(..))")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		String methodName = point.getSignature().getName();
		System.out.println("<사전작업> ##### : " + methodName);
		
		Object obj = point.proceed();
		System.out.println("<사후작업> ##### : " + methodName);
		return obj;
	}
}
