package com.example.newsroom.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.newsroom.entity.Announcement;
import com.example.newsroom.entity.Certificate;
import com.example.newsroom.entity.FriendLink;
import com.example.newsroom.entity.UserCondition;
import com.example.newsroom.service.AdminService;
import com.example.newsroom.util.RandomUtil;
import com.example.newsroom.util.Sha256;
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
     * 4. 得到四种用户信息
     * @param role
     * @param httpSession
     * @return
     */
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
     * 7. 创建编辑或审稿人
     *
     * @param user
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
     * 8. 创建学术领域
     * @param academicsec
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/createacademicsec")
    public Object CreateAcademicsec(@RequestParam(value = "academicsec")String academicsec, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.CreateAcademicsec(academicsec);
    }

    /**
     * 9. 更新学术领域
     * @param academicsec
     * @param id
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/updateacademicsec")
    public Object UpdateAcademicsec(@RequestParam(value = "academicsec")String academicsec, @RequestParam(value = "id")int id, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.UpdateAcademicsec(academicsec,id);
    }

    /**
     * 10. 创建栏目
     * @param column
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/createcolumn")
    public Object CreateColumn(@RequestParam(value = "column")String column, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.CreateColumn(column);
    }

    /**
     * 11. 更新栏目
     * @param column
     * @param id
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/updatecolumn")
    public Object UpdateColumn(@RequestParam(value = "column")String column, @RequestParam(value = "id")int id, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.UpdateColumn(column,id);
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
     * 新建一条内容插入首页横向版面
     * @param name
     * @param content
     * @param priority
     * @param alive
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/insertmain")
    public Object InsertMain(@RequestParam(value = "name")String name,
                             @RequestParam(value = "content")String content,
                             @RequestParam(value = "priority")int priority,
                             @RequestParam(value = "alive",defaultValue = "1")int alive,
                             HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.InsertMain(name,content,priority,alive);
    }

    /**
     * 更新首页横向版面任意一条
     * @param id
     * @param name
     * @param content
     * @param priority
     * @param alive
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/updatetmain")
    public Object UpdateMain(@RequestParam(value = "id") int id,
                             @RequestParam(value = "name",required = false)String name,
                             @RequestParam(value = "content", required = false)String content,
                             @RequestParam(value = "priority")int priority,
                             @RequestParam(value = "alive")int alive,
                             HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.UpdateMain(id,name,content,priority,alive);
    }

    /**
     * 18. 删除首页横向版面任意一条
     * @param id
     * @return
     */
    @PostMapping(value = "/deletemain")
    public Object DeleteMain(@RequestParam(value = "id") int id, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.DeleteMain(id);
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

        return adminService.UpdateInfoCenter(id,name,file1.getName(),priority,alive);
    }

    /**
     * 21. 删除资料中心
     * @param id
     * @return
     */
    @PostMapping(value = "/deleteinfocenter")
    public Object DeleteInfoCenter(@RequestParam(value = "id") int id, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.DeleteInfoCenter(id);
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
     * 24. 删除友情链接
     * @param id
     * @return
     */
    @PostMapping(value = "/deletelink")
    public Object DeleteLink(@RequestParam(value = "id") int id, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.DeleteLink(id);
    }

/**
 * lfx
 */

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
     *得到page页的友情链接
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
     * 通过公告标题来查询公告
     * @param title
     * @param page
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/getannouncement")
    public Object GetAnnouncement(@RequestParam(value = "title",defaultValue = "")String title
            , @RequestParam(value = "page",defaultValue = "1") int page
            , HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.GetAnnouncement(title, page);
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

    //TODO 还没写完
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
     * 根据id来删除学术领域
     * @param id 学术领域的id
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/deleteacademicsec")
    public Object DeleteAcademicsec(@RequestParam(value = "id") int id, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.DeleteAcademicsec(id);
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
     * 删除证书
     * @param id
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/deletecertificate")
    public Object DeleteCertificate(@RequestParam(value = "id") int id, HttpSession httpSession){
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.DeleteCertificate(id);
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
     * 是否启用证书
     * @param id
     * @param alive
     * @param httpSession
     * @return
     */
    @GetMapping(value = "/updatecertificatealive")
    public Object UpdateCertificateAlive(@RequestParam(value = "id") int id,@RequestParam(value = "alive") int alive,HttpSession httpSession) {
        Map map = VerifyAdmin(httpSession);
        if (map != null) {
            return map;
        }

        return adminService.UpdateCertificateAlive(id, alive);
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
        //int adminrole = (int) httpSession.getAttribute(WebSecurityConfig.SESSION_ROLE);
        int adminrole = 0;

        if(adminrole != 0){
            Map<String, Object> result = new HashMap<>();
            result.put("result",0);
            result.put("error","您不是管理员，权限不足");
            return result;
        }

        return null;
    }




/**
 * lfx
 */
}
