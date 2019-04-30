package com.example.newsroom.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.newsroom.dao.ManageMapper;
import com.example.newsroom.entity.Author;
import com.example.newsroom.model.*;
import com.example.newsroom.service.ManageService;
import com.example.newsroom.util.Sha256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ManageServiceImpl implements ManageService{

    @Autowired
    ManageMapper manageMapper;

    /**
     * 修改密码，返回map
     * @param oldpwd
     * @param newpwd
     * @param username
     * @param role
     * @return
     */
    @Override
    public Map<String, Object> ResetPassword(String oldpwd, String newpwd, String username, int role){
        Map<String, Object> map = new HashMap<>();
        String pwd;
        int result;

        pwd = manageMapper.GetPwdById(username, role);
        if(!oldpwd.equals(pwd)){
            result = 0;
            map.put("error","输入旧密码错误");
        }else {
            Integer res;
            res = manageMapper.ResetPassword(newpwd,username,role);
            if (res == 1){
                result = 1;
            }else {
                result = 0;
                map.put("error","出现未知错误");
            }
        }
        map.put("result",result);
        return map;
    }

    /**
     * 得到信息，返回map
     * @param username
     * @param role
     * @return
     */
    @Override
    public Map<String, Object> GetUserInfo(String username, int role) {
        Map<String, Object> map = new HashMap<>();
        HashMap information;
        int result = 0;

        information = manageMapper.GetInformation(username,role);
        if(information != null){
            map.put("information",information);
            result = 1;
        }
        map.put("result",result);
        return map;
    }

    /**
     * 修改信息，返回map
     * @return
     */
    @Override
    public Map<String, Object> UpdateUserInfo(JSONObject userinfo, String username, int role) {
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        switch (role){
            //作者
            case 1:
                int a;
                AuthorInfo authorInfo = JSONObject.toJavaObject(userinfo,AuthorInfo.class);
                a = manageMapper.UpdateUserInfo(authorInfo,username,role);
                if(a == 1){
                    result = 1;
                }
                break;
            //主编
            case 2:
                int b;
                EditorInfo editorInfo1 = JSONObject.toJavaObject(userinfo,EditorInfo.class);
                b= manageMapper.UpdateUserInfo(editorInfo1,username,role);
                if(b == 1){
                    result = 1;
                }
                break;
            //编辑
            case 3:
                int c;
                EditorInfo editorInfo2 = JSONObject.toJavaObject(userinfo,EditorInfo.class);
                c= manageMapper.UpdateUserInfo(editorInfo2,username,role);
                if(c == 1){
                    result = 1;
                }
                break;
            //审稿人
            case 4:
                int d;
                ProfessorInfo profrssorInfo = JSON.toJavaObject(userinfo,ProfessorInfo.class);
                d= manageMapper.UpdateUserInfo(profrssorInfo,username,role);
                if(d == 1){
                    result = 1;
                }
                break;
            default:
                break;
        }
        map.put("result",result);
        return map;
    }

    @Override
    public Map<String, Object> GetName(String username, int role) {
        Map<String, Object> map = new HashMap<>();
        String name;
        int result = 0;

        name = manageMapper.GetName(username,role);
        if(name != null){
            map.put("name",name);
            result = 1;
        }
        map.put("result",result);
        return map;
    }
}
