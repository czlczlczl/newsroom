package com.example.newsroom.service.impl;

import com.example.newsroom.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class MailServiceImpl implements MailService{

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender sender;

    @Override
    public Map<String, Object> SendSimple(String to, String title, String content) {
        Map<String, Object> map = new HashMap<>();
        int result = 0;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); //发送者
        message.setTo(to); //接受者
        message.setSubject(title); //发送标题
        message.setText(content); //发送内容
        try {
            sender.send(message);
            result = 1;
        }catch (MailException e){
            map.put("result",result);
            map.put("error","邮件发送错误");
            return map;
        }
        map.put("result",result);
        return map;
    }
}
