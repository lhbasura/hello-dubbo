package com.lhbasura.hello.dubbo.service.user.provider.api.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.lhbasura.hello.dubbo.service.user.api.UserService;

@Service(version = "${user.service.version}")
public class UserServiceImp implements UserService {
    @Override
    public String sayHi() {
        return "hello dubbo";
    }
}
