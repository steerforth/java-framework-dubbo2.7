package com.steer.producer.service.impl;

import com.steer.extservice.service.ConcurrentService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * executes:
 * 可以指定类的每个方法并发执行（或占用线程池线程数）不能超过 10 个
 * 也可以指定某个方法
 * loadbalance:
 * 默认random,
 * leastactive会调用并发数最小的
 */
@DubboService(interfaceClass = ConcurrentService.class,executes = 10,loadbalance = "leastactive")
public class ConcurrentServiceImpl implements ConcurrentService {
    @Override
    public String say(String name) {
        return "name:"+name;
    }
}
