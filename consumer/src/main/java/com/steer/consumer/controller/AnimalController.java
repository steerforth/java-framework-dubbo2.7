package com.steer.consumer.controller;

import com.steer.extservice.service.AnimalService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FIXME 这种注解配置有时候会失效
 */
@RestController()
@RequestMapping("/group")
public class AnimalController {
    @DubboReference(group = "an.dog",version = "1.0.0",interfaceClass = AnimalService.class)
    private AnimalService dogService;

    @DubboReference(group = "an.cat",version = "1.0.0",interfaceClass = AnimalService.class)
    private AnimalService catService;

    @GetMapping("/cat")
    public String cat(){
        return catService.group();
    }

    @GetMapping("/dog")
    public String dog(){
        return dogService.group();
    }
}
