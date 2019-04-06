package com.lemuria.gonoobgo.noob.service;

import com.lemuria.gonoobgo.noob.annotation.NOOB;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.util.Map;

@Data
@Component
@Slf4j
public class NOOBService1 {
    @NOOB(value = "hahaha", group = "a", timeout = 1000)
    public ModelMap test1(String s, Map<String, Object> map){
        log.info("s:"+s);
        log.info(" 这里是hahaha注解的test1方法");
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(map);
        return modelMap;
    }
    @NOOB(value = "heihei", group = "b", timeout = 2000)
    public ModelMap test2(String s, Map<String, Object> map){
        log.info("s:"+s);
        ModelMap modelMap = new ModelMap();
        modelMap.addAllAttributes(map);
        return modelMap;
    }
}
