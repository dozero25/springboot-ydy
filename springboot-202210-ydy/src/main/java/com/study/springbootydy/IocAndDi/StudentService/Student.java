package com.study.springbootydy.IocAndDi.StudentService;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Student {
    private int studnetId;
    private String studentName;
    private int studentAge;
    private int studentGrade;

}
