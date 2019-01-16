package com.lemuria.gonoobgo.annotation;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
public class ResourceAnnotation {
	private String s = "123";
	@PostConstruct
	public void getDes() {
		System.out.println(s);
	}
}
