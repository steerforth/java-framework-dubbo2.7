package com.steer.extservice.dto.valid;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

//参数验证功能是基于 JSR303 实现的，用户只需标识 JSR303 标准的验证 annotation，并通过声明 filter 来实现验证
public class StuDto implements Serializable {
    @NotBlank
    private String name;
}
