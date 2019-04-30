package com.example.newsroom.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.newsroom.controller.FileController;
import com.example.newsroom.dao.AdminMapper;
import com.example.newsroom.dao.CommonMapper;
import com.example.newsroom.entity.*;
import com.example.newsroom.service.AdminService;
import com.example.newsroom.util.Sha256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.*;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    CommonMapper commonMapper;

    /**
     * 发布公告
     * @param announcement
     * @return
     */
    @Override
    public Map<String, Object> CreateAnnouncement(Announcement announcement) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;
        res = adminMapper.CreateAnnouncement(announcement);

        if(res != null){
            result = 1;
        }else {
            File file = new File(FileController.anattapath,announcement.getUpload());
            if (file.exists()) {
                file.delete();
            }
        }
        map.put("result", result);
        return map;
    }

    /**
     * 删除公告
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> DeleteAnnouncement(int id) {
        String attapath ="./file/AnnouncementAnnexes";
        String picpath ="./file/AnnouncementPic";

        Map<String, Object> map = new HashMap<>();
        HashMap announcement;
        Integer res;
        StringBuilder error = new StringBuilder();
        int result = 0;

        announcement = commonMapper.GetAnnouncement(id);
        if(announcement == null){
            result = 1;
            map.put("result",result);
            return map;
        }
        String upload = (String) announcement.get("upload");
        String pic = (String) announcement.get("pic");
        if(pic != null) {
            String pics[] = pic.split("\\|");
            for (int i = 0; i < pics.length; i++) {
                File file = new File(picpath, pics[i]);
                if (file.exists()) {
                    boolean jieguo = file.delete();
                    if (!jieguo) {
                        error.append("公告图片").append(i).append("删除失败\n");
                        map.put("result", result);
                        map.put("error", error);
                        return map;
                    }
                }
            }
        }
        if (upload != null) {
            File file = new File(attapath, upload);
            if (file.exists()) {
                boolean i = file.delete();
                if (!i) {
                    error.append("公告附件删除失败\n");
                    map.put("result", result);
                    map.put("error", error);
                    return map;
                }
            }
        }

        res = adminMapper.DeleteAnnouncement(id);
        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 得到四种用户信息
     * @param role
     * @return
     */
    @Override
    public Map<String, Object> GetUser(int role, int page) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> res;
        int result = 0;

        page = (page - 1)*10;
        int count = adminMapper.GetUserCount(role);
        count = count/10 + 1;
        res = adminMapper.GetUser(role, page);

        if(res != null){
            map.put("userlist", res);
            map.put("count", count);
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 重置密码
     * @param username
     * @param role
     * @return
     */
    @Override
    public Map<String, Object> ResetPassword(String username, int role) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;

        String pwd = Sha256.getSHA256StrJava(username + "12345678");
        res = adminMapper.ResetPassword(username,pwd,role);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 删除角色
     * @param username
     * @param role
     * @return
     */
    @Override
    public Map<String, Object> DeleteUser(String username, int role) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;
        res = adminMapper.DeleteUser(username, role);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 创建编辑和审稿人
     * @param user
     * @param role
     * @return
     */
    @Override
    public Map<String, Object> CreateUser(JSONObject user, int role) {
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        switch (role){
            case 2:
                Integer a;
                Editor editor1 = JSONObject.toJavaObject(user,Editor.class);
                Integer q = adminMapper.IsUserExist(editor1.getUsername(),role);
                if (q == null) {
                    a = adminMapper.CreateUser(editor1, role);
                    if (a != null) {
                        result = 1;
                    }
                }else {
                    map.put("error", "账号已经存在");
                }
                break;
            case 3:
                Integer b;
                Editor editor2 = JSONObject.toJavaObject(user,Editor.class);
                Integer w = adminMapper.IsUserExist(editor2.getUsername(),role);
                if (w == null) {
                    b = adminMapper.CreateUser(editor2, role);
                    if (b != null) {
                        result = 1;
                    }
                }else {
                    map.put("error", "账号已经存在");
                }
                break;
            case 4:
                Integer c;
                Professor professor = JSONObject.toJavaObject(user,Professor.class);
                Integer e = adminMapper.IsUserExist(professor.getUsername(),role);
                if (e == null) {
                    c = adminMapper.CreateUser(professor, role);
                    if (c != null) {
                        result = 1;
                    }
                }else {
                    map.put("error", "账号已经存在");
                }
            default:
                break;
        }

        map.put("result",result);
        return map;
    }

    /**
     * 创建学术领域
     * @param academicsec
     * @return
     */
    @Override
    public Map<String, Object> CreateAcademicsec(String academicsec) {
        Map<String, Object> map = new HashMap<>();
        Integer res = null;
        int result = 0;

        Integer ad = adminMapper.SelectAcademicsec(academicsec);
        if(ad == null) {
            res = adminMapper.CreateAcademicsec(academicsec);
        }else {
            map.put("error","已有此学术领域");
        }

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 更新学术领域
     * @param academicsec
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> UpdateAcademicsec(String academicsec, int id) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;
        res = adminMapper.UpdateAcademicsec(academicsec,id);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 创建栏目
     * @param column
     * @return
     */
    @Override
    public Map<String, Object> CreateColumn(String column) {
        Map<String, Object> map = new HashMap<>();
        Integer res = null;
        int result = 0;

        Integer co = adminMapper.SelectColumn(column);
        if (co == null) {
            res = adminMapper.CreateColumn(column);
        }else{
            map.put("error","已有此栏目");
        }

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 更新栏目
     * @param column
     * @return
     */
    @Override
    public Map<String, Object> UpdateColumn(String column, int id) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;
        res = adminMapper.UpdateColumn(column,id);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 得到报刊制式，审稿费，版面费以及默认文章数
     * @return
     */
    @Override
    public Map<String, Object> GetStandardList() {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> res;
        int result = 0;

        res = adminMapper.GetStandardList();

        if(res != null){
            result = 1;
            map.put("standardlist",res);
            Calendar a=Calendar.getInstance();
            int thisyear = a.get(Calendar.YEAR);
            map.put("year",thisyear);
        }
        map.put("result", result);
        return map;
    }


    /**
     * 更新或生成报刊制式，审稿费，版面费以及默认文章数
     * @param year
     * @param standard
     * @param reviewfee
     * @param pagecharges
     * @return
     */
    @Override
    public Map<String, Object> UpdateStandard(int year,int standard,int reviewfee,int pagecharges,int articlenum) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;
        Calendar a=Calendar.getInstance();
        int thisyear = a.get(Calendar.YEAR);

        if(year == thisyear && standard != 0){
            map.put("result", result);
            map.put("error", "不能修改今年的期刊制式");
        }

        Map<String, Object> oldone = adminMapper.GetStandard(year -1 );
        Map<String, Object> thisone = adminMapper.GetStandard(year);
        if(thisone != null) {//即需更新最大文章数，content需修改。
            Standard standard1= JSON.parseObject((String) thisone.get("content"),Standard.class);
            Date date[] = standard1.getDdl();
            int num[] = standard1.getNum();
            for(int i=0;i<date.length;i++){
                if(date[i].after(new Date())){
                    num[i] = articlenum;
                }
            }
            String cont= JSON.toJSONString(standard1);
            res = adminMapper.UpdateStandard(year, standard, reviewfee, pagecharges, articlenum, cont);
        }else {
            String admin = (String) oldone.get("admin");
            String password = (String) oldone.get("password");
            int oldstandard = (int) oldone.get("standard");
            if(oldstandard == standard) {
                Standard standard2= JSON.parseObject((String) oldone.get("content"),Standard.class);
                Date date2[] = standard2.getDdl();
                int num2[] = standard2.getNum();
                for(int i=0;i<date2.length;i++){
                    num2[i] = articlenum;
                }
                standard2.setNum(num2);
                standard2.setDdl(date2);
                String content2= JSON.toJSONString(standard2);
                res = adminMapper.InsertStandard(year, standard, reviewfee, pagecharges, articlenum, admin, password, content2);
            }else {
                Standard abc = new Standard();
                int newnum[] = new int[standard];
                Date newddl[] = new Date[standard];
                for(int i=0;i<standard;i++){
                    newnum[i]=0;
                    newddl[i] = new Date();
                }
                abc.setDdl(newddl);
                abc.setNum(newnum);
                String content= JSON.toJSONString(abc);
                res = adminMapper.InsertStandard(year, standard, reviewfee, pagecharges, articlenum, admin, password, content);
            }
        }

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 得到某卷的期数以及每一期对应文章数
     * @return
     */
    @Override
    public Map<String, Object> GetContent(int year) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> res;
        int result = 0;

        res = adminMapper.GetContent(year);

        if(res != null){
            Standard standard= JSON.parseObject((String) res.get("content"),Standard.class);
            Date a[] = standard.getDdl();
            int b[] = standard.getNum();
            result = 1;
            map.put("ddl",a);
            map.put("num",b);
        }
        map.put("result", result);
        return map;
    }

    /**
     * 更新某年期数对应文章数
     * @param year
     * @param which
     * @param date
     * @param num
     * @return
     */
    @Override
    public Map<String, Object> UpdateContent(int year, int which, Date date, int num) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> content;
        Integer res;
        int result = 0;
        content = adminMapper.GetContent(year);

        Standard standard= JSON.parseObject((String) content.get("content"),Standard.class);
        Date a[] = standard.getDdl();
        int b[] = standard.getNum();
        a[which-1] = date;
        b[which-1] = num;
        standard.setDdl(a);
        standard.setNum(b);
        String cont= JSON.toJSONString(standard);
        Map<String, Object> q = adminMapper.GetStandard(year);
        res = adminMapper.UpdateContent(year,cont);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 定时任务，1月1日生成新纪录
     * @return
     */
    @Override
    public void InsertInfo() {
        Integer res = null;
        int result = 0;
        Map<String, Object> map = new HashMap<>();
        Calendar a=Calendar.getInstance();
        int thisyear = a.get(Calendar.YEAR);
        Map<String, Object> oldone = adminMapper.GetStandard(thisyear-1);

        if(oldone != null) {
            int standard = (int) oldone.get("standard");
            int reviewfee = (int) oldone.get("reviewfee");
            int pagecharges = (int) oldone.get("pagecharges");
            int articlenum = (int) oldone.get("articlenum");
            String admin = (String) oldone.get("admin");
            String password = (String) oldone.get("password");
            String content1 = (String) oldone.get("content");
            res = adminMapper.InsertStandard(thisyear, standard, reviewfee, pagecharges, articlenum, admin, password, content1);
        }

        if(res != null){
            result = 1;
        }
        map.put("result", result);
    }

    @Override
    public void ClearSrc(){
        String anpath = "./file/AnnouncementAnnexes";
        String anpicpath = "./file/AnnouncementPic";
        List<String> file_pic = getAllFile(anpicpath,false);
        List<String> file_atta = getAllFile(anpath,false);
        List<String> data_pic = new ArrayList<String>();
        List<String> data_atta = new ArrayList<String>();
        List<HashMap<String, Object>> piclist = adminMapper.GetAnnouncementInfoList(1);
        List<HashMap<String, Object>> attalist = adminMapper.GetAnnouncementInfoList(2);

        //得到数据库公告图片列表
        for(HashMap<String, Object> hashMap: piclist){
            String thepic = (String) hashMap.get("pic");
            if (thepic != null) {
                String[] thepiclist = thepic.split("\\|");
                data_pic.addAll(Arrays.asList(thepiclist));
            }
        }
        //得到数据库公告附件列表
        for(HashMap<String, Object> hashMap: attalist){
            String theatta = (String) hashMap.get("upload");
            if (theatta != null){
                data_atta.add(theatta);
            }
        }

        for (String string: file_pic) {
            if (!data_pic.contains(string)){
                File file = new File(anpicpath,string);
                if (file.exists()){
                    file.delete();
                }
            }
        }
        for (String string: file_atta) {
            if (!data_atta.contains(string)){
                File file = new File(anpath,string);
                if (file.exists()){
                    file.delete();
                }
            }
        }
    }

    private static List<String> getAllFile(String directoryPath, boolean isAddDirectory) {
        List<String> list = new ArrayList<String>();
        File baseFile = new File(directoryPath);
        if (baseFile.isFile() || !baseFile.exists()) {
            return list;
        }
        File[] files = baseFile.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (isAddDirectory) {
                        list.add(file.getAbsolutePath());
                    }
                    list.addAll(getAllFile(file.getAbsolutePath(), isAddDirectory));
                } else {
                    list.add(file.getName());
                }
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> InsertMain(String name, String content, int priority, int alive) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;

        res = adminMapper.InsertMain(name,content,priority,alive);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    @Override
    public Map<String, Object> UpdateMain(int id, String name, String content, int priority, int alive) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;

        res = adminMapper.UpdateMain(id,name,content,priority,alive);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    @Override
    public Map<String, Object> DeleteMain(int id) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;

        res = adminMapper.DeleteMain(id);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    @Override
    public Map<String, Object> CreateInfoCenter(String name, String content, int priority, int alive) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;

        res = adminMapper.CreateInfoCenter(name,content,priority,alive,new Date());

        if(res != null){
            result = 1;
        }else {
            File file = new File(FileController.infocenterpath,name);
            if (file.exists()) {
                file.delete();
            }
        }
        map.put("result", result);
        return map;
    }

    @Override
    public Map<String, Object> UpdateInfoCenter(int id, String name, String content, int priority, int alive) {
        Map<String, Object> map = new HashMap<>();
        List<HashMap<String, Object>> list;
        Integer res;
        int result = 0;

        list = commonMapper.GetInfoCenterList();
        HashMap a = list.get(id-1);
        File file = new File(FileController.infocenterpath, (String) a.get("content"));
        if (file.exists()){
            file.delete();
        }

        res = adminMapper.UpdateInfoCenter(id,name,content,priority,alive);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    @Override
    public Map<String, Object> DeleteInfoCenter(int id) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;

        res = adminMapper.DeleteInfoCenter(id);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

/**
*lfx
*/
    /**
     * 插入一条新的友情链接
     * @param link
     * @return
     */
    @Override
    public Map<String, Object> InsertLink(FriendLink link) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;

        res = adminMapper.InsertLink(link);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 更新友情链接
     * @param link
     * @return
     */
    @Override
    public Map<String, Object> UpdateLink(FriendLink link) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;

        res = adminMapper.UpdateLink(link);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 删除友情链接
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> DeleteLink(int id) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;

        res = adminMapper.DeleteLink(id);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    /**
     * 得到友情链接
     * @param page
     * @return
     */
    @Override
    public Map<String, Object> SearchLink(int page) {

        Map<String, Object> map = new HashMap<>();
        int result = 0;

        int count = adminMapper.GetLinkCount();
        PageBean pageBean = new PageBean(page,count);
        List<HashMap<String, Object>> list = adminMapper.SearchLink(pageBean.getStartIndex());
        pageBean.setRows(list);

        if (list != null) {
            map.put("pageBean", pageBean);
            result = 1;
        }

        map.put("result",result);
        return map;
    }

    /**
     * 通过条件来对用户进行分页
     * @param userCondition
     * @return
     */
    @Override
    public Map<String, Object> SearchUser(UserCondition userCondition) {

        Map<String, Object> map = new HashMap<>();
        int result = 0;

        int count = adminMapper.SearchUserCount(userCondition);
        PageBean pageBean = new PageBean(userCondition.getPage(),count);
        List<HashMap<String, Object>> list = adminMapper.SearchUser(userCondition, pageBean.getStartIndex());
        pageBean.setRows(list);
        if (list != null) {
            map.put("pageBean", pageBean);
            result = 1;
        }

        map.put("result",result);
        return map;
    }

    @Override
    public Map<String, Object> GetAcademicsec(int page) {
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        int count = adminMapper.GetAcademicsecCount();
        PageBean pageBean = new PageBean(page,count);
        List<HashMap<String, Object>> list = adminMapper.GetAcademicsec(pageBean.getStartIndex());
        pageBean.setRows(list);
        if (list != null) {
            map.put("pageBean", pageBean);
            result = 1;
        }

        map.put("result",result);
        return map;
    }

    @Override
    public Map<String, Object> DeleteAcademicsec(int id) {
        Map<String, Object> map = new HashMap<>();
        int result = 0;
        int num = adminMapper.DeleteAcademicsec(id);

        if (num == 1) {
            result = 1;
            map.put("result",result);
            return map;
        }
        map.put("result",result);
        return map;
    }

    @Override
    public Map<String, Object> InsertCertificate(Certificate certificate) {

        certificate.setDate_pub(new Date());
        certificate.setAlive(1);
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;

        res = adminMapper.InsertCertificate(certificate);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    @Override
    public Map<String, Object> UpdateCertificate(Certificate certificate) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;

        res = adminMapper.UpdateCertificate(certificate);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    @Override
    public Map<String, Object> DeleteCertificate(int id) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;

        res = adminMapper.DeleteCertificate(id);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    @Override
    public Map<String, Object> SearchCertificate(int page) {
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        int count = adminMapper.GetCertificateCount();
        PageBean pageBean = new PageBean(page,count);
        List<HashMap<String, Object>> list = adminMapper.SearchCertificate(pageBean.getStartIndex());
        pageBean.setRows(list);
        if (list != null) {
            map.put("pageBean", pageBean);
            result = 1;
        }

        map.put("result",result);
        return map;
    }

    @Override
    public Map<String, Object> UpdateCertificateAlive(int id, int alive) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;

        res = adminMapper.UpdateCertificateAlive(id,alive);

        if(res != null){
            result = 1;
        }
        map.put("result", result);
        return map;
    }

    @Override
    public Map<String, Object> GetAnnouncement(String title, int page) {

        Map<String, Object> map = new HashMap<>();
        int result = 0;

        int count = adminMapper.SearchAnnouncementCount(title);
        PageBean pageBean = new PageBean(page, count);
        List<HashMap<String, Object>> list = adminMapper.SearchAnnouncement(title,pageBean.getStartIndex());
        pageBean.setRows(list);
        if (list != null) {
            map.put("pageBean", pageBean);
            result = 1;
        }

        map.put("result",result);
        return map;
    }

    @Override
    public Map<String, Object> GetAnnouncement(int id) {
        Map<String, Object> map = new HashMap<>();
        int result = 0;

        HashMap announcement = (HashMap) adminMapper.GetAnnouncement(id);

        if (announcement != null) {
            result = 1;
            map.put("announcement",announcement);
        }

        map.put("result",result);
        return map;
    }

    @Override
    public Map<String, Object> UpdateAnnouncement(Announcement announcement) {
        Map<String, Object> map = new HashMap<>();
        Integer res;
        int result = 0;
        res = adminMapper.UpdateAnnouncement(announcement);

        //判断是否写入数据库，没成功则删除上传的附件
        if(res != null){
            result = 1;
        }else {
            File file = new File(FileController.anattapath,announcement.getUpload());
            if (file.exists()) {
                file.delete();
            }
        }
        map.put("result", result);
        return map;
    }

/**
 * lfx
 */

}
