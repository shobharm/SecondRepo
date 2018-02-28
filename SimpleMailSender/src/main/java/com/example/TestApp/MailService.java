package com.example.TestApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
@Autowired

private JavaMailSender mailSender;

public MailService(JavaMailSender mailSender) {
	this.mailSender=mailSender;
}

public void sendMail(String mailBody) {
	SimpleMailMessage mail= new SimpleMailMessage();
	mailBody=mailBody.replaceAll("_", "\r\n");
	String subject=mailBody.split("-")[1];
	String body=mailBody.split("-")[0];
	
	mail.setTo("shobham70@gmail.com");
	mail.setFrom("shobharm@ymail.com");
	mail.setSubject(subject);
	mail.setText(body);
	mailSender.send(mail);
	
}
	
}
