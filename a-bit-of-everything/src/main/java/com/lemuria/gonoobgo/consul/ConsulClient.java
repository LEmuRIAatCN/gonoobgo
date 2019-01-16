package com.lemuria.gonoobgo.consul;

import com.orbitz.consul.Consul;
import com.orbitz.consul.config.ClientConfig;

public class ConsulClient {
	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
		Consul consul = Consul.builder().withClientConfiguration(config).build();
	}
}
