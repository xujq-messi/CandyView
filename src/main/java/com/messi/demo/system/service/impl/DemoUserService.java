package com.messi.demo.system.service.impl;

import com.messi.demo.system.entity.User;
import com.messi.demo.system.service.IUserService;
import org.springframework.stereotype.Component;

@Component
public class DemoUserService implements IUserService {
    @Override
    public User getUser(String name) {

        User user = new User();
        user.setName("messi");
        user.setPassword("messi@123");
        return user;
    }
}
