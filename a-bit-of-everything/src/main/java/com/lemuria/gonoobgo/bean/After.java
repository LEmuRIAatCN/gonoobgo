package com.lemuria.gonoobgo.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @DependsOn 注解的学习
 */
@Component("After")
@Slf4j
@DependsOn(value = "before")
public class After {
    public After(){
        log.info("After 构造");
    }
}
