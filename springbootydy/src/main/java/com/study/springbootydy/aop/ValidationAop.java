package com.study.springbootydy.aop;

import com.study.springbootydy.web.exception.CustomValidException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ValidationAop {

    @Pointcut("execution(* com.study.springbootydy.web.controller.account.AccountApiController.*(..))")
    private void executePointCut() {}

    @Around("@annotation(com.study.springbootydy.aop.annotation.ValidAspect)")
    private void annotationPointCut(){}

    @Around("executePointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();

        System.out.println("AOP 작동함!!");

        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class){
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }
        if (bindingResult != null){
            if (bindingResult.hasErrors()) {
                Map<String, String> errorMap = new HashMap<>();
                bindingResult.getFieldErrors().forEach(error -> {
                    errorMap.put(error.getField(), error.getDefaultMessage());
                });
                throw new CustomValidException(errorMap);
            }
        }

        // 메소드 호출 전 처리
        Object returnValue = proceedingJoinPoint.proceed();


        return returnValue;
    }
}
