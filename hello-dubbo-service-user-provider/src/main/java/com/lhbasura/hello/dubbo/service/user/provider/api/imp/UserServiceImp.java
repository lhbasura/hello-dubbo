package com.lhbasura.hello.dubbo.service.user.provider.api.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.lhbasura.hello.dubbo.service.user.api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${user.service.version}")
public class UserServiceImp implements UserService {
    @Value("${dubbo.protocol.port}")
    private  int port;

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })    @Override
    public String sayHi() {
     //   throw new RuntimeException("Exception for hystrix");
        return "hello dubbo,from port:"+port;
    }
}
