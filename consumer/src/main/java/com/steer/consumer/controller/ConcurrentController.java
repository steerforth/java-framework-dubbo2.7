package com.steer.consumer.controller;

import com.steer.extservice.service.ConcurrentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/concurrent")
@RestController
public class ConcurrentController {

    /**
     * 消费端也可以进行并发配置
     */
    @DubboReference(interfaceClass = ConcurrentService.class,loadbalance="leastactive",actives = 10)
    private ConcurrentService service;

    @RequestMapping("")
    public String concurrent(){
        return service.say("lili");
    }

}
