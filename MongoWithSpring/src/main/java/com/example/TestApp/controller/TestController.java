package com.example.TestApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.TestApp.repository.TestRepository;
import com.example.TestApp.model.TestModel;

@Controller
public class TestController {
	@Autowired
	private TestRepository testRepository;
	/*public TestController(TestRepository testRepository) {
		this.testRepository= testRepository;
	}
	*/
	@RequestMapping("/")
	public List<TestModel> getAllRecords(TestRepository testRepository) {
		
		
		return testRepository.findAll();
		
		
		
	}

}
