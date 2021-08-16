package com.steer.consumer.controller;

import com.steer.extservice.service.DelayService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delay")
public class DelayController {

    /**
     * spring 2.X死锁问题
     * 强烈建议不要在服务的实现类中有 applicationContext.getBean() 的调用，全部采用 IoC 注入的方式使用 Spring的Bean。
     * 如果实在要调 getBean()，可以将 Dubbo 的配置放在 Spring 的最后加载。
     * 如果不想依赖配置顺序，可以使用 <dubbo:provider delay=”-1” />，使 Dubbo 在 Spring 容器初始化完后，再暴露服务。
     * 如果大量使用 getBean()，相当于已经把 Spring 退化为工厂模式在用，可以将 Dubbo 的服务隔离单独的 Spring 容器
     */
    @DubboReference(interfaceClass = DelayService.class)
    private DelayService delayService;

    @RequestMapping("")
    public String delay(){
        return delayService.delay("lihua");
    }
}
