package com.example.repo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Mod {
	
	@Id
private int ID;
private String name;
private String company;
private int exp;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public int getExp() {
	return exp;
}
public void setExp(int exp) {
	this.exp = exp;
}



@Override
public String toString() {
	return "mod [ID=" + ID + ", name=" + name + ", company=" + company + ", exp=" + exp + "]";
}
}
