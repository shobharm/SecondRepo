package com.example.TestApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
@Autowired
private MailService mailService;
	
	
@RequestMapping("/sendmail/{mailBody:.*}")
public @ResponseBody String sendingMail(@PathVariable("mailBody") String mailBody) {
		System.out.println("Inside mail program"+mailBody);
		mailService.sendMail(mailBody);
		return "Sending mail is success";
}
}
