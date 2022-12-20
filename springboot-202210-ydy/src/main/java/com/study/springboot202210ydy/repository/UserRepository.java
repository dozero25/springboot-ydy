package com.study.springboot202210ydy.repository;

import com.study.springboot202210ydy.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 해당 인터페이스를 xml이랑 연결할 수 있다. 이 인터페이스로 구현한 xml이 된다.
public interface UserRepository {
// repository는 항상 mapper를 가지고 있어야 한다.
    public int saveUser(UserDto userDto);
    public UserDto findUserByUserId(int userId);
}
