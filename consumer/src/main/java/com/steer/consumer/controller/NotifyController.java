package com.steer.consumer.controller;

import com.steer.extservice.service.NotifyService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/notify")
public class NotifyController {

    @DubboReference(interfaceClass = NotifyService.class,
            methods = {@Method(name = "notify",async = true,onreturn = "NotifyImpl.onreturnWithoutParam",
                    onthrow = "NotifyImpl.onthrow"),
                    @Method(name = "notifyWithError",async = true,onreturn = "NotifyImpl.onreturnWithoutParam",
                            onthrow = "NotifyImpl.onthrow")
            })
    private NotifyService service;

    @GetMapping("")
    public String notify2222(){
        service.notify("hehe");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "执行成功!";
    }

    @GetMapping("/error")
    public String notify3333(){
        service.notifyWithError("hehe");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "执行成功!";
    }
}
