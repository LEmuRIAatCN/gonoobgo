package com.lemuria.gonoobgo.controller;

import com.lemuria.async.test.AsyncService;
import com.lemuria.gonoobgo.po.TVShowsPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class AsyncController {
    @Autowired
    private AsyncService async;
    @RequestMapping("/async")
    @ResponseBody
    public String async() {
        async.test1();
        return async.test1();
    }
}
