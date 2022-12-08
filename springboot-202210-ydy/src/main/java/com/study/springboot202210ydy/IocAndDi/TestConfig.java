package com.study.springboot202210ydy.IocAndDi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public Test1 t1(){
        return new Test1();
    }

    @Bean
    public Test2 t2(){
        return new Test2();
    }
    // Configuration에서 bean을 등록하는 방법
}
