package com.steer.producer.service.impl;

import com.steer.extservice.service.MergeService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@DubboService(interfaceClass = MergeService.class,group = "merge2",version = "1.0.0")
@Service
public class MergeGroup2ServiceImpl implements MergeService {
    @Override
    public List<String> merge() {
        return Arrays.asList("merge2-1","merge2-2","merge2-3");
    }
}
