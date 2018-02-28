package com.example.TestApp;


import java.util.Map;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

//	@Value("${application.message}")
//	private String helloMessage;
//	
//	@GetMapping("/")
//	public String welcome(Map model) {
//		
//		model.put("message", helloMessage);
//		
//		return "welcome";
//	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String index(@RequestParam String uname,@RequestParam String pwd,Map<String,String> model) {
		System.out.println("inside controller");
		
		System.out.println("username"+uname+"Password"+pwd);
		model.put("name", uname);
		model.put("pwd", pwd);
		return "welcome";
	}
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String sayhello() {
		return "index";
	}
}