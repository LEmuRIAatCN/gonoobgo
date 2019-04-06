package com.lemuria.gonoobgo.noob.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface NOOB {
    /**
     * 服务协议类型，默认dubbo
     */
    String protocol() default "dubbo";

    /**
     * 服务名
     */
    String value() default "";

    String group() default "";

    int timeout() default 0;
}
