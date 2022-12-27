package com.study.springbootydy.web.controller.account;

import com.study.springbootydy.service.UserService;
import com.study.springbootydy.web.dto.CMRespDto;
import com.study.springbootydy.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Pattern(regexp = "^[a-zA-Z\\d]{5,20}$",
            message = "사용자 이름을 영문, 숫자 조합 이어야하며<br>5자 이상 20자 이하로 작성하세요.") String username){
        userService.duplicateUsername(username);
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>("가입가능한 사용자이름", true));
    }

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });

            errorMap.forEach((k, v)-> {
                System.out.println(k+": "+ v);
            });
        }
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", userDto));
    }

}
