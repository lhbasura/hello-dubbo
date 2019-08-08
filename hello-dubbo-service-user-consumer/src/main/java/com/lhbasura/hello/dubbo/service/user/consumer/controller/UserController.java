package com.lhbasura.hello.dubbo.service.user.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lhbasura.hello.dubbo.service.user.api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Reference(version = "${user.service.version}")
    private UserService userService;

    @HystrixCommand(fallbackMethod = "sayHellofailed")
    @GetMapping("hi")
    public String sayHello()
    {
        return userService.sayHi();
    }

    public String sayHellofailed()
    {
        return  "say hi failed";
    }
}
