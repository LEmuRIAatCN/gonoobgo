import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.util.StringUtils;

import java.util.HashMap;

public class NOOBConsumer {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("NOOBConsumer");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("localhost:2181");
        // 引用远程服务
// 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
// 弱类型接口名
        reference.setInterface("hahaha");
// 声明为泛化接口
        reference.setGeneric(true);
        reference.setRegistry(registryConfig);
        reference.setApplication(applicationConfig);
// 用org.apache.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();

// 基本类型以及Date,List,Map等不需要转换，直接调用
        Object result = genericService.$invoke("hahaha", new String[] {"java.lang.String", "java.util.Map"}, new Object[] {"world", new HashMap<>()});
        System.out.println(StringUtils.quoteIfString(result));
    }
}
