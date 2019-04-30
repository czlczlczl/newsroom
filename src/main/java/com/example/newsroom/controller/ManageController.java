package com.example.newsroom.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.newsroom.entity.Author;
import com.example.newsroom.model.*;
import com.example.newsroom.service.ManageService;
import com.example.newsroom.util.Sha256;
import com.example.newsroom.util.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/manage")
public class ManageController {

    @Autowired
    ManageService manageService;

    /**
     * 1. 修改密码
     * @return
     */
    @PostMapping(value = "/resetpwd")
    public Object ResetPassword(@RequestParam(value = "oldpwd") String oldpwd, @RequestParam(value = "newpwd") String newpwd, HttpSession httpSession){
        oldpwd = Sha256.getSHA256StrJava(httpSession.getAttribute(WebSecurityConfig.SESSION_USERNAME) + oldpwd);
        newpwd = Sha256.getSHA256StrJava(httpSession.getAttribute(WebSecurityConfig.SESSION_USERNAME) + newpwd);

        return manageService.ResetPassword(oldpwd, newpwd, (String) httpSession.getAttribute(WebSecurityConfig.SESSION_USERNAME), (int)httpSession.getAttribute(WebSecurityConfig.SESSION_ROLE));
    }

    /**
     * 2. 得到用户信息，使用session，返回map
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getinfo")
    public Object GetInformation(HttpSession httpSession){
        String username = (String) httpSession.getAttribute(WebSecurityConfig.SESSION_USERNAME);
        int role = (int) httpSession.getAttribute(WebSecurityConfig.SESSION_ROLE);

        return manageService.GetUserInfo(username,role);
    }

    /**
     * 3. 修改用户信息，使用session，返回map
     * @return
     */
    @PostMapping(value = "/modinfo")
    public Object ModifyInformation(@RequestBody JSONObject userinfo, HttpSession httpSession){
        int role = (int) httpSession.getAttribute(WebSecurityConfig.SESSION_ROLE);
        String username = (String) httpSession.getAttribute(WebSecurityConfig.SESSION_USERNAME);

        return manageService.UpdateUserInfo(userinfo, username, role);
    }

    /**
     * 4. 得到用户信息，使用session，返回map
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getname")
    public Object GetName(HttpSession httpSession){
        String username = (String) httpSession.getAttribute(WebSecurityConfig.SESSION_USERNAME);
        int role = (int) httpSession.getAttribute(WebSecurityConfig.SESSION_ROLE);

        return manageService.GetName(username,role);
    }


}
