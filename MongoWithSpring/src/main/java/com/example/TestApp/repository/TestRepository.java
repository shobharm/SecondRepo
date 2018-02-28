package com.example.TestApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.TestApp.model.TestModel;

public interface TestRepository extends MongoRepository<TestModel, Integer>{

}
