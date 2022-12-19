package com.study.springboot202210ydy.web.controller;

import com.study.springboot202210ydy.service.UserService;
import com.study.springboot202210ydy.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController //restcontroller은 responsebody를 달지 않아도 단 것과 같은 효과를 가진다. 데이터만 응답하려고 하면 사용한다.
@RequestMapping("/api/db/test") // 모든 요청 주소 앞에 붙는다.
public class DBTestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) { // 매개변수에 userDto를 받는데 json형태로 받는다.
        // json이면 무조건 @RequestBody를 달아준다.
        System.out.println(userDto); // 중간에 데이터를 출력해서 데이터가 잘 넘어오는지 확인한다.
        int userId = userService.addUser(userDto); //service가 가지고 있는 메서드한테 userDto를 전달한다.
//        return new ResponseEntity<>("응답할 데이터", HttpStatus.CREATED);
        return ResponseEntity.created(URI.create("/api/db/test/user/"+userId)).body(userDto); // 빌더형식
        // body에 getuserId가 얼마나 추가 했는지 출력
        // uri 객체를 생성 : URI.create()
    }

    @GetMapping("/user/{userId}") // 값이 계속 바뀌기 때문에 PathVariable를 사용
    public ResponseEntity<?> getUser(@PathVariable int userId) {
        // {userId}와 @PathVariable int userId 일치하는지 확인
       UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);
    }

}
