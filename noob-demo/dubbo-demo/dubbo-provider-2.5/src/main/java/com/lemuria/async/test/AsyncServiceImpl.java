package com.lemuria.async.test;


public class AsyncServiceImpl implements AsyncService {
    @Override
    public String test1() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test1 returned 0.2s sleep";
    }

    @Override
    public String test2() {
        return "test1 returned 4s sleep";
    }
}
