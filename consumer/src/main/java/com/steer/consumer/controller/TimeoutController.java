package com.steer.consumer.controller;

import com.steer.extservice.service.TimeoutService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/timeout")
public class TimeoutController {
    @DubboReference(version = "1.0.0")
    private TimeoutService service;

    @GetMapping("")
    public void timeout(){
        try {
            service.timeout();
        }catch (Exception e){
            throw new RuntimeException("超时:"+e.getMessage());
        }
    }

}
