package com.steer.extservice.dto.valid;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

//参数验证功能是基于 JSR303 实现的，用户只需标识 JSR303 标准的验证 annotation，并通过声明 filter 来实现验证
public class UserDto implements Serializable {
    @NotNull
    private String name;
}
