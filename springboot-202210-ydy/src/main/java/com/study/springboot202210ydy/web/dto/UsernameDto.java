package com.study.springboot202210ydy.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsernameDto {
    @Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "사용자 이름을 영문, 숫자 조합 이어야하며 5자 이상 20자 이하로 작성하세요")
    private String username;



}
