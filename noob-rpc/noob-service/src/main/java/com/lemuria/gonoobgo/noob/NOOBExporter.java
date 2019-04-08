package com.lemuria.gonoobgo.noob;

import com.lemuria.gonoobgo.noob.annotation.NOOBAnnotationMethod;
import com.lemuria.gonoobgo.noob.annotation.NOOBResolver;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class NOOBExporter implements ApplicationContextAware {
    private static ConfigurableApplicationContext applicationContext;
    @Autowired
    private NOOBResolver noobResolver;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }

    @PostConstruct
    public void init() {
        // 用org.apache.dubbo.rpc.service.GenericService可以替代所有接口实现
        GenericService xxxService = (GenericService) applicationContext.getBeanFactory().getBean("noob");
        List<NOOBAnnotationMethod> noobs = noobResolver.getNoobMethods();
        for (NOOBAnnotationMethod m : noobs) {
            // 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存
            ServiceConfig<GenericService> service1 = new ServiceConfig<GenericService>();

            // 弱类型接口名
            service1.setInterface(m.getNoobValue());
            // 指向一个通用服务实现
            service1.setRef(xxxService);

            // 暴露及注册服务
            service1.export();
        }


    }
}
