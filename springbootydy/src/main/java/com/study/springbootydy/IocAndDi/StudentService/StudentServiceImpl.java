package com.study.springbootydy.IocAndDi.StudentService;

import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService{
    @Override
    public void printShowInfo(Student student) {
        System.out.println("학번 : "+student.getStudnetId());
        System.out.println("이름 : "+student.getStudentName());
        System.out.println("나이 : "+student.getStudentAge());
        System.out.println("학년 : "+student.getStudentGrade());
    }
}
