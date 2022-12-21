package com.study.springboot202210ydy.web.controller;

import com.study.springboot202210ydy.web.dto.CMRespDto;
import com.study.springboot202210ydy.web.dto.UserDto;
import com.study.springboot202210ydy.web.exception.CustomTestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController // 데이터 주고받는 용도, api
public class RestController1 {

    @GetMapping("/api/test/user-dto/str")
    public String getUserDtoStr(){
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        return userDto.toString();
    }

    @GetMapping("/api/test/user-dto/obj")
    public ResponseEntity<?> getUserDtoObj(){ // object는 최상위 클래스라서 사용해도 된다. (UserDto)
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("UserDto", userDto.toString());
        return ResponseEntity.ok()
                .headers(headers)
                .body(userDto);
//        return new ResponseEntity<>(headers, HttpStatus.OK);
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(userDto);
//        아래 위 전부 같은 결과를 출력한다
//        return new ResponseEntity<>(userDto, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/api/test/user-dto/cm")
    public ResponseEntity<?> getUserDto(){
        UserDto userDto = UserDto.builder()
                .username("test")
                .password("1234")
                .build();
        return ResponseEntity.ok().body(new CMRespDto<>("test유저 정보 응답", userDto));
        // CMRespDto : 공동응답객체 , commit message
    }

    @PostMapping("/api/test/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto){

        if(userDto.getUsername().isBlank()){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "아이디를 입력하세요.");

            throw  new CustomTestException("유효성 검사 실패", errorMap);
        }

        userDto.setUserId(200);
        return ResponseEntity.created(null)
                .body(new CMRespDto<>(userDto.getUserId() + "사용자 추가 성공!", userDto));
    }


}
