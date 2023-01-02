package com.study.springboot202210ydy.aop;

import com.study.springboot202210ydy.web.exception.CustomValidException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component // aop는 항상 @Component를 달아준다.
public class ValidationAop {

    @Pointcut("execution(* com.study.springboot202210ydy.web.controller.account.AccountApiController.*(..))")
    private void executePointCut() {}
    // 패키지 경로
    // *(..) 이 클래스 안에 있는 모든 메소드의 매개변수 몇개든 상관없다. 리턴자료형
    //  com.study.springboot202210ydy.web.controller..AccountApiController.*(..)) -> controller안에 있는 모든 패키지

    @Pointcut("@annotation(com.study.springboot202210ydy.aop.annotation.ValidAspect)")
    private void annotationPointCut() {}

    @Around("executePointCut()") // @Around : 실행되기 전과 후 둘다
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
                        // userDto, bindingResult가 여기로 가져와진다.
        Object[] args = proceedingJoinPoint.getArgs();

        for(Object arg : args) {
            System.out.println(arg);
        }

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
        // 메소드 호출 후  처리
        // 오류 뜨면 alt + enter

        return returnValue;
    }
}
