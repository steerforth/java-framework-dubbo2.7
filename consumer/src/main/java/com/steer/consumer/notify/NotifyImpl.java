package com.steer.consumer.notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * value要匹配DubboReference里面的NotifyImpl.onreturn 名称
 */
@Component(value = "NotifyImpl")
public class NotifyImpl implements Notify {
    Logger log = LoggerFactory.getLogger(NotifyImpl.class);

    @Override
    public void onreturn(String result, String name) {
        log.info("onreturn:----------"+result+"~~~~~~~~~~~"+name);
    }

    @Override
    public void onthrow(Throwable t) {
        log.info("onthrow:----------"+t.getMessage());
    }

    @Override
    public void oninvoke(String name) {
        log.info("oninvoke:----------"+name);
    }

    @Override
    public void onreturnWithoutParam(String result) {
        log.info("onreturnWithoutParam:----------"+result);
    }
}
