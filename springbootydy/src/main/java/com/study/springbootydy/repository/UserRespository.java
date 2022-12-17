package com.study.springbootydy.repository;

import com.study.springbootydy.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRespository {
    public int saveUser(UserDto userDto);
    public UserDto findUserById(int Id);
}
