package com.steer.producer.service.impl;

import com.steer.extservice.service.MyGenericService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.service.GenericException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@DubboService(version = "1.0.0",interfaceClass = MyGenericService.class)
@Service
public class MyGenericServiceImpl implements MyGenericService {

    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        if ("say".equals(method)){
            Map<Object,Object> map = new HashMap<>();
            map.put(args[0],args[1]);
            return map;
        }
        return null;
    }
}
