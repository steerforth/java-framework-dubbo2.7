package com.steer.producer.service.impl;

import com.steer.extservice.service.TimeoutService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@DubboService(interfaceClass = TimeoutService.class,version = "1.0.0",timeout = 3000)
@Service
public class TimeoutServiceImpl implements TimeoutService {
    @Override
    public void timeout() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException("处理超时:"+e.getMessage());
        }
    }
}
