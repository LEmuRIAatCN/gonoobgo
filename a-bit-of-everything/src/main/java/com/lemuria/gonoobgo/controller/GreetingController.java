package com.lemuria.gonoobgo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.dubbo.common.threadpool.ThreadPool;
import com.lemuria.gonoobgo.dao.TVShowsDAO;
import com.lemuria.gonoobgo.dubbo.TestService;
import com.lemuria.gonoobgo.po.TVShowsPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lemuria.gonoobgo.pojo.Greeting;
@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private ExecutorService service3 = Executors.newFixedThreadPool(10);
    @Autowired
    private TVShowsDAO dao;
    @Autowired
    private TestService testServiceC;
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name, HttpServletResponse response) {
    	String s = response.getContentType();
    	response.setContentType("test");
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    @RequestMapping("/hello1")
    public ModelMap sayHello1() {
    	ModelMap map = new ModelMap();
       // RunnableTest test1 = new RunnableTest("1");
        //RunnableTest test2 = new RunnableTest("2");
       // RunnableTest test3 = new RunnableTest("3");
       // RunnableTest test4 = new RunnableTest("4");
        CallableTest test1 = new CallableTest("1");
        CallableTest test2 = new CallableTest("2");
        CallableTest test3 = new CallableTest("3");
        CallableTest test4 = new CallableTest("4");
        List<CallableTest> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
    	//service3.submit(test1);
    	//service3.submit(test2);
    	//service3.submit(test3);
    	//service3.submit(test4);
        try {
            service3.invokeAll(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        map.put("code", 1);
    	return map;
    }

    @RequestMapping("/hello2")
    @ResponseBody
    public ModelMap sayHello2() {
        ModelMap map = new ModelMap();
        TVShowsPO po = new TVShowsPO();
        po.setLength(1);
        po.setName("wwww");
        dao.insert(po);
        map.put("code", 1);
        return map;
    }

    @RequestMapping("/hello3")
    @ResponseBody
    public ModelMap sayHello3() {
        System.out.println(testServiceC.tsTest2("asdf", "kdkdk"));
        Map map = new ModelMap();
        map.put("adf","sdfasdf");
        return (ModelMap)map;
    }

    class RunnableTest implements Runnable{
        String name = "";
        public RunnableTest(String name){
            this.name=name;
        }
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        }
    }
    class CallableTest implements Callable<String> {
        String name = "";
        public CallableTest(String name){
            this.name=name;
        }
        @Override
        public String call() throws Exception {
            while(true){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        }
    }
}
	