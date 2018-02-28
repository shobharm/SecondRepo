package com.example.TestApp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.TestApp.model.TestModel;
import com.example.TestApp.repository.TestRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses=TestRepository.class)
public class MongoConfig {

	
	@Bean
	CommandLineRunner commandLineRunner(TestRepository testRepository) {
		return Strings ->{
			testRepository.save(new TestModel(1,"Aaradya",2,100));
			testRepository.save(new TestModel(2,"Gowthami",2,100));
			testRepository.save(new TestModel(3,"Mahesh",2,100));
			testRepository.save(new TestModel(4,"Suresh",2,100));
		};
		
	}
	
	
	
	
}
