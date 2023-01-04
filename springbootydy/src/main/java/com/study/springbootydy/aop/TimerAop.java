package com.study.springbootydy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class TimerAop {

    @Pointcut("@annotation(com.study.springbootydy.aop.annotation.TimerAspect)")
    private void annotationPointCut(){}

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        Object returnValue = proceedingJoinPoint.proceed();

        stopWatch.stop();
        String className = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String methodeName = proceedingJoinPoint.getSignature().getName();

        log.error("Class >>> {}, Method >> {} : {}초", className, methodeName, stopWatch.getTotalTimeSeconds());

        return returnValue;
    }


}
