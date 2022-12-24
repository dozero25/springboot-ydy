package com.study.springbootydy.web.controller.account;

import com.study.springbootydy.web.dto.CMRespDto;
import com.study.springbootydy.web.exception.CustomDuplicateUsernameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AccountApiControllerAdvice {

    @ExceptionHandler(CustomDuplicateUsernameException.class)
    public ResponseEntity<?> duplicateError(CustomDuplicateUsernameException e){
        return ResponseEntity
                .badRequest()
                .body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }
}
