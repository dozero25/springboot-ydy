package com.study.springboot202210ydy.repository;

import com.study.springboot202210ydy.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRespository {
// repository는 항상 mapper를 가지고 있어야 한다.
    public int saveUser(UserDto userDto);
    public UserDto findUserById(int userId);
}
