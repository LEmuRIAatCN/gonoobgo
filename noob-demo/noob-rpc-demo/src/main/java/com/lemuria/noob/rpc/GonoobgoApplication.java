package com.lemuria.noob.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GonoobgoApplication {
	public static void main(String[] args) {

		SpringApplication.run(GonoobgoApplication.class, args);

	}
}

