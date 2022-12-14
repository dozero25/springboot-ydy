package com.study.springboot202210ydy.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private Test1 t1;

    @Autowired
    private Test2 t2;

    @ResponseBody
    @GetMapping("/student")
    public String printStudent(){
        Student student = Student.builder()
                .studentId(2001)
                .studentName("윤도영")
                .build();

        studentService.printStudentInfo(student);

        t1.print();
        t2.print();
        return null; 
    }
}
