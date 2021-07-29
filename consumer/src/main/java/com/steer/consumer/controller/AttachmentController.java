package com.steer.consumer.controller;

import com.steer.extservice.service.AttachmentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attach")
public class AttachmentController {

    @DubboReference(version = "1.0.0")
    private AttachmentService service;

    @GetMapping("")
    public String attach(String param){
        //path, group, version, dubbo, token, timeout 几个 key 是保留字段，请使用其它值
        RpcContext.getContext().setAttachment("aa", "i am implicit param");
        String res = service.attach(param);
        return res;
    }

}
