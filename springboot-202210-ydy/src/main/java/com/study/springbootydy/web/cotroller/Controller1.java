package com.study.springbootydy.web.cotroller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller1 {

    @GetMapping("/page1")
    public String page1(){
        return "page1";
    }

    @GetMapping("/page2")
    public String page2(){
        return "page2";
    }
}
