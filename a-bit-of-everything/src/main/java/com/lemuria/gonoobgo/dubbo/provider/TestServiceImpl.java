package com.lemuria.gonoobgo.dubbo.provider;

import com.lemuria.gonoobgo.dubbo.TestService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestServiceImpl implements TestService {
    @Override
    public String tsTest1(String st) {
        return st;
    }

    @Override
    public Map<String, Object> tsTest2(String s, Object o) {
        Map<String, Object> map = new HashMap<>();
        map.put(s, o);
        return map;
    }

    @Override
    public List<String> tsTest3(String s) {
        List<String> l = new ArrayList<>();
        l.add(s);
        l.add(s);
        return l;
    }
}
