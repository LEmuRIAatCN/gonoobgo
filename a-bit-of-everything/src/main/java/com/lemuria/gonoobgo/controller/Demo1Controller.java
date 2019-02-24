package com.lemuria.gonoobgo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/demo1")
public class Demo1Controller {
    @RequestMapping(value = "/hello1")
   // @ResponseBody
    public String demo1Hello1(){
        return "index.html";
    }
}
