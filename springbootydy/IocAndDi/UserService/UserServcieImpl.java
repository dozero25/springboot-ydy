package com.study.springbootydy.IocAndDi.UserService;

import org.springframework.stereotype.Component;

@Component
public class UserServcieImpl implements UserService{

    User user = new User();

    @Override
    public void createUser() {
        user.setUsername("윤갱");
        user.setPassword("123456");
        user.setName("윤성경");
        user.setAge(20);
    }

    @Override
    public void getUsers() {
        System.out.println(user.getName()+"의 정보를 가져옵니다.");
        System.out.println("닉네임 : "+user.getUsername());
        System.out.println("비밀번호 : "+user.getPassword());
        System.out.println("이름 : " + user.getName());
        System.out.println("나이 : " + user.getAge());
    }

    @Override
    public void updateUser() {
        System.out.println(user.getName()+"님의 정보를 업데이트 합니다.");
    }

    @Override
    public void deleteUser() {
        System.out.println(user.getName()+"님의 정보를 삭제합니다.");
    }


}
