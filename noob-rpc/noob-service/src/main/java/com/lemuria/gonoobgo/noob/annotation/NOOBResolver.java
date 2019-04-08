package com.lemuria.gonoobgo.noob.annotation;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

@Component("noobResolver")
@Data
public class NOOBResolver implements ApplicationContextAware, InitializingBean {
    private final Logger logger = LoggerFactory.getLogger(NOOBResolver.class);
    private List<NOOBPropHolder> noobs = new LinkedList<>();
    private List<NOOBAnnotationMethod> noobMethods = new LinkedList<>();
    private static ConfigurableApplicationContext applicationContext;

    public List<NOOBPropHolder> resolve() {
        if (applicationContext != null) {
            String[] beanNames = applicationContext.getBeanDefinitionNames();
            BeanFactory beanFactory = applicationContext.getBeanFactory();
            for (String beanName : beanNames) {
                Object bean = beanFactory.getBean(beanName);
                Class beanClazz = beanFactory.getType(beanName);
                logger.info("NAME=" + beanName + ", OBJECT=" + bean);
                for (Method method : beanClazz.getDeclaredMethods()) {
                    NOOB noob = method.getAnnotation(NOOB.class);
                    if (null != noob) {
                        logger.info("Got a match");
                        Properties properties = new Properties();
                        properties.setProperty("timeout", String.valueOf(noob.timeout()));
                        properties.setProperty("group", noob.group());
                        noobs.add(new NOOBPropHolder(noob.value(), properties));
                        noobMethods.add(new NOOBAnnotationMethod(noob.value(), method, beanName));
                    }
                }
            }
        }
        logger.info("NOOB are as follows:");
        Iterator<NOOBPropHolder> i1 = noobs.iterator();
        while(i1.hasNext()){
            logger.info(i1.next().toString());
        }
        logger.info("NOOBMethod are as follows:");
        Iterator<NOOBAnnotationMethod> i2 = noobMethods.iterator();
        while(i2.hasNext()){
            logger.info(i2.next().toString());
        }
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        resolve();
    }
}
