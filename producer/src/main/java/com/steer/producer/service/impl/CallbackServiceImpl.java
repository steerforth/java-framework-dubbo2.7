package com.steer.producer.service.impl;

import com.steer.extservice.service.CallbackListener;
import com.steer.extservice.service.CallbackService;
import org.apache.dubbo.config.annotation.Argument;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@DubboService(version = "1.0.0",interfaceClass = CallbackService.class,
        timeout = 5000,connections = 1,callbacks = 1000,
        methods= {@Method(name = "addListener",arguments={@Argument(index=1,callback = true)})})
@Service
public class CallbackServiceImpl implements CallbackService {
    Logger log = LoggerFactory.getLogger(CallbackServiceImpl.class);
    private final Map<String,CallbackListener> listeners = new ConcurrentHashMap<>();

    public CallbackServiceImpl() {
        Thread t = new Thread(()->{
            while (true){
                try {
                    for(Map.Entry<String,CallbackListener> entry :listeners.entrySet()){
                        try {
                            entry.getValue().changed(formatkey(entry.getKey()));
                        }catch (Throwable t2){
                            log.error("-----"+t2.getMessage());
                            listeners.remove(entry.getKey());
                        }
                    }

                    Thread.sleep(5000);
                }catch (Throwable t1){
                    t1.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void addListener(String key, CallbackListener listener) {
        listeners.put(key,listener);
        listener.changed(this.formatkey(key));
    }

    private String formatkey(String key) {
        return "Changed "+key+" at "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
