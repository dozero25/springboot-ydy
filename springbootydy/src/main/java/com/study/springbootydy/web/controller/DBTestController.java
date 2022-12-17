package com.study.springbootydy.web.controller;

import com.study.springbootydy.service.UserService;
import com.study.springbootydy.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/db/test")
public class DBTestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
        return ResponseEntity.ok().body(userDto);
    }

    public ResponseEntity<?> getUser(@PathVariable int userId){
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);
    }
}
