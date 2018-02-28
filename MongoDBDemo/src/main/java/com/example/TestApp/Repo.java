package com.example.TestApp;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;


public interface Repo<T extends TestClass,ID extends Serializable> extends MongoRepository<T, ID>{

}
