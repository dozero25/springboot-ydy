package com.study.springbootydy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ParamsAop {

    @Pointcut("@annotation(com.study.springbootydy.aop.annotation.ParamsAspect)")
    private void annotationPointCut(){}

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature();
        String className = codeSignature.getDeclaringTypeName();
        String methodeName = codeSignature.getName();

        String[] argNames = codeSignature.getParameterNames();
        Object[] args = proceedingJoinPoint.getArgs();

        for (int i = 0; i < argNames.length; i++){
            log.info("Params >>> {}.{}({}) : {}", className, methodeName, argNames[i], args[i]);
        }

        Object returnValue = proceedingJoinPoint.proceed();

        return returnValue;
    }

}
