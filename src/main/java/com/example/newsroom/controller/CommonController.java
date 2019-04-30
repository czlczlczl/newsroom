package com.example.newsroom.controller;

import com.example.newsroom.entity.Author;
import com.example.newsroom.model.ResetPwd;
import com.example.newsroom.model.SafeAnswer;
import com.example.newsroom.model.UserLogin;
import com.example.newsroom.service.AdminService;
import com.example.newsroom.service.CommonService;
import com.example.newsroom.util.Sha256;
import com.example.newsroom.util.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/common")
public class CommonController {

    @Autowired
    CommonService commonService;

    @Autowired
    AdminService adminService;

    /**
     * 1. 验证邮箱是否已注册，返回map
     * @param email
     * @return
     */
    @PostMapping(value = "/register/isemailexist")
    public Object IsEmailExist(@RequestParam(value = "email") String email){
        return commonService.IsEmailExist(email);
    }

    /**
     * 2. 作者注册，返回map
     * @param author
     * @return
     */
    @PostMapping(value = "/register")
    public Object UserRegister(@RequestBody Author author){
        return commonService.InserAuthor(author);
    }


    /**
     * 3. 登录验证，生成session，返回map
     * @param userlogin
     * @param httpSession
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/login")
    public Object UserLogin(@RequestBody UserLogin userlogin, HttpSession httpSession) throws IOException {
        Map<String, Object> map = new HashMap<>();
        String username = userlogin.getUsername();
        String userpassword = userlogin.getPassword();
        int role = userlogin.getRole();
        int result,res;

        if(role != 0) {
            userpassword = Sha256.getSHA256StrJava(username + userpassword);
        }

        result = (int)commonService.LoginVerify(username,userpassword,role).get("result");
        if(result == 1 ){
            httpSession.setAttribute(WebSecurityConfig.SESSION_USERNAME, username);
            httpSession.setAttribute(WebSecurityConfig.SESSION_ROLE, role);
            if(role == 0){
                map.put("name","admin");
                map.put("role","0");
            }else{
                Map<String, Object> user;
                user = commonService.GetUserByUsername(username,role);
                httpSession.setAttribute(WebSecurityConfig.SESSION_ID, user.get("id"));
                httpSession.setAttribute(WebSecurityConfig.SESSION_NAME, user.get("name"));
                System.out.println(httpSession.getAttribute(WebSecurityConfig.SESSION_NAME));
                map.put("name",user.get("name"));
                map.put("role", user.get("role"));
                map.put("username",user.get("username"));
                map.put("id", user.get("id"));
            }
            res = 1;
        }else {
            res = 0;
        }
        map.put("result", res);
        return map;
    }

    /**
     * 4. 修改密码前获取具体密保问题，返回que1->第一个密保问题的map
     * @param username
     * @param role
     * @return
     */
    @GetMapping(value = "/repwd/getsafeque/username={username}&role={role}")
    public Object GetSafeQue(@PathVariable(value = "username")String username, @PathVariable(value = "role")int role){
        return commonService.GetSafeQueById(username,role);
    }

    /**
     * 5. 修改密码前确认密保问题回答正确,返回map
     * @param safeAnswer
     * @return
     */
    @PostMapping(value = "/repwd/getsafeque/verifysafeque")
    public Object VerifySafeQue(@RequestBody SafeAnswer safeAnswer){
        return commonService.VerifySafeQue(safeAnswer);
    }

    /**
     * 6. 修改密码
     * @return
     */
    @PostMapping(value = "/repwd/getsafeque/verifysafeque/reset")
    public Object ResetPassword(@RequestBody ResetPwd resetPwd){
        resetPwd.setPassword(Sha256.getSHA256StrJava(resetPwd.getUsername() + resetPwd.getPassword()));

        return commonService.ResetPassword(resetPwd);
    }

    /**
     * 7. 公告列表，返回id和title和date_pub的值
     * @return
     */
    @GetMapping(value = "/announcementlist/num={num}")
    public Object announcementlist(@PathVariable(value = "num") int num){
        return commonService.GetAnnouncementList(num);
    }

    /**
     * 8. 得到对应公告具体内容
     * @param id
     * @return
     */
    @GetMapping(value = "/getannouncement/id={id}")
    public Object GetAnnouncement(@PathVariable(value = "id") int id){
        return commonService.GetAnnouncement(id);
    }


    /**
     * 9. 文章列表，返回id和title和date_pub的值
     * @return
     */
    @GetMapping(value = "/articlelist/num={num}")
    public Object LatestArticleList(@PathVariable(value = "num") int num){
        return commonService.GetLatestArticleList(num);
    }

    /**
     * 10. 得到对应文章具体内容
     * @param id
     * @return
     */
    @GetMapping(value = "/getarticle/id={id}")
    public Object GetArticle(@PathVariable(value = "id") int id){
        return commonService.GetArticle(id);
    }

    /**
     * 11. 获取type信息
     * @return
     */
    @GetMapping(value = "/gettype/type={type}")
    public Object GetType(@PathVariable(value = "type") String type){
        return commonService.GetType(type);
    }

    /**
     * 12. 获得首页的横向版面切换页面总览
     */
    @GetMapping(value = "/getmainlist")
    public Object GetMainList(){
        return commonService.GetMainList();
    }

    /**
     * 13. 首页的横向版面切换页面
     */
    @GetMapping(value = "/getmain/id={id}")
    public Object GetMain(@PathVariable(value = "id") int id){
        return commonService.GetMain(id);
    }

    /**
     * 14. 获得资料中心列表
     */
    @GetMapping(value = "/getinfocenterlist")
    public Object GetInfoCenterList(){
        return commonService.GetInfoCenterList();
    }

    /**
     * 15. 获得友情链接列表
     */
    @GetMapping(value = "/getlinklist")
    public Object GetLinkList(){
        return commonService.GetLinkList();
    }

    /**
     * 16. 获得证书列表
     */
    @GetMapping(value = "/getcertificat")
    public Object GetCertificate(){
        return commonService.GetCertificate();
    }

//    @GetMapping(value = "/certpic")
//    public Object fas(){
//        return commonService.GetCertificate();
//    }
//
//    @GetMapping(value = "/getintro")
//    public Object GetCertificffas(){
//        return commonService.GetCertificate();
//    }
//
//    @GetMapping(value = "/gettips")
//    public Object GetCertificafsd(){
//        return commonService.GetCertificate();
//    }

}
