package com.steer.producer.service.impl;

import com.steer.extservice.service.AsyncService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.AsyncContext;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@DubboService(interfaceClass = AsyncService.class,timeout = 10000)
@Service
public class AsyncServiceImpl implements AsyncService {
    Logger log = LoggerFactory.getLogger(AsyncServiceImpl.class);

    /**
     * 通过 return CompletableFuture.supplyAsync() ，
     * 业务执行已从 Dubbo 线程切换到业务线程，避免了对 Dubbo 线程池的阻塞
     * @param aa
     * @return
     */
    @Override
    public CompletableFuture<String> async(String aa) {
        RpcContext context = RpcContext.getContext();
        log.info("1.-------begin");
        return CompletableFuture.supplyAsync(()->{
            log.info("2.----{}",context.getRemoteHost());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("3.----{}",context.getRemoteHost());
            return "response from async";
        });
    }

    @Override
    public CompletableFuture<String> async2(String aa) {
        final AsyncContext asyncContext = RpcContext.startAsync();
        new Thread(() -> {
            // 如果要使用上下文，则必须要放在第一句执行
            asyncContext.signalContextSwitch();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 写回响应
            asyncContext.write("Hello " + aa + ", response from provider.");
        }).start();
        return null;
    }
}
