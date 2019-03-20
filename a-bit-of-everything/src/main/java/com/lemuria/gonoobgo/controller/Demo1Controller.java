package com.lemuria.gonoobgo.controller;

import com.lemuria.gonoobgo.dao.KnowledgeBaseDAO;
import com.lemuria.gonoobgo.po.KnowledgeBasePO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Multipart;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/demo1")
@Slf4j
public class Demo1Controller {
    @RequestMapping(value = "/hello1")
   // @ResponseBody
    public String demo1Hello1(){
        return "index.html";
    }
    @Autowired
    private KnowledgeBaseDAO knowledgeBaseDAO;
    @PostMapping(value = "/put1", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public Map putKnowledge(){
        //log.info(body.toString());
        //KnowledgeBasePO po = new KnowledgeBasePO();
        //po.setAuthor("daf");
        //po.setContent("hahahah");
        //po.setTitle("vsvsv");
        //po.setOutline("vsvsvs");
       // po.setTags(new String[]{"1","2"});
        //knowledgeBaseDAO.save(po);
        Map<String, String> m = new HashMap<String, String>();
        m.put("code", "1");
        m.put("msg","hahah");
        return m;

    }
}
