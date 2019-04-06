package com.lemuria.gonoobgo.noob.client;

import com.lemuria.gonoobgo.noob.annotation.NOOBAnnotationMethod;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Component
@Data
@Slf4j
@DependsOn({"noobClientDemo","noobResolver"})

public class NOOBClientResolver implements ApplicationContextAware {
    private List<NOOBClientAnnotationField> clients = new LinkedList<>();
    private static ConfigurableApplicationContext applicationContext;

    public void resolve(){
        String[] beans = applicationContext.getBeanDefinitionNames();
        for(String bean:beans){
            log.info("bean:"+bean);
            Field[] fields = applicationContext.getBeanFactory().getBean(bean).getClass().getDeclaredFields();
            for(Field f:fields){
                if(null!=f.getAnnotation(NOOBClient.class)){
                    log.info("GOT A MATCH");
                    NOOBClient noobClient = f.getAnnotation(NOOBClient.class);
                    NOOBClientAnnotationField noobClientAnnotationField =
                            new NOOBClientAnnotationField(noobClient.noobName(), f, bean);
                    clients.add(noobClientAnnotationField);
                    NOOBClientBean noobClientBean = new NOOBClientBean(noobClient.noobName());
                    noobClientBean.$invoke(noobClient.noobName(),new String[] {"java.lang.String", "java.util.Map"}, new Object[] {"world", new HashMap<>()});
                }
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }
}
