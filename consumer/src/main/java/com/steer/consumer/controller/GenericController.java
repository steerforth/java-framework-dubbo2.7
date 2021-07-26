package com.steer.consumer.controller;

import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/generic")
public class GenericController {
//    @DubboReference(version = "1.0.0",generic = true,interfaceClass = MyGenericService.class)
//    private MyGenericService service;

    @RequestMapping("")
    public Map<String,String> generic(String key,String value){
//        Object res = ((GenericService)service).$invoke("say", new String[]{"java.lang.String", "java.lang.String"}, new String[]{key, value});

        // 引用远程服务
        // 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        // 弱类型接口名
        reference.setInterface("com.steer.extservice.service.MyGenericService");
        reference.setVersion("1.0.0");
        // 声明为泛化接口
        reference.setGeneric("true");
        // 用org.apache.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();
        // 基本类型以及Date,List,Map等不需要转换，直接调用
        Object result = genericService.$invoke("say", new String[]{"java.lang.String", "java.lang.String"}, new String[]{key, value});

// 用Map表示POJO参数，如果返回值为POJO也将自动转成Map
//        Map<String, Object> person = new HashMap<String, Object>();
//        person.put("name", "xxx");
//        person.put("password", "yyy");
// 如果返回POJO将自动转成Map
//        Object result = genericService.$invoke("findPerson", new String[]
//                {"com.xxx.Person"}, new Object[]{person});

        return (Map<String, String>) result;
    }
}
