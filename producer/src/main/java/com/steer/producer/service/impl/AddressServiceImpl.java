package com.steer.producer.service.impl;

import com.steer.extservice.service.AddressService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@DubboService(interfaceClass = AddressService.class,version = "1.0.0")
@Service
public class AddressServiceImpl implements AddressService {
    @Override
    public String addr() {
        return "我是address";
    }
}
