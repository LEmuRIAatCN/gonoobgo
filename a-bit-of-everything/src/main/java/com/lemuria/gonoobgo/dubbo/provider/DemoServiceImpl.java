package com.lemuria.gonoobgo.dubbo.provider;

import com.lemuria.gonoobgo.dubbo.DemoService;
import com.lemuria.gonoobgo.noob.annotation.NOOBResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoServiceImpl implements DemoService {
	@Autowired
	private NOOBResolver noobResolver;

	@Override
	public String sayHello(String hello) {
		System.out.println("服务服务服务");
		System.out.println(noobResolver);
		return hello;
	}

}
