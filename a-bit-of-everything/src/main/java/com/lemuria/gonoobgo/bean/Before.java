package com.lemuria.gonoobgo.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@Slf4j

public class Before {
    public Before(){
        log.info("Before is 构造");
    }
}
