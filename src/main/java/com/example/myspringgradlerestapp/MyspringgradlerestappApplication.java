package com.example.myspringgradlerestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

// mvn spring-boot:run  -Dspring-boot.run.arguments=--server.port=8085
@RestController
@SpringBootApplication
public class MyspringgradlerestappApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyspringgradlerestappApplication.class, args);
	}

	@RequestMapping("/")
    public String visitHome() {
        return "42";
    }
}

