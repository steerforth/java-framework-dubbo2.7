package com.steer.producer.service.impl;

import com.steer.extservice.service.AnimalService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@DubboService(interfaceClass = AnimalService.class,group = "an.dog",version = "1.0.0")
@Service
public class DogServiceImpl implements AnimalService {
    @Override
    public String group() {
        return "我是dog";
    }
}
