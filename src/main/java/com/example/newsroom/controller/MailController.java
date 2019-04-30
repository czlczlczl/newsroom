package com.example.newsroom.controller;

import com.example.newsroom.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/sendmail")
    public Object sendMail(@RequestParam("to") String to, @RequestParam("title") String title, @RequestParam("content") String content){
        System.out.println("-----title: " + title);
        return mailService.SendSimple(to, title, content);
    }
}