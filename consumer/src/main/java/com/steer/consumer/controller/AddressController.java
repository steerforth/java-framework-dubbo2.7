package com.steer.consumer.controller;

import com.steer.extservice.service.AddressService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.cluster.router.address.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @DubboReference(version = "1.0.0",interfaceClass = AddressService.class,parameters = {"router","address"})
    private AddressService service;

    /**
     * 多注册中心，指定ip访问
     * @return
     */
    @GetMapping("")
    public String addr(){
        //一定要和zk配置中的具体ip配置一致
        Address address = new Address("172.20.10.4",20880);
        RpcContext.getContext().setObjectAttachment("address",address);
        return service.addr();
    }

}
