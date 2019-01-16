package com.lemuria.gonoobgo.dubbo.provider;

import com.lemuria.gonoobgo.dubbo.DemoService;

public class DemoServiceImpl implements DemoService{

	@Override
	public String sayHello(String hello) {
		System.out.println("服务服务服务");
		return hello;
	}

}
