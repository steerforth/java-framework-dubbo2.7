package com.steer.producer.service.impl;

import com.steer.extservice.dto.valid.StuDto;
import com.steer.extservice.dto.valid.UserDto;
import com.steer.extservice.service.ValidationService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;

@Service
//服务端验证
@DubboService(version = "1.0.0",interfaceClass = ValidationService.class,validation = "true")
public class ValidationServiceImpl implements ValidationService {
    @Override
    public String save(UserDto dto) {
        return "ok";
    }

    @Override
    public String update(StuDto dto) {
        return "ok";
    }

    @Override
    public String update2(StuDto dto) {
        return "ok";
    }

    @Override
    public String delete(@Min(20) int aa) {
        return "ok";
    }
}
