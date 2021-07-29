package com.steer.consumer.controller;

import com.steer.consumer.stub.StubServiceStub;
import com.steer.extservice.service.StubService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stub")
public class StubController {

    @DubboReference(version = "1.0.0",stub = "com.steer.consumer.stub.StubServiceStub",interfaceClass = StubService.class)
    private StubServiceStub stubServiceStub;

    @GetMapping("")
    public String stub(){
        return stubServiceStub.stub();
    }
}
