package com.lemuria.gonoobgo.noob.consumer;

import com.lemuria.gonoobgo.noob.client.NOOBClient;
import com.lemuria.gonoobgo.noob.client.NOOBClientResolver;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("noobClientDemo")
@Slf4j
@Data
@DependsOn("noobResolver")
public class NOOBClientDemo {
    @NOOBClient(noobName = "hahaha")
    private String hahaha;
    @Autowired
    private NOOBClientResolver noobClientResolver;
    @Scheduled(initialDelay = 30, fixedDelay = 10000000)
    public void test(){
        log.info("Client!!!!!!!");
        noobClientResolver.resolve();
    }
}
