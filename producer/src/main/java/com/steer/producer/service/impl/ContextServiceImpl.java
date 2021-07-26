package com.steer.producer.service.impl;

import com.steer.extservice.service.ContextService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Service;

@DubboService(version = "1.0.0",interfaceClass = ContextService.class)
@Service
public class ContextServiceImpl implements ContextService {
    @Override
    public String context() {
        boolean providerSide = RpcContext.getContext().isProviderSide();
        String remoteHost = RpcContext.getContext().getRemoteHost();
        System.out.println("远程地址:"+remoteHost+",否为服务提供方:"+providerSide);
        //这里再调用其他rpc服务，context容器内容也会变化
        return "ok";
    }
}
