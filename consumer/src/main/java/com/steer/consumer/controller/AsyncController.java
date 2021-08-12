package com.steer.consumer.controller;

import com.steer.extservice.service.AsyncService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController()
@RequestMapping("/async")
public class AsyncController {
    Logger log = LoggerFactory.getLogger(AsyncController.class);

    @DubboReference(interfaceClass = AsyncService.class)
    private AsyncService service;

    @GetMapping("/one")
    public String asyncFromProducer() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = service.asyncFromProducer("nihao");
        return future.get();
    }

    @GetMapping("/two")
    public String asyncFromProducer2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = service.asyncFromProducer2("liming");
        return future.get();
    }

    @GetMapping("/three")
    public String async3() {
        CompletableFuture<String> future = service.asyncFromCustomer("liming");
        log.info("start");
        future.whenComplete((v,t) -> {
            if (t != null){
                t.printStackTrace();
            }else {
                log.info("res: "+v);
            }
        });
        log.info("end");
        return "即刻返回";
    }

    @GetMapping("/four")
    public String async4() throws ExecutionException, InterruptedException {
//        CompletableFuture<String> future = RpcContext.getContext().asyncCall(new Callable<CompletableFuture<String>>() {
//            @Override
//            public CompletableFuture<String> call() throws Exception {
//                return service.asyncFromCustomer("liming");
//            }
//        });
//        return future.get();
        return null;
    }
}
