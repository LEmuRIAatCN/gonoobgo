package com.lemuria.gonoobgo;

import com.lemuria.gonoobgo.dao.TVShowsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations={"classpath:dubbo.xml"})

public class GonoobgoApplication {
	public static void main(String[] args) {

		SpringApplication.run(GonoobgoApplication.class, args);

	}
}

