package com.lemuria.gonoobgo.noob.service;

import com.lemuria.gonoobgo.noob.annotation.NOOB;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@Slf4j
public class NOOBService2 {
    @NOOB(value = "aaa", group = "1a", timeout = 1000)
    public void test3(String s, Map<String, Object> map){

    }
    @NOOB(value = "bbb", group = "2b", timeout = 2000)
    public void test4(String s, Map<String, Object> map){

    }
}
