package com.study.springbootydy.IocAndDi.StudentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @GetMapping("/student")
    public String printStudent(){
        Student student = Student.builder()
                .studnetId(2017113014)
                .studentName("윤도영")
                .studentAge(25)
                .studentGrade(4)
                .build();

        studentService.printShowInfo(student);

        return null;


    }

}
