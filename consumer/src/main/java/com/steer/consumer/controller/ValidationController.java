package com.steer.consumer.controller;

import com.steer.extservice.dto.valid.StuDto;
import com.steer.extservice.dto.valid.UserDto;
import com.steer.extservice.service.ValidationService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/validation")
@Validated//controller层参数校验,delete3方法校验
public class ValidationController {
    //消费端验证
    @DubboReference(version = "1.0.0",validation = "true")
    private ValidationService service;

    @DubboReference(version = "1.0.0")
    private ValidationService service2;

    @GetMapping("/save")
    public String save(){
        try {
            UserDto dto = new UserDto();
            return service.save(dto);
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @GetMapping("/update")
    public String update(){
        try {
            StuDto dto = new StuDto();
            return service.update(dto);
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @GetMapping("/update2")
    public String update2(){
        try {
            StuDto dto = new StuDto();
            return service2.update2(dto);
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @GetMapping("/delete")
    public String delete(){
        try {
            return service.delete(2);
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @GetMapping("/delete2")
    public String delete2(){
        try {
            return service2.delete(2);
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }


    @GetMapping("/delete3")
    public String delete3(@NotEmpty(message = "name不能为空")String name){
        try {
            return service2.delete(23);
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
