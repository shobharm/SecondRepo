package com.example.TestApp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.TestApp.Model.UserModel;
import com.example.TestApp.Service.UserService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value="/api/")
public class RestController {
	UserService userService;
	@RequestMapping(value="/user/", method=RequestMethod.GET)
	public ResponseEntity<List<UserModel>> fetchUsers(){
		List<UserModel> um=userService.fetchUserList();
		if(um.isEmpty()) {
			
		}
		return new ResponseEntity<List<UserModel>>(um,HttpStatus.OK);
	}
}
