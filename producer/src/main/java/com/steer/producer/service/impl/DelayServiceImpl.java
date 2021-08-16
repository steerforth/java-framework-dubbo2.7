package com.steer.producer.service.impl;

import com.steer.extservice.service.DelayService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * dubbo2.6.5版本后，所有服务都将在 Spring 初始化完成后进行暴露
 */
@DubboService(interfaceClass = DelayService.class,delay = 5)
public class DelayServiceImpl implements DelayService {
    @Override
    public String delay(String name) {
        return "name:"+name;
    }
}
