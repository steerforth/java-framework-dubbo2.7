package com.steer.extservice.service;

/**
 * 消息通知
 */
public interface NotifyService {
    String notify(String name);

    String notifyWithError(String name);
}
