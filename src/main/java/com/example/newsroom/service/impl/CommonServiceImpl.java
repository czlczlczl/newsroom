package com.example.newsroom.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.newsroom.dao.AdminMapper;
import com.example.newsroom.dao.CommonMapper;
import com.example.newsroom.entity.Author;
import com.example.newsroom.entity.Standard;
import com.example.newsroom.model.ResetPwd;
import com.example.newsroom.model.SafeAnswer;
import com.example.newsroom.model.Voucher;
import com.example.newsroom.service.CommonService;
import com.example.newsroom.util.Sha256;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class CommonServiceImpl implements CommonService{

    @Autowired
    CommonMapper commonMapper;
    @Autowired
    AdminMapper adminMapper;

    /**
     * 验证邮箱是否已注册，返回map
     * @param email
     * @return
     */
    @Override
    public Map<String, Object> IsEmailExist(String email) {
        Integer exist;
        Map<String, Object> map = new HashMap<>();
        int result = 1;

        exist = commonMapper.IsEmailExist(email);
        if(exist != null){
            result = 0;
        }
        map.put("result",result);
        return map;
    }

    /**
     * 作者注册，返回map
     * @param author
     * @return
     */
    @Override
    public Map<String, Object> InserAuthor(Author author) {
//        String username = "1" + author.getEmail();
//        author.setEmail(username);
        String username = author.getEmail();
        String password = author.getPassword();
        Map<String, Object> map = new HashMap<>();
        int result;
//        author.setPassword(new BCryptPasswordEncoder().encode(password));
        author.setPassword(Sha256.getSHA256StrJava(username + password));
        result = commonMapper.InsertAuthor(author);
        map.put("result",result);
        return map;
    }

    /**
     * 登录验证，返回map
     * @param username
     * @param userpassword
     * @param role
     * @return
     */
    @Override
    public Map<String, Object> LoginVerify(String username, String userpassword, int role) {
        String password;
        Map<String, Object> map = new HashMap<>();
        int year,result;

        Calendar a=Calendar.getInstance();
        year = a.get(Calendar.YEAR);
        password = commonMapper.GetPwdById(username,role,year);
        if (password != null && !password.equals("")) {
            if (password.equals(userpassword)) {
                result = 1;//登录成功
            } else {
                result = 2;//登陆失败
            }
        } else {
            result = 0;//登陆失败
        }

        map.put("result", result);
        return map;
    }

    /**
     * 通过用户名找到具体对象
     * @param username
     * @param role
     * @return
     */
    @Override
    public Map<String, Object> GetUserByUsername(String username, int role) {
        HashMap user;
        Map<String, Object> map = new HashMap<>();
        int result;

        user = commonMapper.GetUserById(username,role);

        //判断用户信息是否存在
        try {
            if (user != null) {
                result = 1;
                map.put("name", user.get("name"));
                map.put("id", user.get("id"));
                map.put("role", role);
            } else {
                result = 0;
            }
        } catch (Exception e) {
            result = 0;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 修改密码前获取密保问题，返回que1->第一个密保问题的map
     * @param username
     * @param role
     * @return
     */
    @Override
    public Map<String, Object> GetSafeQueById(String username, int role) {
        Map<String, Object> map = new HashMap<>();
        HashMap safeque;
        Map<String, Object> que = new HashMap<>();
        int result;

        safeque = commonMapper.GetSafeQueById(username,role);
        if(safeque != null){
            result = 1;
            map.put("result",result);
        }else {
            result = 0;
            map.put("result",result);
            return map;
        }
        String a = (String)safeque.get("safeque1");
        String b = (String)safeque.get("safeque2");
        String c = (String)safeque.get("safeque3");

        String safeque1[] = a.split(";");
        String safeque2[] = b.split(";");
        String safeque3[] = c.split(";");

        int ad = Integer.valueOf((String)safeque2[0]);

        que.put("que1",commonMapper.GetQueById(Integer.valueOf(safeque1[0])));
        que.put("que2",commonMapper.GetQueById(Integer.valueOf(safeque2[0])));
        que.put("que3",commonMapper.GetQueById(Integer.valueOf(safeque3[0])));

        map.put("safeque",que);
        return map;
    }

    /**
     * 修改密码前确认密保问题回答正确,返回map
     * @param safeAnswer
     * @return
     */
    @Override
    public Map<String, Object> VerifySafeQue(SafeAnswer safeAnswer){
        Map<String, Object> map = new HashMap<>();
        HashMap safeque;
        int result = 0;

        safeque = commonMapper.GetSafeQueById(safeAnswer.getUsername(),safeAnswer.getRole());
        String a = (String)safeque.get("safeque1");
        String b = (String)safeque.get("safeque2");
        String c = (String)safeque.get("safeque3");

        String safeque1[] = a.split(";");
        String safeque2[] = b.split(";");
        String safeque3[] = c.split(";");

        if(safeAnswer.getAnswer1().equals(safeque1[1]) && safeAnswer.getAnswer2().equals(safeque2[1]) && safeAnswer.getAnswer3().equals(safeque3[1])){
            result = 1;
        }
        map.put("result",result);
        return map;
    }

    /**
     * 修改密码，返回map
     * @param resetPwd
     * @return
     */
    @Override
    public Map<String, Object> ResetPassword(ResetPwd resetPwd){
        Map<String, Object> map = new HashMap<>();
        int result;

        result = commonMapper.ResetPassword(resetPwd);
        map.put("result",result);
        return map;
    }

    /**
     * 公告显示，返回map
     * @param num
     * @return
     */
    @Override
    public Map<String, Object> GetAnnouncementList(int num) {
        List<HashMap<String, Object>> announcementlist;
        Map<String, Object> map = new HashMap<>();
        int result = 0;


//        SimpleDateFormat simpleDateFormat;
//        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
//        String str = simpleDateFormat.format(date);
        announcementlist = commonMapper.GetAnnouncementList(num);

        if(announcementlist != null){
            result = 1;
        }else {
            map.put("result",result);
            return map;
        }

        map.put("result",result);
        map.put("announcementlist",announcementlist);
        return map;
    }

    @Override
    public Map<String, Object> GetAnnouncement(int id) {
        HashMap announcement;
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        announcement = commonMapper.GetAnnouncement(id);
        if(announcement != null){
            result = 1;
            map.put("announcement",announcement);
        }
        map.put("result",result);
        return map;
    }

    /**
     * 最新文章，返回map
     * @param num
     * @return
     */
    @Override
    public Map<String, Object> GetLatestArticleList(int num) {
        List<HashMap<String, Object>> articlelist;
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        Date a = new Date();
        articlelist = commonMapper.GetLatestArticleList(num,a);
        if(articlelist != null){
            result = 1;
        }else {
            map.put("result",result);
            return map;
        }

        map.put("result",result);
        map.put("articlelist",articlelist);
        return map;
    }

    /**
     * 得到论文具体内容，返回map
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> GetArticle(int id) {
        HashMap article;
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        article = commonMapper.GetArticle(id);
        if(article != null){
            result = 1;
            map.put("article",article);
        }
        map.put("result",result);
        return map;
    }

    /**
     * 获得type信息
     * @return
     */
    @Override
    public Map<String, Object> GetType(String type) {
        List<HashMap<String, Object>> typelist;
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        typelist = commonMapper.GetType(type);
        if(typelist != null){
            result = 1;
            map.put("typelist",typelist);
        }else {
            map.put("result",result);
            return map;
        }

        map.put("result",result);
        return map;

    }


    /**
     *获得首页的横向版面切换页面总览
     * @return
     */
    @Override
    public Map<String, Object> GetMainList() {
        List<HashMap<String, Object>> mainlist;
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        mainlist = commonMapper.GetMainList();
        if(mainlist != null){
            result = 1;
            map.put("mainlist",mainlist);
        }

        map.put("result",result);
        return map;
    }

    /**
     * 首页的横向版面切换页面
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> GetMain(int id) {
        String main;
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        main = commonMapper.GetMain(id);
        if(main != null){
            result = 1;
            map.put("main",main);
        }
        map.put("result",result);
        return map;
    }

    @Override
    public Map<String, Object> GetInfoCenterList() {
        List<HashMap<String, Object>> infocenterlist;
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        infocenterlist = commonMapper.GetInfoCenterList();
        if(infocenterlist != null){
            result = 1;
            map.put("infocenterlist",infocenterlist);
        }

        map.put("result",result);
        return map;
    }

    @Override
    public Map<String, Object> GetLinkList() {
        List<HashMap<String, Object>> linklist;
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        linklist = commonMapper.GetLinkList();
        if(linklist != null){
            result = 1;
            map.put("linklist",linklist);
        }

        map.put("result",result);
        return map;
    }

    @Override
    public Map<String, Object> GetCertificate() {
        List<HashMap<String, Object>> certificatelist;
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        certificatelist = commonMapper.GetCertificate();
        if(certificatelist != null){
            result = 1;
            map.put("certificatelist",certificatelist);
        }

        map.put("result",result);
        return map;
    }
}
