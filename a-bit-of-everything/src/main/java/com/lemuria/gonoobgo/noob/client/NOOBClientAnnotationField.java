package com.lemuria.gonoobgo.noob.client;

import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Data
public class NOOBClientAnnotationField {
    private final String noobName;
    private final Field field;
    private final String beanName;
    public NOOBClientAnnotationField(String noobName, Field field, String beanName){
        this.noobName = noobName;
        this.field = field;
        this.beanName = beanName;
    }
}
