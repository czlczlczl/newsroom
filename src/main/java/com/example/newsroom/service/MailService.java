package com.example.newsroom.service;

import java.util.Map;

public interface MailService {
    public Map<String, Object> SendSimple(String to, String title, String content);
}
