package com.study.springboot202210ydy.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface PrintTestAspect {
    // RetentionPolicy.RUNTIME : RUNTIME 시점에서 사용할 것이다.
    // ElementType.TYPE : TYPE은 class를 뜻함
    // ElementType.METHOD : 이 annotation을 어디에 사용할  것인지.
}
