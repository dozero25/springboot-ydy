package com.study.springbootydy.web.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/account/register")
    public String loadRegister(){
        return "account/register";
    }
}
