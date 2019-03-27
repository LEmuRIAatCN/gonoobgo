package com.lemuria.generic;

import java.util.concurrent.CompletableFuture;

public interface HelloService {

    String sayHello(String name);

    CompletableFuture<String> sayHelloAsync(String name);

    CompletableFuture<Person> sayHelloAsyncComplex(String name);

    CompletableFuture<GenericType<Person>> sayHelloAsyncGenericComplex(String name);
}
