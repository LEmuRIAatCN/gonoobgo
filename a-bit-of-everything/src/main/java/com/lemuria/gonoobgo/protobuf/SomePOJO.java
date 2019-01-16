package com.lemuria.gonoobgo.protobuf;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resources;

import lombok.Data;
@Data
public class SomePOJO {
	private String id;
	private String name;
	private List<Map<String,String>> list = Collections.emptyList();
	
}
