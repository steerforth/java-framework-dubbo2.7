package com.steer.consumer.controller;

import com.steer.extservice.service.CacheService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/cache")
public class CacheController {
    @DubboReference(version = "1.0.0",cache = "lru")
    private CacheService service;

    @GetMapping("")
    public String cache(){
       return service.cache();
    }
}
