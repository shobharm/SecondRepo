package com.example.TestApp.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.TestApp.Model.UserModel;

public class UserServiceImpl implements UserService{

	public List<UserModel> fetchUserList(){
		List<UserModel> al=new ArrayList<UserModel>();
		UserModel um=new UserModel();
		um.setName("abc");
		um.setUserId("1");
		um.setDesignation("Test");
		al.add(um);
		return al;
		
	}
	
}
