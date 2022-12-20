package com.study.springboot202210ydy.service;

import com.study.springboot202210ydy.repository.UserRepository;
import com.study.springboot202210ydy.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int addUser(UserDto userDto){ // userDto를 받는다.
        int userId = 0;
        System.out.println("데이터베이스에 insert 전 : "+userDto);
        userRepository.saveUser(userDto); // userRepository(interface)한테 전달
        System.out.println("데이터베이스에 insert 후 : "+userDto);
        return userDto.getUserId(); // 이번에 몇번 아이디를 만들었는지 출력
    }

    public UserDto getUser(int userId){
        UserDto userDto = null;
        userDto = userRepository.findUserByUserId(userId);
        return userDto;
    }
}
