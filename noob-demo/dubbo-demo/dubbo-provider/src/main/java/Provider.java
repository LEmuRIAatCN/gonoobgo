import org.apache.dubbo.container.spring.SpringContainer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
    public static void main(String[] args) throws Exception{
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-demo-provider.xml"});
        //context.start();
        SpringContainer sc = new SpringContainer();
        sc.start();
        System.in.read();
    }

}
