package com.example.newsroom.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.newsroom.entity.*;
import com.example.newsroom.service.AdminService;
import com.example.newsroom.util.RandomUtil;
import com.example.newsroom.util.Sha256;
import com.example.newsroom.util.WebSecurityConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    private static final String anpath = FileController.anattapath;
    private static final String anpicpath = FileController.anpicpath;
    private static final String infocenterpath = FileController.infocenterpath;
    private static final String certificatepath = FileController.certificatepath;

    @Autowired
    AdminService adminService;

    /**
     * 1. 发布公告,附件是以随机名加后缀名字存储
     * @param file
     * @param title
     * @param content
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/createannouncement")
    public Object CreateAnnouncement(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam(value = "title") String title,
                                      @RequestParam(value = "content") String content, @RequestParam(value = "pic", required = false) String pic,
                                      HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }
        Announcement announcement = new Announcement();
        if(file != null) {
            String s = file.getOriginalFilename();
            String a[] = s.split("\\.");
            File file1 = new File(anpath,RandomUtil.getRandomFileName() + "." + a[a.length - 1]);
            if (!file1.exists()) {
                try {
                    file1.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file1);
                    fileOutputStream.write(file.getBytes());
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            announcement.setTitle(title);
            announcement.setContent(content);
            announcement.setDate_pub(new Date());
            announcement.setUpload(file1.getName());
            announcement.setPic(pic);
        }else {
            announcement.setTitle(title);
            announcement.setContent(content);
            announcement.setDate_pub(new Date());
        }
        return adminService.CreateAnnouncement(announcement);
    }

    /**
     * 2. 上传公告图片
     * @param file
     * @return
     * @throws RuntimeException
     */
    @PostMapping(value = "/uploadpic")
    public Object uploadImage(@RequestParam(value = "file") MultipartFile file) throws RuntimeException {
        Map<String, Object> map = new HashMap<>();
        if (file.isEmpty()) {
            return map.put("result",0);
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        String filePath = anpicpath;
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath);
        // 检测是否存在目录
        if (!dest.exists()) {
            dest.mkdirs();
        }
        try {
            fileName = RandomUtil.getRandomFileName() +suffixName;
            FileOutputStream outputStream = new FileOutputStream(filePath + "/" + fileName);
            outputStream.write(file.getBytes());
            map.put("result",1);
            map.put("url",fileName);
            outputStream.close();
            return map;
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        return map.put("result",0);
    }

    /**
     * 3. 删除公告
     * @param id
     * @return
     */
    @GetMapping(value = "/deleteannouncement/id={id}")
    public Object DeleteAnnouncement(@PathVariable(value = "id")int id, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.DeleteAnnouncement(id);
    }

    /**
     * 更新公告
     * @param id
     * @param file
     * @param title
     * @param content
     * @param pic
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/updateannouncement")
    public Object UpdateAnnouncement(@RequestParam(value = "id")int id, @RequestParam(value = "title") String title,
                                     @RequestParam(value = "content") String content,@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam(value = "pic", required = false) String pic,
                                     HttpSession httpSession) {

        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        //判断公告附件和公告图片是否修改
        Announcement announcement = new Announcement();
        announcement.setId(id);
        if(file != null) {
            String s = file.getOriginalFilename();
            String a[] = s.split("\\.");
            File file1 = new File(anpath,RandomUtil.getRandomFileName() + "." + a[a.length - 1]);
            if (!file1.exists()) {
                try {
                    file1.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file1);
                    fileOutputStream.write(file.getBytes());
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            announcement.setTitle(title);
            announcement.setContent(content);
            announcement.setDate_pub(new Date());
            announcement.setUpload(file1.getName());
        }else {
            announcement.setTitle(title);
            announcement.setContent(content);
            announcement.setDate_pub(new Date());
        }
        if (pic != null) {
            announcement.setPic(pic);
        }

        return adminService.UpdateAnnouncement(announcement);
    }

    /**
     * 通过id得到具体公告
     * @param id
     * @return
     */
    @GetMapping(value = "/getannouncement/id={id}")
    public Object GetAnnouncement(@PathVariable(value = "id")int id) {

        return adminService.GetAnnouncement(id);
    }

    /**
     * 通过公告标题来查询公告
     * @param title
     * @param page
     * @param httpSession
     * @return
     */
    /**
     * 通过公告标题来查询公告
     * @param adminEntity，取出title和page
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/getannouncement")
    public Object GetAnnouncement(@RequestBody AdminEntity adminEntity, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetAnnouncement(adminEntity.getTitle(), adminEntity.getPage());
    }

    /**
     * 4. 得到四种用户信息
     * @param role
     * @param httpSession
     * @return
     */
    @Deprecated
    @GetMapping(value = "/getuser/role={role}&page={page}")
    public Object GetUser(@PathVariable(value = "role")int role, @PathVariable(value = "page")int page, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetUser(role,page);
    }

    /**
     * 5. 重置密码
     * @param username
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/resetpwd/username={username}&role={role}")
    public Object ResetPassword(@PathVariable(value = "username")String username, @PathVariable(value = "role")int role,HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.ResetPassword(username,role);
    }

    /**
     * 创建编辑或审稿人
     * @param user
     * @param role
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/createuser/role={role}")
    public Object CreateUser(@RequestBody JSONObject user, @PathVariable(value = "role")int role, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        user.put("password", Sha256.getSHA256StrJava((String) user.get("username")+(String) user.get("password")));
        return adminService.CreateUser(user,role);
    }

    /**
     * 6. 删除账号
     * @param username
     * @param role
     * @return
     */
    @GetMapping(value = "/deleteuser/username={username}&role={role}")
    public Object DeleteUser(@PathVariable(value = "username")String username, @PathVariable(value = "role")int role, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.DeleteUser(username,role);
    }

    /**
     * 通过id查询具体的编辑或审稿人
     * @param id
     * @param role
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getuser/role={role}/id={id}")
    public Object GetUserById(@PathVariable(value = "id")int id, @PathVariable(value = "role")int role, HttpSession httpSession) {
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetUserById(id,role);

    }

    /**
     * 修改编辑或审稿人
     * @param user
     * @param role
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/updateuser/role={role}")
    public Object UpdateUser(@RequestBody JSONObject user, @PathVariable(value = "role")int role, HttpSession httpSession) {
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.UpdateUser(user,role);
    }

    /**
     *得到要查询的用户
     * @param userCondition 查询条件
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/searchuser")
    public Object SearchUser(@RequestBody UserCondition userCondition, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.SearchUser(userCondition);
    }

    /**
     * 创建学术领域
     * @param adminEntity，主要取出里面的学术领域名称
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/createacademicsec")
    public Object CreateAcademicsec(@RequestBody AdminEntity adminEntity, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.CreateAcademicsec(adminEntity.getAcademicsec());
    }

    /**
     * 根据id来删除学术领域
     * @param adminEntity,主要取出里面的id来删除学术领域
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/deleteacademicsec")
    public Object DeleteAcademicsec(@RequestBody AdminEntity adminEntity, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.DeleteAcademicsec(adminEntity.getId());
    }

    /**
     * 更新学术领域
     * @param adminEntity，主要取出来学术领域名称和id
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/updateacademicsec")
    public Object UpdateAcademicsec(@RequestBody AdminEntity adminEntity, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.UpdateAcademicsec(adminEntity.getAcademicsec(),adminEntity.getId());
    }

    /**
     * 得到学术领域的列表
     * @param page 当前页
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getacademicsec")
    public Object GetAcademicsec(@RequestParam(value = "page",defaultValue = "1") int page, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetAcademicsec(page);
    }

    /**
     * 通过id得到具体的学术领域
     * @param id
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getacademicsec/id={id}")
    public Object GetAcademicsecById(@PathVariable(value = "id") int id, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetAcademicsecById(id);
    }

    /**
     * 创建栏目
     * @param adminEntity，主要栏目名称
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/createcolumn")
    public Object CreateColumn(@RequestBody AdminEntity adminEntity, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.CreateColumn(adminEntity.getColumn());
    }

    /**
     *通过id删除栏目
     * @param id
     * @param httpSession
     * @return
     */
    /**
     * s通过id删除栏目
     * @param adminEntity,主要取出栏目id
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/deletecolumn")
    public Object DeleteColumn(@RequestBody AdminEntity adminEntity, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.DeleteColumn(adminEntity.getId());
    }

    /**
     * 11. 更新栏目
     * @param column
     * @param id
     * @param httpSession
     * @return
     */
    /**
     * 更新栏目
     * @param adminEntity，取出栏目名称和id
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/updatecolumn")
    public Object UpdateColumn(@RequestBody AdminEntity adminEntity, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.UpdateColumn(adminEntity.getColumn(),adminEntity.getId());
    }

    /**
     * 得到栏目列表
     * @param page 当前页
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getcolumn")
    public Object GetColumn(@RequestParam(value = "page", defaultValue = "1")int page, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetColumn(page);
    }

    /**
     * 通过id查询具体的栏目
     * @param id
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getcolumn/id={id}")
    public Object GetColumnById(@PathVariable(value = "id")int id, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetColumnById(id);
    }

    /**
     * 12. 得到报刊制式，审稿费，版面费以及默认文章数
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getstandardlist")
    public Object GetStandardList(HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetStandardList();
    }

    /**
     * 13. 更新或生成报刊制式，审稿费，版面费以及默认文章数
     * @param year
     * @param standard
     * @param reviewfee
     * @param pagecharges
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/updatestandard")
    public Object UpdateStandard(@RequestParam(value = "year")int year,@RequestParam(value = "standard")int standard,
                                  @RequestParam(value = "reviewfee")int reviewfee,@RequestParam(value = "pagecharges")int pagecharges,
                                 @RequestParam(value = "articlenum")int articlenum, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.UpdateStandard(year,standard,reviewfee,pagecharges,articlenum);
    }

    /**
     * 14. 得到某卷的期数以及每一期对应文章数
     * @param year
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getcontent/year={year}")
    public Object GetContent(@PathVariable(value = "year")int year, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetContent(year);
    }

    /**
     * 15. 更新某卷的期数以及每一期对应文章数
     * @param year
     * @param which
     * @param date
     * @param num
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/updatecontent")
    public Object UpdateContent(@RequestParam(value = "year")int year, @RequestParam(value = "which")int which,
                                @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")@RequestParam(value = "date")Date date, @RequestParam(value = "num")int num,
                                HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.UpdateContent(year,which,date,num);
    }

    @GetMapping(value = "/clearsrc")
    public void ClearSrc(){
        adminService.ClearSrc();
    }

    /**
     * 创建首页横向版面
     * @param name
     * @param content
     * @param priority
     * @param alive
     * @param httpSession
     * @return
     */
    /**
     * 创建首页横向版面
     * @param adminEntity，取出首页横向版面的name,content,priority,alive
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/insertmain")
    public Object InsertMain(@RequestBody AdminEntity adminEntity, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.InsertMain(adminEntity.getName(),adminEntity.getContent(),adminEntity.getPriority(),adminEntity.getAlive());
    }

    /**
     * 18. 删除首页横向版面任意一条
     * @param id
     * @return
     */
    /**
     * 删除首页横向版面任意一条
     * @param adminEntity，取出首页横向版面的id
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/deletemain")
    public Object DeleteMain(@RequestBody AdminEntity adminEntity, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.DeleteMain(adminEntity.getId());
    }

    /**
     * 更新首页横向版面
     * @param id
     * @param name
     * @param content
     * @param priority
     * @param alive
     * @param httpSession
     * @return
     */
    /**
     * 更新首页横向版面
     * @param adminEntity，取出id,name,content,priority,alive
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/updatetmain")
    public Object UpdateMain(@RequestBody AdminEntity adminEntity, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.UpdateMain(adminEntity.getId(),adminEntity.getName(),adminEntity.getContent(),adminEntity.getPriority(),adminEntity.getAlive());
    }

    /**
     * 通过id查询具体的首页横向版面
     * @param id
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getmain/id={id}")
    public Object GetMainById(@PathVariable(value = "id") int id, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetMainById(id);
    }

    /**
     * 得到首页横向版面的列表
     * @param page 当前页
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getmain")
    public Object GetMain(@RequestParam(value = "page", defaultValue = "1") int page, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetMain(page);
    }

    /**
     * 新建一条资料插入资料中心，并同时上传资料文件
     * @param file
     * @param name
     * @param priority
     * @param alive
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/createinfocenter")
    public Object CreateInfoCenter(@RequestParam(value = "file") MultipartFile file,
                                   @RequestParam(value = "name")String name,
                                   @RequestParam(value = "priority")int priority,
                                   @RequestParam(value = "alive",defaultValue = "1")int alive,
                                   HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }
        String s = file.getOriginalFilename();
        String a[] = s.split("\\.");
        File dest = new File(infocenterpath);
        // 检测是否存在目录
        if (!dest.exists()) {
            dest.mkdirs();
        }
        File file1 = new File(infocenterpath,RandomUtil.getRandomFileName() + "." + a[a.length - 1]);
        if (!file1.exists()) {
            try {
                file1.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file1);
                fileOutputStream.write(file.getBytes());
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return adminService.CreateInfoCenter(name,file1.getName(),priority,alive);
    }

    /**
     * 21. 删除资料中心
     * @param id
     * @return
     */
    /**
     * 删除资料中心的一条资料
     * @param adminEntity，取出id
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/deleteinfocenter")
    public Object DeleteInfoCenter(@RequestBody AdminEntity adminEntity, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.DeleteInfoCenter(adminEntity.getId());
    }

    /**
     * 更新资料中心
     * @param id
     * @param name
     * @param file
     * @param priority
     * @param alive
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/updatetinfocenter")
    public Object UpdateInfoCenter(@RequestParam(value = "id") int id,
                                   @RequestParam(value = "name",required = false)String name,
                                   @RequestParam(value = "file", required = false)MultipartFile file,
                                   @RequestParam(value = "priority")int priority,
                                   @RequestParam(value = "alive")int alive,
                                   HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }
        String fileName = "";
        if (file != null){
            String s = file.getOriginalFilename();
            String a[] = s.split("\\.");
            File file1 = new File(infocenterpath,RandomUtil.getRandomFileName() + "." + a[a.length - 1]);
            if (!file1.exists()) {
                try {
                    file1.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file1);
                    fileOutputStream.write(file.getBytes());
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fileName = file1.getName();
        }
        return adminService.UpdateInfoCenter(id,name,fileName,priority,alive);
    }

    /**
     * 通过id查找具体的资料中心
     * @param id
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getinfocenter/id={id}")
    public Object GetInfoCenterById(@PathVariable(value = "id") int id, HttpSession httpSession) {
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetInfoCenterById(id);
    }

    /**
     * 得到资料中心列表
     * @param page 当前页
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getinfocenter")
    public Object GetInfoCenter(@RequestParam(value = "page", defaultValue = "1") int page, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetInfoCenter(page);
    }

    /**
     * 22. 新建友情链接
     * @param link
     * @return
     */
    @PostMapping(value = "/insertlink")
    public Object InsertLink(@RequestBody FriendLink link, HttpSession httpSession) {
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.InsertLink(link);
    }

    /**
     * 删除友情链接
     * @param link,取出id
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/deletelink")
    public Object DeleteLink(@RequestBody FriendLink link, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.DeleteLink(link.getId());
    }

    /**
     * 23. 更新友情链接
     * @param link
     * @return
     */
    @PostMapping(value = "/updatetlink")
    public Object UpdateLink(@RequestBody FriendLink link, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.UpdateLink(link);
    }

    /**
     *查询友情链接
     * @param page 当前页
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/searchlink")
    public Object SearchLink(@RequestParam(value = "page",defaultValue = "1") int page, HttpSession httpSession) {
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.SearchLink(page);
    }

    /**
     * 通过id查询具体的友情链接
     * @param id
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getlink/id={id}")
    public Object GetLinkById(@PathVariable(value = "id") int id, HttpSession httpSession) {
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetLinkById(id);
    }

    /**
     * 创建新证书
     * @param certificate
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/insertcertificate")
    public Object InsertCertificate(@RequestBody Certificate certificate, HttpSession httpSession) {
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.InsertCertificate(certificate);
    }

    /**
     * 删除证书
     * @param id
     * @param httpSession
     * @return
     */
    /**
     * 删除证书
     * @param certificate，取出id
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/deletecertificate")
    public Object DeleteCertificate(@RequestBody Certificate certificate, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.DeleteCertificate(certificate.getId());
    }

    /**
     * 更新证书
     * @param certificate
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/updatecertificate")
    public Object UpdateCertificate(@RequestBody Certificate certificate, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.UpdateCertificate(certificate);
    }

    /**
     * 查询证书
     * @param page
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/searchcertificate")
    public Object SearchCertificate(@RequestParam(value = "page",defaultValue = "1") int page, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.SearchCertificate(page);
    }

    /**
     * 通过id查询具体的证书信息
     * @param id
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/getcertificate/id={id}")
    public Object GetCertificateById(@PathVariable(value = "id") int id, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetCertificateById(id);
    }

    /**
     * 是否启用证书
     * @param id
     * @param alive
     * @param httpSession
     * @return
     */
    /**
     * 是否启用证书
     * @param certificate，取出id和alive
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/updatecertificatealive")
    public Object UpdateCertificateAlive(@RequestBody Certificate certificate,HttpSession httpSession) {
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.UpdateCertificateAlive(certificate.getId(), certificate.getAlive());
    }

    /**
     * 上传文件包括图片,type为区分文件上传路径
     * @param type 1为公告图片，2为公告文件，3为资料中心文件，4为证书图片
     * @param file
     * @return
     * @throws RuntimeException
     */
    @PostMapping(value = "/uploadfile")
    public Object uploadFile(@RequestParam(value = "type")int type, @RequestParam(value = "file") MultipartFile file) throws RuntimeException {
        Map<String, Object> map = new HashMap<>();
        if (file.isEmpty()) {
            return map.put("result", 0);
        }

        // 获取上传文件的文件名
        String originalFilename = file.getOriginalFilename();
        // 系统重新生成新的文件名
        String a[] = originalFilename.split("\\.");
        String fileName = RandomUtil.getRandomFileName() + "." + a[a.length - 1];
        // 文件上传后的路径
        String filePath = "";
        switch (type) {
            case 1://公告图片
                filePath = anpicpath;
                break;
            case 2://公告附件
                filePath = anpicpath;
                break;
            case 3://资料中心的文件
                filePath = infocenterpath;
                break;
            case 4://证书图片
                filePath = certificatepath;
                break;
            default:
                return map.put("result", 0);
        }
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath);
        // 检测是否存在目录
        if (!dest.exists()) {
            dest.mkdirs();
        }
        try {

            FileOutputStream outputStream = new FileOutputStream(filePath + "/" + fileName);
            outputStream.write(file.getBytes());
            map.put("result",1);
            map.put("url",fileName);
            outputStream.close();
            return map;
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        return map.put("result",0);

    }

    /**
     * 判断是否是管理员
     * @param httpSession
     * @return
     */
    private Map VerifyAdmin(HttpSession httpSession) {
        int adminrole = (int) httpSession.getAttribute(WebSecurityConfig.SESSION_ROLE);

        if(adminrole != 0){
            Map<String, Object> result = new HashMap<>();
            result.put("result",0);
            result.put("error","您不是管理员，权限不足");
            return result;
        }

        return null;
    }
}
