package com.steer.producer.service.impl;

import com.steer.extservice.service.NotifyService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@DubboService(interfaceClass = NotifyService.class)
public class NotifyServiceImpl implements NotifyService {
    Logger log = LoggerFactory.getLogger(NotifyServiceImpl.class);
    @Override
    public String notify(String name) {
        log.info("收到:"+name);
        return "notifyServiceImpl:"+name;
    }

    @Override
    public String notifyWithError(String name) {
        throw new RpcException("出错鸟!");
    }
}
