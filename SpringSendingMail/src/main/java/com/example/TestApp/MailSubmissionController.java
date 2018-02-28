/*package com.example.TestApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MailSubmissionController {

    private final JavaMailSender javaMailSender;

    @Autowired
    MailSubmissionController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @RequestMapping("/mail")
    @ResponseStatus(HttpStatus.CREATED)
    SimpleMailMessage send() {        
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("shobharm@ymail.com");
        mailMessage.setReplyTo("someone@localhost");
        mailMessage.setFrom("Test@localhost");
        mailMessage.setSubject("Testing mail server");
        mailMessage.setText("Testing mail server is success [...]");
        javaMailSender.send(mailMessage);
        return mailMessage;
    }
}*/