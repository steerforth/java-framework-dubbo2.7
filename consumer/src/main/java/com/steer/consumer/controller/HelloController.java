package com.steer.consumer.controller;

import com.steer.extservice.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/hello")
public class HelloController {


    /**
     * 直连，没有注册中心
     */
    @DubboReference(url = "dubbo://127.0.0.1:20880",version = "1.0.0",interfaceClass = HelloService.class,check = false)
    private HelloService service;

    @GetMapping("")
    public String hello(String name){
        return service.hello(name);
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}

