package com.steer.extservice.service;

import java.util.concurrent.CompletableFuture;


public interface AsyncService {
    CompletableFuture<String> async(String aa);

    CompletableFuture<String> async2(String aa);
}
