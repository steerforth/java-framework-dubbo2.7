package com.steer.extservice.service;

import com.steer.extservice.dto.valid.StuDto;
import com.steer.extservice.dto.valid.UserDto;

import javax.validation.constraints.Min;

public interface ValidationService {
    String save(UserDto dto);
    String update(StuDto dto);
    @interface Update2{}
    String update2(StuDto dto);

    String delete(@Min(20) int aa);
}
