package com.steer.producer.service.impl;

import com.steer.extservice.service.CacheService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@DubboService(version = "1.0.0",interfaceClass = CacheService.class,timeout = 5000)
@Service
public class CacheServiceImpl implements CacheService {
    @Override
    public String cache() {
        //用于验证后续访问是不是从缓存中取出
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "我是缓存信息";
    }
}
