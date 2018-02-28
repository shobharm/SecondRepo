package com.example.TestApp;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.SequenceInputStream;

import org.apache.solr.common.util.FastOutputStream;

public class TestIO {

	@SuppressWarnings("resource")
	//public static void main(String[] args) {
/*		///System.out.println("enter something here");
try {
	//int test=System.in.read();
	//System.out.println("result"+test);
	String t="Shobha";
	FileInputStream in1= new FileInputStream("/home/tcs/Desktop/ForDockers/Test.txt");
	FileInputStream in2= new FileInputStream("/home/tcs/Desktop/ForDockers/Test2");
	FileOutputStream out= new FileOutputStream("/home/tcs/Desktop/ForDockers/TestNew");
	SequenceInputStream sq=new SequenceInputStream(in1,in2);
	BufferedWriter bw=new BufferedWriter(out);
	PrintWriter pw = new PrintWriter(bw);
	int i;
	 while((i=sq.read())!=-1){    
        
         out.write((char)i);
        
        }*/   
	/* Console c = System.console();
	 System.out.println("Please enter your name");
	 String name= c.readLine();
	 
	
	System.out.println("Password is:::::::::: "+name);
} catch (IOException e) {
	e.printStackTrace();
}
	}*/
		
		public static void main(String args[]){    
			Console c=System.console();    
			System.out.println("Enter password: ");    
			char[] ch=c.readPassword();    
			String pass=String.valueOf(ch);//converting char array into string    
			System.out.println("Password is: "+pass);    
			}    
		
		
		
		

}
