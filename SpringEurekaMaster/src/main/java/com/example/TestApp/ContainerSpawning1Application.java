package com.example.TestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.EnableMBeanExport;

@SpringBootApplication
@EnableEurekaServer
public class ContainerSpawning1Application {

	public static void main(String[] args) {
		SpringApplication.run(ContainerSpawning1Application.class, args);
	}
}
