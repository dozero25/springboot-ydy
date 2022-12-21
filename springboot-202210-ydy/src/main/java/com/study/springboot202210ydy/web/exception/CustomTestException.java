package com.study.springboot202210ydy.web.exception;

import lombok.Getter;

import java.util.Map;

public class CustomTestException extends RuntimeException{

    @Getter
    private Map<String, String > errorMap;

    public CustomTestException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }
}
