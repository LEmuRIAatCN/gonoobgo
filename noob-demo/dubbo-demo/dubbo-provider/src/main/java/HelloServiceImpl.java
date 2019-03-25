import com.lemuria.generic.GenericType;
import com.lemuria.generic.HelloService;
import com.lemuria.generic.Person;

import java.util.concurrent.CompletableFuture;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return name+"hahahah";
    }

    @Override
    public CompletableFuture<String> sayHelloAsync(String name) {
        return null;
    }

    @Override
    public CompletableFuture<Person> sayHelloAsyncComplex(String name) {
        return null;
    }

    @Override
    public CompletableFuture<GenericType<Person>> sayHelloAsyncGenericComplex(String name) {
        return null;
    }
}
