package com.study.springboot202210ydy.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
// 위에 4개는 필수라고 생각하면 된다.
public class UserDto {
    private int userId;
    private String userName;
    private String password;
    private String name;
    private String email;

}
