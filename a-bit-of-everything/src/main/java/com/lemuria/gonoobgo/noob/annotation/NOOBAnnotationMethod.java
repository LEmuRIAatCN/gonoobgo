package com.lemuria.gonoobgo.noob.annotation;

import lombok.Data;

import java.lang.reflect.Method;
@Data
public class NOOBAnnotationMethod {
    private final String noobValue;
    private final Method method;
    private final String beanName;
    public NOOBAnnotationMethod(String noobValue, Method method, String beanName){
        this.beanName = beanName;
        this.method = method;
        this.noobValue = noobValue;
    }

}
