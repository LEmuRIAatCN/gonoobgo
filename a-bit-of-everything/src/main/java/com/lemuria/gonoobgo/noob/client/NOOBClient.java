package com.lemuria.gonoobgo.noob.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NOOBClient {
    /**
     * NOOB服务名称
     */
    String noobName();

    /**
     * 协议类型，默认dubbo
     */
    String protocol() default "dubbo";
}
