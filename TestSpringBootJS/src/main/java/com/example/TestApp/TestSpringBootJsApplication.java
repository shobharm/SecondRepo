package com.example.TestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class TestSpringBootJsApplication extends SpringBootServletInitializer {
	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("place 3");
		return application.sources(TestSpringBootJsApplication.class);
		
	}*/
	public static void main(String[] args) {
		System.out.println("place 1");
	SpringApplication a= new SpringApplication(TestSpringBootJsApplication.class);
	System.out.println("place 2");
		a.run(args);
	}
}
