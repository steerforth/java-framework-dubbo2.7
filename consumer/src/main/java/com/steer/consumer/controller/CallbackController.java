package com.steer.consumer.controller;

import com.steer.extservice.service.CallbackListener;
import com.steer.extservice.service.CallbackService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController()
@RequestMapping("/callback")
public class CallbackController implements Serializable {
    Logger log = LoggerFactory.getLogger(CallbackController.class);

    @DubboReference(version = "1.0.0",interfaceClass = CallbackService.class)
    private CallbackService service;

    @GetMapping("/")
    public String callback(){
        service.addListener("aa.foo", new CallbackListener() {
            @Override
            public void changed(String msg) {
                log.info("收到信息:"+msg);
            }
        });
        return "执行成功!";
    }
}
