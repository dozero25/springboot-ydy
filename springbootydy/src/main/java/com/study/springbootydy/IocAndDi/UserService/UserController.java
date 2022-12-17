package com.study.springbootydy.IocAndDi.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService12 userService;

    @ResponseBody
    @GetMapping("/user")
    public String userServiceTest(){
      userService.createUser();
      userService.getUsers();
      userService.updateUser();
      userService.deleteUser();


      return null;
  }


}
