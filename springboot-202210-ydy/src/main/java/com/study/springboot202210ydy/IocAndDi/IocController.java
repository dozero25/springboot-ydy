package com.study.springboot202210ydy.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IocController {

    @Autowired
    @Qualifier("usi3")
    //(required = false) // 필수가 아니다.
    private UserService userService;
    // ioc : spring이 직접 객체 생성을 한다.
    // 기준은 @Component을 사용한 class를 기준으로 한다.
    // 프로그램을 실행하면 Component이 있는 class를 springboot가 전부 찾아서 ioc 컨테이너에 넣어둔다.
    // ioc 컨테이너는 객체를 new 해서 저장을 한다.

    // Autowired : ioc 컨테이너를 스캔을 해서 해당 자료형을 자동으로 DI 해준다.
    // 자동으로 주입을 해준다.


    @ResponseBody
    @GetMapping("/ioc")
    public String iocTest(){
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
        return null;
    }

}
