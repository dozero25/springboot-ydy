package com.study.springbootydy.service;

import com.study.springbootydy.repository.UserRespository;
import com.study.springbootydy.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public int addUser(UserDto userDto){
        int userId = 0;
        userId = userRespository.saveUser(userDto);
        return userId;
    }

    public UserDto getUser(int userId){
        UserDto userDto = null;
        userDto = userRespository.findUserById(userId);
        return userDto;
    }

}
