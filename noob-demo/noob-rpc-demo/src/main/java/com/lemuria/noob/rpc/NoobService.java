package com.lemuria.noob.rpc;

import com.lemuria.gonoobgo.noob.annotation.NOOB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
@Slf4j
public class NoobService {
    @NOOB("noob1")
    public ModelMap test1(String s, Map<String, String> map){
        log.info("s is :"+s);
        log.info("map is "+map.toString());
        ModelMap mm = new ModelMap();
        mm.put("hahaha", s);
        mm.put("heiheihei", map);
        return mm;
    }
    @NOOB("noob2")
    public ModelMap test2(Map<String, String> map){
        log.info("map is "+map.toString());
        ModelMap mm = new ModelMap();
        mm.put("heiheihei", map);
        mm.put("msg", "success");
        mm.put("code", "000000");
        return mm;
    }
    @PostConstruct
    public void init(){
        log.info("asdfasdfasdf");
    }
}
