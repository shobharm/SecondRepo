package com.example.TestApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TestModel {

	@Id
	private int ID;
	
	
	private int std_id;
	private String name;
	private int standard;
	private double score;
	
	public TestModel(int std_id,String name,int standard,int score) {
		this.std_id=std_id;
		this.name=name;
		this.standard=standard;
		this.score=score;
	}
	
	
	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "TestModel [ID=" + ID + ", std_id=" + std_id + ", name=" + name + ", standard=" + standard + ", score="
				+ score + "]";
	}
	
}
