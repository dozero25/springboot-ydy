package com.study.springbootydy.web.cotroller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {

    @GetMapping("/page1")
    public ModelAndView page1(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("page1");
        mav.addObject("key", "value");
        return mav;
    }

    @GetMapping("/page2")
    public String page2(){
        return "page2";
    }
}
