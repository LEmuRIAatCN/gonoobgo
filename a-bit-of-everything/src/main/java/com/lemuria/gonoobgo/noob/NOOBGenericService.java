package com.lemuria.gonoobgo.noob;

import com.lemuria.gonoobgo.noob.annotation.NOOBAnnotationMethod;
import com.lemuria.gonoobgo.noob.annotation.NOOBResolver;
import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

public class NOOBGenericService implements GenericService, ApplicationContextAware {
    @Autowired
    private NOOBResolver noobResolver;
    private ConfigurableApplicationContext configurableApplicationContext;

    @Override
    public Object $invoke(String noobName, String[] parameterTypes, Object[] args) throws GenericException {
        List<NOOBAnnotationMethod> list = noobResolver.getNoobMethods();
        System.out.println("hahahahhaha");
        System.out.println(noobResolver);
        Iterator<NOOBAnnotationMethod> it = list.iterator();
        while(it.hasNext()){
            NOOBAnnotationMethod noobAnnotationMethod = it.next();
            if(noobAnnotationMethod.getNoobValue().equals(noobName)){
                try {
                    noobAnnotationMethod.getMethod()
                            .invoke(
                                    configurableApplicationContext.getBeanFactory().getBean(noobAnnotationMethod.getBeanName()),
                                    args);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return "hahaha";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
    }
}
