package com.steer.consumer.mock;

import com.steer.extservice.service.MockService;

/**
 * consumer本地mock实现
 * 当provider服务不可用时
 */
public class MockServiceMockImpl implements MockService {
    @Override
    public String sayHi(String name) {
        return "我是容错的mock数据";
    }
}
