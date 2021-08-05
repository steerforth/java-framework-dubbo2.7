package com.steer.consumer.controller;

import com.steer.extservice.service.AsyncService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController()
@RequestMapping("/async")
public class AsyncController {

    @DubboReference(interfaceClass = AsyncService.class)
    private AsyncService service;

    @GetMapping("/one")
    public String async() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = service.async("nihao");
        return future.get();
    }

    @GetMapping("/two")
    public String async2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = service.async2("liming");
        return future.get();
    }

}
