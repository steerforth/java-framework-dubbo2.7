package com.steer.producer.service.impl;

import com.steer.extservice.service.StubService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService(version = "1.0.0",interfaceClass = StubService.class)
public class StubServiceImpl implements StubService {
    @Override
    public String stub() {
        return "ok";
    }
}
