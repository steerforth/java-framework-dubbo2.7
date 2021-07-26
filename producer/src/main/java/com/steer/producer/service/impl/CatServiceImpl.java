package com.steer.producer.service.impl;

import com.steer.extservice.service.AnimalService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@DubboService(interfaceClass = AnimalService.class,group = "an.cat",version = "1.0.0")
@Service
public class CatServiceImpl implements AnimalService {
    @Override
    public String group() {
        return "我是cat";
    }
}
