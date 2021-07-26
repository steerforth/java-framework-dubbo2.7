package com.steer.consumer.controller;

import com.steer.extservice.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.service.EchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 回声测试
 * 用于测试服务是否可用
 * 可用直接打印echo里的内容
 * 好像不会走一遍实现方法
 */
@RestController()
@RequestMapping("/echo")
public class EchoController {
    @DubboReference(version = "1.0.0")
    private HelloService service;

    @GetMapping("")
    public Object echo(){
        return ((EchoService)service).$echo("Ok");
    }
}
