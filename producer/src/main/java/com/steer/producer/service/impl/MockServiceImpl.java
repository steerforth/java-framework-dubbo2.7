package com.steer.producer.service.impl;

import com.steer.extservice.service.MockService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService(interfaceClass = MockService.class)
public class MockServiceImpl implements MockService {
    @Override
    public String sayHi(String name) {
        return "我是真实数据";
    }
}
