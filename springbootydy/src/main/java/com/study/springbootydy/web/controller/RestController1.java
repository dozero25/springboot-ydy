package com.study.springbootydy.web.controller;

import com.study.springbootydy.web.dto.CMRespDto;
import com.study.springbootydy.web.dto.UserDto;
import com.study.springbootydy.web.exception.CustomTestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestController1 {

    @GetMapping("/api/test/user-dto/str")
    public String getUserDtoStr(){
        UserDto userDto = UserDto.builder()
                .userId(10)
                .username("노로로")
                .password("1234")
                .name("노지민")
                .build();
        return userDto.toString();
    }
    @GetMapping("/api/test/user-dto/obj")
    public ResponseEntity<?> getUserDtoObj(){
        UserDto userDto = UserDto.builder()
                .userId(11)
                .username("주뇨이")
                .password("12345")
                .name("박준용")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("UserDto", userDto.toString());
        return ResponseEntity.ok()
                .headers(headers)
                .body(userDto);
    }
    @GetMapping("/api/test/user-dto/cm")
    public ResponseEntity<?> getUserDto(){
        UserDto userDto = UserDto.builder()
                .username("전갱이")
                .password("123456")
                .name("윤성경")
                .build();
        return ResponseEntity.ok().body(new CMRespDto<>("test유저 정보 응답", userDto));
    }

    @PostMapping("/api/test/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto){
        if(userDto.getUsername().isBlank()){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "아이디를 입력하세요.");

            throw new CustomTestException("유효성 검사 실패", errorMap);
        }

        userDto.setUserId(200);
        return ResponseEntity.created(null).body(new CMRespDto<>(userDto.getUserId()+ "사용자 추가 성공!", userDto));
    }
}
