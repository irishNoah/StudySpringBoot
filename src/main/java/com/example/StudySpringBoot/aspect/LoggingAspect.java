package com.example.StudySpringBoot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.StudySpringBoot.controller.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        logger.info("LoggingAspect - Executing method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.example.StudySpringBoot.controller.*.*(..))", returning = "result")
    public void logAfterMethod(JoinPoint joinPoint, Object result) {
        logger.info("LoggingAspect - Method executed: " + joinPoint.getSignature().getName() + ", Result: " + result);
    }

    @AfterThrowing(value = "execution(* com.example.StudySpringBoot.controller.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.error("LoggingAspect - Exception in method: " + joinPoint.getSignature().getName() + ", Exception: " + exception.getMessage());
    }
}