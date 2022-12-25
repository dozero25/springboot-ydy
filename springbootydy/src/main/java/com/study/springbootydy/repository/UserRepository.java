package com.study.springbootydy.repository;

import com.study.springbootydy.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    public int saveUser(UserDto userDto);
    public List<UserDto> getUsers();
    public UserDto findUserById(int userId);
    public UserDto findUserByUsername(String username);
}
