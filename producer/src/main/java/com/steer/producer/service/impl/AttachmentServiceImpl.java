package com.steer.producer.service.impl;

import com.steer.extservice.service.AttachmentService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Service;

@Service
@DubboService(version = "1.0.0",interfaceClass = AttachmentService.class)
public class AttachmentServiceImpl implements AttachmentService {
    @Override
    public String attach(String param) {
        //path, group, version, dubbo, token, timeout 几个 key 是保留字段，请使用其它值
        String aa = RpcContext.getContext().getAttachment("aa");
        System.out.println("获取到显示参数:"+param+",获取到隐式参数:"+aa);
        return "ok";
    }
}
