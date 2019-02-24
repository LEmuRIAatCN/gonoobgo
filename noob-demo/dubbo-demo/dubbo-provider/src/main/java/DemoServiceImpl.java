import com.lemuria.gonoobgo.dubbo.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String hello) {
        return hello+"来自dubbo-provider";
    }
}
