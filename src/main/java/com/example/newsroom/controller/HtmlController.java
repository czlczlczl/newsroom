package com.example.newsroom.controller;

import com.example.newsroom.util.WebSecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HtmlController {
    @GetMapping(value = "/")
    public String Loginhtml(){
        return "index";
    }

    @GetMapping(value = "/logout")
    public String Logout(HttpSession httpSession){
        httpSession.removeAttribute(WebSecurityConfig.SESSION_USERNAME);
        httpSession.removeAttribute(WebSecurityConfig.SESSION_NAME);
        httpSession.removeAttribute(WebSecurityConfig.SESSION_ROLE);
        httpSession.removeAttribute(WebSecurityConfig.SESSION_ID);
        return "redirect:/";
    }
}
