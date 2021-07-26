package com.steer.consumer.controller;

import com.steer.extservice.service.ContextService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/context")
public class ContextController {
    @DubboReference(version = "1.0.0")
    private ContextService service;

    @GetMapping("")
    public String echo(){
        String res = service.context();
        boolean consumerSide = RpcContext.getContext().isConsumerSide();
        String remoteHost = RpcContext.getContext().getRemoteHost();
        String absolutePath = RpcContext.getContext().getUrl().getAbsolutePath();
        System.out.println("是否为消费方:"+consumerSide+",调用服务地址:"+remoteHost+",全路径:"+absolutePath);
        return res;
    }
}
