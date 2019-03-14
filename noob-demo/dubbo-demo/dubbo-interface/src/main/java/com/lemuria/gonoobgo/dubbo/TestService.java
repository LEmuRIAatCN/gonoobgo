package com.lemuria.gonoobgo.dubbo;

import java.util.List;
import java.util.Map;

public interface TestService {
    String tsTest1(String st);

    Map<String, Object> tsTest2(String s, Object o);

    List<String> tsTest3(String s);
}
