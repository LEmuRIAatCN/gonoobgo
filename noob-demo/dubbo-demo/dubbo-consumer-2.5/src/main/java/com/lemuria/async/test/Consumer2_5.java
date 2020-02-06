package com.lemuria.async.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ImportResource(locations={"classpath:dubbo.xml"})
@EnableScheduling
public class Consumer2_5 {
    public static void main(String[] args) {

        SpringApplication.run(Consumer2_5.class, args);

    }
}

