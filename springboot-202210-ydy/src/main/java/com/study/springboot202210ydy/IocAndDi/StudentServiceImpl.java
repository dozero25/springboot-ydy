package com.study.springboot202210ydy.IocAndDi;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Override
    public void printStudentInfo(Student student) {
        System.out.println("학번 : "+student.getStudentId());
        System.out.println("이름 : "+student.getStudentName());

    }
}
