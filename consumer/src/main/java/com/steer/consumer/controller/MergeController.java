package com.steer.consumer.controller;

import com.steer.extservice.service.MergeService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO 分组指定方法进行合并
 */
@RestController()
@RequestMapping("/merge")
public class MergeController {
    @DubboReference(version = "1.0.0",merger = "true",group = "merge1,merge2")
    private MergeService service;

    @GetMapping("")
    public List<String> merge(){
        return service.merge();
    }
}
