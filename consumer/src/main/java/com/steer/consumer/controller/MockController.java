package com.steer.consumer.controller;

import com.steer.extservice.service.MockService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock")
public class MockController {
    @DubboReference(interfaceClass = MockService.class,mock = "com.steer.consumer.mock.MockServiceMockImpl",
    methods = {@Method(name="sayHi",retries = 0)})
    private MockService service;

    /**
     * 简单的处理
     * 也可以抛出指定异常throw com.xxx.XXXException
     */
    @DubboReference(interfaceClass = MockService.class,mock = "return null")
    private MockService service2;

    /**
     * force:强制使用mock行为，不会走远程调用
     */
    @DubboReference(interfaceClass = MockService.class,mock = "force:return fake")
    private MockService service3;

//    /**
//     * 方法级别上指定mock行为
//     */
//    @DubboReference(interfaceClass = MockService.class,parameters = {"sayHi.mock","force:return fake"})
//    private MockService service4;

    @GetMapping("")
    public String mock(){
       return service.sayHi("liming");
    }

    @GetMapping("test2")
    public String mock2(){
        return service2.sayHi("liming");
    }

    @GetMapping("test3")
    public String mock3(){
        return service3.sayHi("liming");
    }

//    @GetMapping("test4")
//    public String mock4(){
//        return service4.sayHi("liming");
//    }
}
