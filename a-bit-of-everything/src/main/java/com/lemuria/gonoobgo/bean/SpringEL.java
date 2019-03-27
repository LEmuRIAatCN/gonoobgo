package com.lemuria.gonoobgo.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * 为啥用main函数就可以执行。用boot的启动类就报错了呢？？？
 */
@Data
@Component
public class SpringEL {
    @Value("#{prop[a]}")
    //@Value("${'a'}")
    private String aaa ="";
    @Value("#{prop[b]}")
    private String bbb = "";

    @PostConstruct
    public void init(){
        System.out.println("aaa="+aaa);
        System.out.println("bbb="+bbb);
    }
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        context.start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
