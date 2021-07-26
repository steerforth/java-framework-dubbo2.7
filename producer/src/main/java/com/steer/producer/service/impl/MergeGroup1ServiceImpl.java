package com.steer.producer.service.impl;

import com.steer.extservice.service.MergeService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@DubboService(interfaceClass = MergeService.class,group = "merge1",version = "1.0.0")
@Service
public class MergeGroup1ServiceImpl implements MergeService {
    @Override
    public List<String> merge() {
        return Arrays.asList("merge1-1","merge1-2","merge1-3");
    }
}
