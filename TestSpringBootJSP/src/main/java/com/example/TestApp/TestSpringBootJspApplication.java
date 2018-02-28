package com.example.TestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@org.springframework.stereotype.Controller
public class TestSpringBootJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringBootJspApplication.class, args);
	}
}
