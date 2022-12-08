package com.study.springboot202210ydy.IocAndDi;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Student{
    private int studentId;
    private String studentName;

}
