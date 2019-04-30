package com.example.newsroom.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.newsroom.entity.Author;
import com.example.newsroom.model.ResetPwd;
import com.example.newsroom.model.SafeAnswer;
import com.example.newsroom.model.Voucher;

import java.util.Map;

public interface ManageService {

    Map<String, Object> ResetPassword(String oldpwd, String newpwd, String username, int role);

    Map<String, Object> GetUserInfo(String username, int role);

    Map<String, Object> UpdateUserInfo(JSONObject userinfo, String username, int role);

    Map<String, Object> GetName( String username, int role);

}