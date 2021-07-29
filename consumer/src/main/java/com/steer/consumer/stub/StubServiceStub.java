package com.steer.consumer.stub;

import com.steer.extservice.service.StubService;

public class StubServiceStub implements StubService {
    private StubService service;

    public StubServiceStub(StubService service) {
        this.service = service;
    }

    @Override
    public String stub() {
        System.out.println("consumer端 stub调用开始");
        String res = this.service.stub();
        System.out.println("consumer端 stub调用结束");
        return res;
    }
}
