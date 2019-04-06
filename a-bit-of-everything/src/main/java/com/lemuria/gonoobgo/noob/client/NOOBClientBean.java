package com.lemuria.gonoobgo.noob.client;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.util.StringUtils;

import java.util.HashMap;

@Data
@Slf4j
public class NOOBClientBean implements GenericService{
    private ApplicationConfig applicationConfig;
    private RegistryConfig registryConfig;
    private ReferenceConfig<GenericService> reference;
    public NOOBClientBean(String noobName){
        applicationConfig = new ApplicationConfig();
        applicationConfig.setName("NOOBConsumer");
        registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("localhost:2181");
        reference = new ReferenceConfig<>();
        reference.setInterface(noobName);
        reference.setGeneric(true);
        reference.setRegistry(registryConfig);
        //reference.setApplication(applicationConfig);
    }

    @Override
    public Object $invoke(String noobName, String[] parameterTypes, Object[] args) throws GenericException {

        GenericService genericService = reference.get();
        Object result =  genericService.$invoke(noobName, parameterTypes, args);
        System.out.println(StringUtils.quoteIfString(result));
        return result;
    }


}
