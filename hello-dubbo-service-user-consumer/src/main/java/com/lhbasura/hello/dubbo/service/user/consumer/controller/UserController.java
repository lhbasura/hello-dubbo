package com.lhbasura.hello.dubbo.service.user.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lhbasura.hello.dubbo.service.user.api.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Reference(version = "${user.service.version}")
    private UserService userService;

    @GetMapping("hi")
    public String sayHello()
    {
        return userService.sayHi();
    }

}
