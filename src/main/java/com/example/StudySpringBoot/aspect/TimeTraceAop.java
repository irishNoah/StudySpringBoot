package com.example.StudySpringBoot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
	private static final Logger logger = LoggerFactory.getLogger(TimeTraceAop.class);
	
	@Around("execution(* com.example.StudySpringBoot.controller.*.*(..))")
	 public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		 long start = System.currentTimeMillis();
		 logger.info("TimeTraceAop - START: " + joinPoint.toString());
		 System.out.println("TimeTraceAop - START: " + joinPoint.getSignature().toString());
		 
		 try {
			 return joinPoint.proceed();
		 } finally {
			 long finish = System.currentTimeMillis();
			 long timeMs = finish - start;
			 logger.info("TimeTraceAop - END: " + joinPoint.toString() + " " + timeMs + "ms");
			 System.out.println("TimeTraceAop - END: " + joinPoint.getSignature().toString()+ " " + timeMs + "ms");
		 }
	 }
}
