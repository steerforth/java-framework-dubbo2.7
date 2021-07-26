package com.steer.producer.service.impl;

import com.steer.extservice.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@DubboService(version = "1.0.0",interfaceClass = HelloService.class)
@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        System.out.println("do hello~~");
        return "你好:"+name;
    }
}
