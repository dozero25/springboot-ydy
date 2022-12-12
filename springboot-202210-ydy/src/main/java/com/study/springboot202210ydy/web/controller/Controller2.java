package com.study.springboot202210ydy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class Controller2 {

    public String load(Model model){
        model.addAttribute("name", "윤도영");
        return "controller_test";
    }
}
