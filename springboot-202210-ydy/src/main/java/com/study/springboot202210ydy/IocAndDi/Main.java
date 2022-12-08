package com.study.springboot202210ydy.IocAndDi;

public class Main {

    private final UserService userService;

    public Main(UserService userService){
        this.userService = userService;
    }
    // public Main(){
    // this.userService = UserServiceImpl.getInstance; }
    // -> main이 생성되어야 사용 가능, 일체형으로 의존성이 높다.

    public void run() {
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
    }

    public static void main(String[] args){
        UserService userService = UserServiceImpl.getInstance();
        Main main = new Main(userService);
        // 객체를 주입시켜 의존성을 높인다. DI

        main.run();


    }
}
