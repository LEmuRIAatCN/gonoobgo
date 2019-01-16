package com.lemuria.gonoobgo.protobuf;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.lemuria.gonoobgo.protobuf.Something.SomeThing;
import com.lemuria.gonoobgo.protobuf.Something.SomeThing.Person;
import com.lemuria.gonoobgo.protobuf.Something.SomeThing.Person.PhoneType;

public class PB3Demo {
	private LocalVariableTableParameterNameDiscoverer de;

	public static void main(String[] args) {
		SomeThing.Builder sth = SomeThing.newBuilder();
		sth.setName("1");
		SomeThing.Person.Builder person = SomeThing.Person.newBuilder();
		person.setEmail("qwer@163.com");
		person.setId(1);
		person.setName("john");
		SomeThing.Person.PhoneNumber.Builder phone = SomeThing.Person.PhoneNumber.newBuilder();
		phone.setNumber("186123456");
		phone.setType(PhoneType.MOBILE);
		for (int i = 0; i < 10; i++) {
			person.addPhones(phone);
		}
		sth.addPeople(person.build());
		byte[] someThing = sth.build().toByteArray();
		ByteString someThingByteString = sth.build().toByteString();
		// 使用Any，内置类型
		System.out.println("创建了一个Any的builder：“any”，把上面的Something转为ByteString放进了“any”。");
		Any.Builder any = Any.newBuilder();
		any.setValue(someThingByteString);
		System.out.println("BtyeString。toString："+someThingByteString.toString());
		byte[] someThingAny = any.build().toByteArray();
		System.out.println("现在比较SomeThing序列化为 “byte数组”与“放进any后转为byte数组”的长度差异：");
		System.out.println("SomeThing直接序列化的长度："+someThing.length);
		System.out.println("同样一个SomeThing嵌套进Any的长度："+someThingAny.length);
		//使用pack方法
		//byte[] someThingAnyPack = Any.pack(sth.build()).toByteArray();
		//System.out.println(someThingAnyPack.length);
		System.out.println("现在使用Any。pack与Any。unpack方法。");
		Any anySomething = Any.pack(sth.build());
		Any anyPerson = Any.pack(person.build());
		try {
			System.out.println("Any中是什么类型，SomeThing:"+anySomething.is(SomeThing.class));
			System.out.println("上面的SomeThing的长度:"+anySomething.unpack(SomeThing.class).toByteArray().length);
			System.out.println("Any中是什么类型，Person:"+anyPerson.is(Person.class));
			System.out.println(anyPerson.unpack(Person.class).toByteArray().length);
			SomeThing afterParse = SomeThing.parseFrom(someThing);
			SomeThing afterParseAny = SomeThing.parseFrom(Any.pack(sth.build()).unpack(SomeThing.class).toByteArray());
			
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
