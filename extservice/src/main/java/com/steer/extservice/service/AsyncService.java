package com.steer.extservice.service;

import java.util.concurrent.CompletableFuture;


public interface AsyncService {
    CompletableFuture<String> asyncFromProducer(String aa);

    CompletableFuture<String> asyncFromProducer2(String aa);

    CompletableFuture<String> asyncFromCustomer(String aa);
}
