package com.example.newsroom.controller;


import com.alibaba.fastjson.JSON;
import com.example.newsroom.entity.*;
import com.example.newsroom.service.ContributeService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/contribute")
public class ContributeController {
    @Autowired
    ContributeService contributeService;

    /**
     *
     * @param _all
     * @param file1
     * @param file2
     * @param session
     * @return
     */
    @PostMapping(value = "/upload_allocate")
    public Object upload_allocate_Article(@RequestParam(value = "all") String _all, @RequestParam(value = "file1") MultipartFile file1, @RequestParam(value = "file2") MultipartFile file2, HttpSession session){
        All all = JSON.parseObject(_all,All.class);
        Article article = all.getArticle();
        article.setDate_sub(new Date());
        if(article != null){
            article.setWriter_id((int)session.getAttribute("id"));
        }
        Task task = all.getTask();
        if(task != null){
            task.setId_role((int)session.getAttribute("id"));
            task.setRole((int)session.getAttribute("role"));
        }
        Map<String,Object> map = new HashMap<>();
        Integer result = 1;
        String data = null;
        String filename = new String();
        String[] format = new String[2];
        if(task == null){//第一次投稿
            result = contributeService.uploadArticleInfo(article);
            if(result != null && result == 1){
                task = new Task();
                task.setId_article(article.getId());
                task.setId_role(contributeService.getEditorByAcadamic(article.getAcademicsec()));
                task.setRole(3);
                task.setStat(0);
                task.setFlag(0);
                task.setDate(new Date());
                result = contributeService.createTask(task);
                if(result != null && result == 1){
                    data = "";
                }
                else{
                    result = 0;
                    data = "Insert Failed";
                }
            }
            else{
                result = 0;
                data = "Upload Failed";
            }
        }
        else{//修改后再投递
            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,null);
            if(result != null && result == 1){
                task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),3).get(0));
                task.setContent(null);
                task.setStat(7);
                task.setRole(3);
                task.setDate(new Date());
                result = contributeService.createTask(task);
                if(result != null && result == 1){
                    data = "";
                }
                else{
                    result = 0;
                    data = "Insert Failed";
                }
            }
            else{
                result = 0;
                data = "Update Failed";
            }
        }
        if(result != null && result == 1 && article != null){//第一次投稿
            filename = String.valueOf(article.getId());
            format = article.getFormat().split(";");
            result = upload(file1,filename);
            if(result != null && result == 1){
                if(format.length == 2){
                    result = upload(file2,filename);
                    if(result != null && result == 1){
                        data = "";
                    }
                    else{
                        data = "Mkdir Failed";
                        result = contributeService.deleteArticleInfo(article.getId());
                        if(result == null){
                            data += "&Delete Failed";
                        }
                        result = 0;
                    }
                }
            }
            else{
                data = "Mkdir Failed";
                result = contributeService.deleteArticleInfo(article.getId());
                if(result == null){
                    data += "&Delete Failed";
                }
                result = 0;
            }
        }
        else if(result != null && result == 1 && task != null){//修改后再投递
            article = contributeService.getArticleById(task.getId_article());
            filename = String.valueOf(article.getId());
            format = article.getFormat().split(";");
            int index = file1.getOriginalFilename().lastIndexOf(".");
            String _format = file1.getOriginalFilename().substring(index);
            result = upload(file1,filename);
            if(result != null && result == 1){
                data = "";
            }
            else{
                result = 0;
                data = "Mkdir Failed";
            }
            if(result != null && result == 1 && format[0] != _format){
                format[0] = _format;
                result = contributeService.updateArticleInfo(article.getId(),format[0] + ";" + format[1],null,0);
                if(result != null && result == 1){
                    data = "";
                }
                else{
                    result = 0;
                    data = "Update Failed";
                }
            }
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

//    /**
//     *
//     * @param _all
//     * @param file1
//     * @param file2
//     * @param session
//     * @return
//     */
//    @PostMapping(value = "/upload")
//    public Object uploadFile(@RequestParam(value = "all") String _all, @RequestParam(value = "file1") MultipartFile file1, @RequestParam(value = "file2") MultipartFile file2, HttpSession session){
//        All all = JSON.parseObject(_all,All.class);
//        Article article = all.getArticle();
//        article.setDate_sub(new Date());
//        if(article != null){
//            article.setWriter_id((int)session.getAttribute("id"));
//        }
//        Task task = all.getTask();
//        if(task != null){
//            task.setId_role((int)session.getAttribute("id"));
//            task.setRole((int)session.getAttribute("role"));
//        }
//        Map<String,Object> map = new HashMap<>();
//        Integer result = 1;
//        String data = null;
//        String filename = new String();
//        String[] format = new String[2];
//        if(task == null){//第一次投稿
//            result = contributeService.uploadArticleInfo(article);
//            if(result != null && result == 1){
//                task = new Task();
//                task.setId_article(article.getId());
//                task.setId_role(1);
//                task.setRole(2);
//                task.setStat(0);
//                task.setFlag(0);
//                task.setDate(new Date());
//                result = contributeService.createTask(task);
//                if(result != null && result == 1){
//                    data = "";
//                }
//                else{
//                    result = 0;
//                    data = "Insert Failed";
//                }
//            }
//            else{
//                result = 0;
//                data = "Upload Failed";
//            }
//        }
//        else{//修改后再投递
//            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,null);
//            if(result != null && result == 1){
//                task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),3).get(0));
//                task.setContent(null);
//                task.setStat(7);
//                task.setRole(3);
//                task.setDate(new Date());
//                result = contributeService.createTask(task);
//                if(result != null && result == 1){
//                    data = "";
//                }
//                else{
//                    result = 0;
//                    data = "Insert Failed";
//                }
//            }
//            else{
//                result = 0;
//                data = "Update Failed";
//            }
//        }
//        if(result != null && result == 1 && article != null){//第一次投稿
//            filename = String.valueOf(article.getId());
//            format = article.getFormat().split(";");
//            result = upload(file1,filename);
//            if(result != null && result == 1){
//                if(format.length == 2){
//                    result = upload(file2,filename);
//                    if(result != null && result == 1){
//                        data = "";
//                    }
//                    else{
//                        data = "Mkdir Failed";
//                        result = contributeService.deleteArticleInfo(article.getId());
//                        if(result == null){
//                            data += "&Delete Failed";
//                        }
//                        result = 0;
//                    }
//                }
//            }
//            else{
//                data = "Mkdir Failed";
//                result = contributeService.deleteArticleInfo(article.getId());
//                if(result == null){
//                    data += "&Delete Failed";
//                }
//                result = 0;
//            }
//        }
//        else if(result != null && result == 1 && task != null){//修改后再投递
//            article = contributeService.getArticleById(task.getId_article());
//            filename = String.valueOf(article.getId());
//            format = article.getFormat().split(";");
//            int index = file1.getOriginalFilename().lastIndexOf(".");
//            String _format = file1.getOriginalFilename().substring(index);
//            result = upload(file1,filename);
//            if(result != null && result == 1){
//                data = "";
//            }
//            else{
//                result = 0;
//                data = "Mkdir Failed";
//            }
//            if(result != null && result == 1 && format[0] != _format){
//                format[0] = _format;
//                result = contributeService.updateArticleInfo(article.getId(),format[0] + ";" + format[1],null,0);
//                if(result != null && result == 1){
//                    data = "";
//                }
//                else{
//                    result = 0;
//                    data = "Update Failed";
//                }
//            }
//        }
//        map.put("result",result);
//        map.put("data",data);
//        return map;
//    }

    /**
     *
     * @param id
     * @param request
     * @param response
     * @param session
     * @return
     */
    @GetMapping(value = "/download/id={id}&type={type}")
    public Object downloadFile(@PathVariable(value = "id") int id, @PathVariable(value = "type") int type, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        Task task = contributeService.getTaskById(id);
        task.setId_role((int)session.getAttribute("id"));
        task.setRole((int)session.getAttribute("role"));
        Map<String,Object> map = new HashMap<>();
        Integer result = 1;
        String data = new String();
        String filename = new String();
        Article article = contributeService.getArticleById(task.getId_article());
        if(task.getStat() == 6 && type == 2){
            List<Invoice> _invoice = contributeService.getInvoiceByArticleId(task.getId_article());
            Invoice invoice;
            if(task.getContent() == null){
                invoice = _invoice.get(0);
            }
            else{
                invoice = _invoice.get(1);
            }
            filename = invoice.getId() + invoice.getFormat();
            result = download(filename,request,response);
            if(result == 1){
                data = "";
            }
            else{
                result = 0;
                data = "Mkdir Failed";
            }
        }
        else if(type == 0 || type == 1){
            String[] format = article.getFormat().split(";");
            filename = article.getId() + format[type];
            result = download(filename,request,response);
            if(result != 1){
                result = 0;
                data = "Mkdir Failed";
            }
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @param session
     * @return
     */
    @PostMapping(value = "/task")
    public Object getTask(@RequestBody All all,HttpSession session){
        int id_role = (int)session.getAttribute("id");
        int role = (int)session.getAttribute("role");
        int stat = all.getStat();
        int flag = all.getFlag();
        int page = all.getPage();
        Map<String,Object> map = new HashMap<>();
        Integer result = 1;
        Map<String,Object> data = new HashMap<>();
        List<Task> task = new ArrayList<>();
        Integer total = 0;
        List<Article> article = new ArrayList<>();
        List<Invoice> invoice  = new ArrayList<>();
        Set<List<List<Integer>>> professor = new HashSet<>();
        List<List<Integer>> editor = new ArrayList<>();
        Set<Integer> articleset = new HashSet<>();
        if(role == 1 && flag == 1){
            articleset = contributeService.getArticleIdByWriterId(id_role);
        }
        else{
            task = contributeService.getTask(0,id_role,role,stat,flag,page);
            for(int i = 0;i < task.size();i++){
                articleset.add(task.get(i).getId_article());
                if(role == 3){
                    List<List<Integer>> p = new ArrayList<>();
                    p.add(contributeService.getRoleIdByTask(task.get(i).getId_article(),4));
                    int l = p.get(0).size();
                    for(int j = 0;j < l;j++){
                        List<Task> t = contributeService.getTask(0,p.get(0).get(j),4,-1,1,page);
                        p.add(new ArrayList<>());
                        for(int k = 0;k < t.size();k++){
                            p.get(j + 1).add(t.get(k).getFlag());
                        }
                    }
                    p.add(new ArrayList<>());
                    p.get(l + 1).add(task.get(i).getId_article());
                    professor.add(p);
                }
            }
            if(flag == 1){
                task.clear();
            }
        }
        Integer[] _articleset = articleset.toArray(new Integer[articleset.size()]);
        Arrays.sort(_articleset,Collections.reverseOrder());
        for(int i = 0;i + (page - 1) * 10 < articleset.size() && i + (page - 1) * 10 < page * 10;i++){
            article.add(contributeService.getArticleById(_articleset[i + (page - 1) * 10]));
            if(flag == 1){
                List<Task> _task = contributeService.getTask(_articleset[i + (page - 1) * 10],id_role,role,stat,flag,page);
                if(!_task.isEmpty()){
                    task.add(_task.get(0));
                }
                if(role == 2){
                    List<Integer> e = contributeService.getRoleIdByTask(task.get(i).getId_article(),3);
                    if(e.size() != 0){
                        int j = 0;
                        while(e.get(j) == 1 && j < e.size()){
                            j++;
                        }
                        j = e.get(j);
                        e.clear();
                        e.add(j);
                        e.add(task.get(i).getId());
                        editor.add(e);
                    }
                }
            }
        }
        for(int i = 0;i < article.size();i++){
            List<Invoice> in = contributeService.getInvoiceByArticleId(article.get(i).getId());
            for(int j = 0;j < in.size();j++){
                invoice.add(in.get(j));
            }
        }
        if(role == 2){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String _begin = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-1-1 00:00:00";
            try {
                Date begin = sdf.parse(_begin);
                Standard standard = JSON.parseObject(contributeService.getStandard(Integer.valueOf(Calendar.getInstance().get(Calendar.YEAR))),Standard.class);
                Integer[] schedule = new Integer[standard.getDdl().length];
                for(int i = 0;i < standard.getDdl().length;i++){
                    if(i < 1){
                        schedule[i] = contributeService.getCountByDatePub(begin,standard.getDdl()[i]);
                    }
                    else{
                        schedule[i] = contributeService.getCountByDatePub(standard.getDdl()[i - 1],standard.getDdl()[i]);
                    }
                }
                data.put("schedule",schedule);
                data.put("standard",standard);
            }
            catch (Exception e){
                result = 0;
            }
        }
        total = page + task.size() / 10;
        data.put("task",task);
        data.put("article",article);
        data.put("invoice",invoice);
        if(role == 2){
            data.put("editor",editor);
        }
        else if(role == 3){
            data.put("professor",professor);
        }
        data.put("total",total);
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @param session
     * @return
     */
    @PostMapping(value = "/task/resource")
    public Object getResource(@RequestBody All all, HttpSession session){
        Resource resource = all.getResource();
        Map<String,Object> map = new HashMap<>();
        Integer result = 1;
        List<Map<String,Object>> data = null;
        data = contributeService.getAllByTable(resource.getFunc());
        if(all.getResource().getFunc().equals("editors") || all.getResource().getFunc().equals("professors")){
            for(int i = 0;i < data.size();i++){
                data.get(i).remove("password");
                data.get(i).remove("safeque1");
                data.get(i).remove("safeque2");
                data.get(i).remove("safeque3");
            }
        }
        else if(all.getResource().getFunc().equals("newsroominfo")){
            for(int i = 0;i < data.size();i++){
                data.get(i).remove("admin");
                data.get(i).remove("password");
                if(Integer.valueOf(data.get(i).get("year").toString()) > (Integer.valueOf(Calendar.getInstance().get(Calendar.YEAR)))){
                    data.remove(i);
                }
            }
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

//    /**
//     *
//     * @param all
//     * @param session
//     * @return
//     */
//    @PostMapping(value = "/task/allocate")
//    public Object allocateArticle(@RequestBody All all, HttpSession session){
//        Task task = all.getTask();
//        task.setId_role((int)session.getAttribute("id"));
//        task.setRole((int)session.getAttribute("role"));
//        int id_role = all.getId_role()[0];
//        Map<String,Object> map = new HashMap<>();
//        Integer result = 0;
//        String data = null;
//        result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,null);
//        if(result != null && result == 1){
//            task.setId_role(id_role);
//            task.setRole(3);
//            task.setDate(new Date());
//            result = contributeService.createTask(task);
//            if(result != null && result == 1){
//                data = "";
//            }
//            else{
//                result = 0;
//                data = "Insert Failed";
//            }
//        }
//        else{
//            result = 0;
//            data = "Update Failed";
//        }
//        map.put("result",result);
//        map.put("data",data);
//        return map;
//    }

    /**
     *
     * @param all
     * @param session
     * @return
     */
    @PostMapping(value = "/task/judge")
    public Object judgeArticle(@RequestBody All all, HttpSession session) {
        Task task = all.getTask();
        //task.setId_role((int)session.getAttribute("id"));
        //task.setRole((int)session.getAttribute("role"));
        int[] id_role = all.getId_role();
        Map<String, Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        //result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,null);
        if(task.getStat() == 0){//初审通过
            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,null);
            task.setStat(4);
            task.setDate(new Date());
            contributeService.createTask(task);
        }
        else if(task.getContent() != null){//审稿人提交审稿意见
            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,new Date());
            if(result != null && result == 1){
                data = "";
                result = contributeService.checkTaskLink(task.getId_article(),-1, 0,0);
                if(result == 0){//所有审稿人完成审稿
                    task.setId_role(contributeService.getRoleIdByTask(task.getId_article(), task.getRole()).get(0));
                    String content  = new String();
                    List<Integer> professors = contributeService.getRoleIdByTask(task.getId_article(),4);
                    for(int i = 0;i < professors.size();i++){
                        content += professors.get(i) + ":" + contributeService.getContentByRoleId(professors.get(i)) + ";";
                    }
                    task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),3).get(0));
                    result = contributeService.checkTaskLink(task.getId_article(),1, 3,1);
                    if(result != 0){
                        task.setStat(7);
                    }
                    else{
                        task.setStat(1);
                    }
                    task.setRole(3);
                    task.setContent(content);
                    task.setDate(new Date());
                    result = contributeService.createTask(task);
                    if(result != null && result == 1){
                        data = "";
                    }
                    else{
                        result = 0;
                        data = "Insert Failed";
                    }
                }
                else{
                    result = 1;
                }
            }
            else{
                result = 0;
                data = "Insert Failed";
            }
        }
        else if(task.getStat() == 1){//首审稿件分配
            if(task.getRole() == 3){
                task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),3).get(0));
            }
            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),0,new Date());
        }
        else if(task.getStat() == 7){//重审稿件分配
            for(int i = 0;i < id_role.length;i++){
                task.setId_role(id_role[i]);
                task.setRole(4);
                task.setDate(new Date());
                result = contributeService.createTask(task);
                if(result == null || result != 1){
                    i = id_role.length;
                    result = 0;
                    data = "Insert Failed";
                }
            }
        }
        else if(task.getStat() == 2){
            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,null);
            if(result != null && result == 1){
                task.setId_role(contributeService.getArticleById(task.getId_article()).getWriter_id());
                task.setRole(1);
                task.setDate(new Date());
                result = contributeService.createTask(task);
            }
            if(result != null && result == 1){
                data = "";
            }
            else{
                result = 0;
                data = "Insert Failed";
            }
        }
        if(result != null && result == 1){

        }
        else{
            result = 0;
            data = "Update Failed";
        }
        map.put("result", result);
        map.put("data", data);
        return map;
    }

//    /**
//     *
//     * @param all
//     * @param session
//     * @return
//     */
//    @PostMapping(value = "/task/judge")
//    public Object judgeArticle(@RequestBody All all, HttpSession session) {
//        Task task = all.getTask();
//        task.setId_role((int)session.getAttribute("id"));
//        task.setRole((int)session.getAttribute("role"));
//        int[] id_role = all.getId_role();
//        Map<String, Object> map = new HashMap<>();
//        Integer result = 0;
//        String data = null;
//        result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,null);
//        if(result != null && result == 1){
//            if(task.getStat() == 0){//初审通过
//                task.setStat(4);
//                task.setDate(new Date());
//                contributeService.createTask(task);
//            }
//            else if(task.getContent() != null){//审稿人提交审稿意见
//                result = contributeService.getCountByArticleId(task.getId_article());
//                if(result % 3 == 0){
//                    task.setId_role(contributeService.getRoleIdByTask(task.getId_article(), task.getRole()).get(0));
//                    String content  = new String();
//                    List<Integer> professors = contributeService.getRoleIdByTask(task.getId_article(),4);
//                    for(int i = 0;i < professors.size();i++){
//                        content += professors.get(i) + ":" + contributeService.getContentByRoleId(professors.get(i)) + ";";
//                    }
//                    task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),3).get(0));
//                    if(result % 6 == 0){
//                        task.setStat(7);
//                    }
//                    else{
//                        task.setStat(1);
//                    }
//                    task.setRole(3);
//                    task.setContent(content);
//                    task.setDate(new Date());
//                    result = contributeService.createTask(task);
//                    if(result != null && result == 1){
//                        data = "";
//                    }
//                    else{
//                        result = 0;
//                        data = "Insert Failed";
//                    }
//                }
//                else{
//                    result = 1;
//                }
//            }
//            else if(task.getStat() == 1 || task.getStat() == 7){//稿件分配
//                for(int i = 0;i < id_role.length;i++){
//                    task.setId_role(id_role[i]);
//                    task.setRole(4);
//                    task.setDate(new Date());
//                    result = contributeService.createTask(task);
//                    if(result == null || result != 1){
//                        i = id_role.length;
//                        result = 0;
//                        data = "Insert Failed";
//                    }
//                }
//            }
//            else if(task.getStat() == 2){
//                task.setId_role(contributeService.getArticleById(task.getId_article()).getWriter_id());
//                task.setRole(1);
//                task.setDate(new Date());
//                result = contributeService.createTask(task);
//                if(result != null && result == 1){
//                    data = "";
//                }
//                else{
//                    result = 0;
//                    data = "Insert Failed";
//                }
//            }
//        }
//        else{
//            result = 0;
//            data = "Update Failed";
//        }
//        map.put("result", result);
//        map.put("data", data);
//        return map;
//    }

    /**
     *
     * @param all
     * @param session
     * @return
     */
    @PostMapping(value = "/task/manage")
    public Object manageInvoice(@RequestBody All all, HttpSession session){
        Task task = all.getTask();
        task.setId_role((int)session.getAttribute("id"));
        task.setRole((int)session.getAttribute("role"));
        Invoice invoice = all.getInvoice();
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,null);
        if(result != null && result == 1){
            data = "";
            invoice.setDate(new Date());
            result = contributeService.createInvoice(invoice);
            if(result != null && result == 1){
                data = "";
                task.setId_role(contributeService.getArticleById(task.getId_article()).getWriter_id());
                task.setStat(6);
                task.setRole(1);
                task.setDate(new Date());
                result = contributeService.createTask(task);
                if(result != null && result == 1){
                    data = "";
                }
                else{
                    result = 0;
                    data = "Insert Failed";
                }
            }
            else{
                result = 0;
                data = "Insert Failed";
            }
        }
        else{
            result = 0;
            data = "Update Failed";
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param file
     * @param _all
     * @param session
     * @return
     */
    @PostMapping(value = "/task/fill")
    public Object fillInvoice(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "all") String _all, HttpSession session){
        All all = JSON.parseObject(_all,All.class);
        Task task = all.getTask();
        task.setId_role((int)session.getAttribute("id"));
        task.setRole((int)session.getAttribute("role"));
        Invoice invoice = all.getInvoice();
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        result = contributeService.updateInvoice(invoice.getId(),invoice.getFlag(),invoice.getFormat(),invoice.getReceipt_title(),invoice.getReceipt_num(),invoice.getAddress(),invoice.getReceiver());
        if(result != null && result == 1){
            task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),3).get(0));
            task.setRole(3);
            task.setDate(new Date());
            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),0,task.getDate());
            if(result != null && result == 1){
                data = "";
                String filename = String.valueOf(invoice.getId());
                result = upload(file,filename);
                if(result != null && result == 1){
                    data = "";
                }
                else{
                    result = 0;
                    data = "Mkdir Failed";
                }
            }
            else{
                result = 0;
                data = "Update Failed";
            }
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @param session
     * @return
     */
    @PostMapping(value = "/task/check")
    public Object checkInvoice(@RequestBody All all, HttpSession session){
        Task task = all.getTask();
        int[] id_role = all.getId_role();
        task.setId_role((int)session.getAttribute("id"));
        task.setRole((int)session.getAttribute("role"));
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        if(task.getStat() == 6){
            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,null);
        }
        else{
            task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),1).get(0));
            task.setStat(6);
            task.setRole(1);
            task.setDate(new Date());
            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),0,task.getDate());
        }
        if(result != null && result == 1){
            data = "";
        }
        else{
            result = 0;
            data = "Update Failed";
        }
        if(task.getRole() == 3){
            if(task.getStat() == 6){
                if(task.getContent() == null){//审稿费审核通过
                    if(result == null || result == 1) {
                        for(int i = 0;i < id_role.length;i++){
                            task.setStat(1);
                            task.setDate(new Date());
                            result = contributeService.createTask(task);
                            if(result == null || result != 1){
                                i = id_role.length;
                            }
                        }
                    }
                }
                else{//版面费审核通过
                    task.setDate(new Date());
                    result = contributeService.createTask(task);
                }
                if(result != null && result == 1){
                    data = "";
                }
                else{
                    result = 0;
                    data = "Insert Failed";
                }
            }
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

//    /**
//     *
//     * @param all
//     * @param session
//     * @return
//     */
//    @PostMapping(value = "/task/check")
//    public Object checkInvoice(@RequestBody All all, HttpSession session){
//        Task task = all.getTask();
//        task.setId_role((int)session.getAttribute("id"));
//        task.setRole((int)session.getAttribute("role"));
//        Map<String,Object> map = new HashMap<>();
//        Integer result = 0;
//        String data = null;
//        if(task.getStat() == 6){
//            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,null);
//        }
//        else{
//            task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),1).get(0));
//            task.setStat(6);
//            task.setRole(1);
//            task.setDate(new Date());
//            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),0,task.getDate());
//        }
//        if(result != null && result == 1){
//            data = "";
//        }
//        else{
//            result = 0;
//            data = "Update Failed";
//        }
//        if(task.getRole() == 3){
//            if(task.getStat() == 6){
//                if(task.getContent() == null){//审稿费审核通过
//                    task.setStat(1);
//                }
//                else{//版面费审核通过
//                    task.setId_role(1);
//                    task.setRole(2);
//                }
//                task.setDate(new Date());
//                result = contributeService.createTask(task);
//                if(result != null && result == 1){
//                    data = "";
//                }
//                else{
//                    result = 0;
//                    data = "Insert Failed";
//                }
//            }
//        }
//        map.put("result",result);
//        map.put("data",data);
//        return map;
//    }

    /**
     *
     * @param all
     * @param session
     * @return
     */
    @PostMapping(value = "/task/analyze")
    public Object analyzeOpinion(@RequestBody All all, HttpSession session){
        Task task = all.getTask();
        task.setId_role((int)session.getAttribute("id"));
        task.setRole((int)session.getAttribute("role"));
        int stat = task.getStat();
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        Integer tmp = contributeService.getCountByArticleId(task.getId_article());
        if(task.getStat() == 4){
            task.setStat(1);
        }
        else if(task.getStat() == 5){
            if(tmp % 2 == 0 && tmp != 2){
                task.setStat(7);
            }
            else if(tmp % 2 != 0 || tmp == 2){
                task.setStat(1);
            }
        }
        result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,null);
        if(result != null && result == 1){
            if(stat == 3){
                task.setId_role(contributeService.getArticleById(task.getId_article()).getWriter_id());
                task.setRole(1);
                task.setDate(new Date());
                result = contributeService.createTask(task);
            }
            else if(stat == 4 || stat == 5){
                task.setStat(stat);
                task.setDate(new Date());
                result = contributeService.createTask(task);
            }
            else if(stat == 2){
                task.setId_role(contributeService.getArticleById(task.getId_article()).getWriter_id());
                task.setStat(stat);
                task.setDate(new Date());
                result = contributeService.createTask(task);
            }
            if(result != null && result == 1){
                data = "";
            }
            else{
                result = 0;
                data = "Update Failed";
            }
        }
        else{
            result = 0;
            data = "Insert Failed";
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param _all
     * @param session
     * @return
     */
    @PostMapping(value = "/task/design")
    public Object designArticle(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "all") String _all, HttpSession session){
        All all = JSON.parseObject(_all,All.class);
        Task task = all.getTask();
        task.setId_role((int)session.getAttribute("id"));
        task.setRole((int)session.getAttribute("role"));
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        Article article = contributeService.getArticleById(task.getId_article());
        String filename = article.getId() + "-" + article.getTitle();
        String[] format = article.getFormat().split(";");
        int index = file.getOriginalFilename().lastIndexOf(".");
        String _format = file.getOriginalFilename().substring(index);
        result = upload(file,filename);
        if(result != null && result == 1){
            data = "";
        }
        else{
            result = 0;
            data = "Mkdir Failed";
        }
        if(result != null && result == 1 && format[0] != _format){
            format[0] = _format;
            result = contributeService.updateArticleInfo(article.getId(),format[0] + ";" + format[1],null,0);
            if(result != null && result == 1){
                data = "";
            }
            else{
                result = 0;
                data = "Update Failed";
            }
        }
        if(result != null && result == 1){
            task.setId_role(contributeService.getArticleById(task.getId_article()).getWriter_id());
            task.setRole(1);
            task.setDate(new Date());
            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),0,task.getDate());
            if(result != null && result == 1){
                data = "";
            }
            else{
                result = 0;
                data = "Update Failed";
            }
        }
        else{
            result = 0;
            data = "Update Failed";
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @param session
     * @return
     */
    @PostMapping(value = "/notice")
    public Object noticeAuthor(@RequestBody All all, HttpSession session){
        Task task = all.getTask();
        task.setId_role((int)session.getAttribute("id"));
        task.setRole((int)session.getAttribute("role"));
        int stat = task.getStat();
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        if(stat == 2){
            task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),3).get(0));
            task.setStat(5);
            task.setRole(3);
            task.setDate(new Date());
            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),0,task.getDate());
        }
        else{
            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,null);
        }
        if(result != null && result == 1){
            data = "";
        }
        else{
            result = 0;
            data = "Update Failed";
        }
        if(stat == 5){
            task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),3).get(0));
            task.setStat(4);
            task.setRole(3);
            task.setDate(new Date());
            result = contributeService.createTask(task);
            if(result != null && result == 1){
                data = "";
            }
            else{
                result = 0;
                data = "Insert Failed";
            }
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

//    /**
//     *
//     * @param all
//     * @param session
//     * @return
//     */
//    @PostMapping(value = "/task/schedule")
//    public Object scheduleArticle(@RequestBody All all, HttpSession session){
//        Article article = all.getArticle();
//        Task task = all.getTask();
//        task.setId_role((int)session.getAttribute("id"));
//        task.setRole((int)session.getAttribute("role"));
//        Map<String,Object> map = new HashMap<>();
//        Integer result = 0;
//        String data = null;
//        result = contributeService.updateArticleInfo(task.getId_article(),null,article.getDate_pub(),article.getColumn());
//        if(result != null && result == 1){
//            data = "";
//            result = contributeService.updateTask(task.getId(),task.getId_role(),task.getContent(),task.getStat(),task.getRole(),1,null);
//            if(result == 1){
//                data = "";
//            }
//            else{
//                result = 0;
//                data = "Update Failed";
//            }
//        }
//        else{
//            result = 0;
//            data = "Update Failed";
//        }
//        map.put("result",result);
//        map.put("data",data);
//        return map;
//    }

    /**
     *
     *
     * @param all
     * @param session
     * @return
     */
    @PostMapping(value = "/workload")
    public Object computeWorkload(@RequestBody All all,HttpSession session){
        int id_role = (int)session.getAttribute("id");
        int role = (int)session.getAttribute("role");
        String _begin = all.getBegin();
        String _end = all.getEnd();
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        Map<String,Object> data = new HashMap<>();
        List<int[]> editors = new ArrayList<>();
        List<int[]> professors = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            if(_begin == null){
                _begin = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-1-1 00:00:00";
            }
            Date begin = sdf.parse(_begin);
            if(_end == null){
                _end = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-12-30 23:59:59";
            }
            Date end = sdf.parse(_end);
            if(role == 2){
                List<Map<String,Object>> t = contributeService.getAllByTable("editors");
                for(int i = 0;i < t.size();i++){
                    if(Integer.valueOf(t.get(i).get("alive").toString()) == 1 && Integer.valueOf(t.get(i).get("role").toString()) == 1){
                        int fin = -1;
                        int unfin = -1;
                        result = contributeService.getCountByTaskInfo(Integer.valueOf(t.get(i).get("id").toString()),Integer.valueOf(t.get(i).get("role").toString()) + 2,2,1,begin,end);
                        if(result != null){
                            fin = result;
                            unfin = -result;
                            result = contributeService.getCountByTaskInfo(Integer.valueOf(t.get(i).get("id").toString()),Integer.valueOf(t.get(i).get("role").toString()) + 2,6,1,begin,end);
                            if(result != null){
                                fin += result;
                                unfin -= result;
                                result = contributeService.getCountByTaskInfo(Integer.valueOf(t.get(i).get("id").toString()),Integer.valueOf(t.get(i).get("role").toString()) + 2,0,1,begin,end);
                                if(result != null){
                                    unfin += result;
                                    result = 1;
                                }
                            }
                            else{
                                result = 0;
                            }
                        }
                        else{
                            result = 0;
                        }
                        editors.add(new int[]{Integer.valueOf(t.get(i).get("id").toString()),Integer.valueOf(t.get(i).get("role").toString()) + 2,fin,unfin});
                    }
                }
                t.clear();
                t = contributeService.getAllByTable("professors");
                for(int i = 0;i < t.size();i++){
                    int fin = -1;
                    int unfin = -1;
                    result = contributeService.getCountByTaskInfo(Integer.valueOf(t.get(i).get("id").toString()),4,-1,0,begin,end);
                    if(result != null){
                        fin = result;
                        result = contributeService.getCountByTaskInfo(Integer.valueOf(t.get(i).get("id").toString()),4,-1,1,begin,end);
                        if(result != null){
                            unfin = result;
                            result = 1;
                        }
                        else{
                            result = 0;
                        }
                    }
                    else{
                        result = 0;
                    }
                    professors.add(new int[]{Integer.valueOf(t.get(i).get("id").toString()),4,fin,unfin});
                }
            }
            else if(role == 3){
                int fin = -1;
                int unfin = -1;
                result = contributeService.getCountByTaskInfo(id_role,role,2,1,begin,end);
                if(result != null){
                    fin = result;
                    unfin = -result;
                    result = contributeService.getCountByTaskInfo(id_role,role,6,1,begin,end);
                    if(result != null){
                        fin += result;
                        unfin -= result;
                        result = contributeService.getCountByTaskInfo(id_role,role,0,1,begin,end) + contributeService.getCountByTaskInfo(id_role,role,0,0,begin,end);
                        if(result != null){
                            unfin += result;
                            result = 1;
                        }
                    }
                    else{
                        result = 0;
                    }
                }
                else{
                    result = 0;
                }
                editors.add(new int[]{id_role,role,fin,unfin});
            }
            else if(role == 4){
                int fin = -1;
                int unfin = -1;
                result = contributeService.getCountByTaskInfo(id_role,role,-1,0,begin,end);
                if(result != null){
                    unfin = result;
                    result = contributeService.getCountByTaskInfo(id_role,role,-1,1,begin,end);
                    if(result != null){
                        fin = result;
                        result = 1;
                    }
                    else{
                        result = 0;
                    }
                }
                else{
                    result = 0;
                }
                professors.add(new int[]{id_role,role,fin,unfin});
            }
        }
        catch (Exception e){
            result = 0;
        }
        data.put("editors",editors);
        data.put("professors",professors);
        map.put("result",result);
        map.put("data",data);
        return map;
    }

//    @PostMapping(value = "/detect")
//    public Object dectectTask(){
//        Map<String,Object> map = new HashMap<>();
//        Integer result = 1;
//        List<Integer> data = new ArrayList<>();
//        List<Integer[]> STANTARDTASKLINK = new ArrayList<Integer[]>(){
//            {
//                add(new Integer[]{0,2,1});
//                add(new Integer[]{0,3,1});
//                add(new Integer[]{4,3,1});
//                add(new Integer[]{6,3,1});
//                add(new Integer[]{1,3,1});
//                add(new Integer[]{1,4,1});
//                add(new Integer[]{1,4,1});
//                add(new Integer[]{1,4,1});
//                add(new Integer[]{1,3,1});
//            }
//        };
//        List<Map<String,Object>> articleList = contributeService.getAllByTable("articles");
//        for(int i = 0;i < articleList.size();i++){
//            Integer id_article = Integer.valueOf(articleList.get(i).get("id").toString());
//            List<Task> task = contributeService.getTask(id_article,-1,1,-1,1,-1);
//            for(int j = 0;j < task.size();j++){
//
//            }
//        }
//        map.put("result",result);
//        map.put("data",data);
//        return map;
//    }

    @PostMapping(value = "/schedule")
    public Object uploadSchedule(@RequestParam(value = "schedule") MultipartFile schedule){
        Map<String,Object> map = new HashMap<>();
        Integer result = 1;
        String data = new String("");
        try{
            InputStream excel = schedule.getInputStream();
            List<List<Object>> list = getBankListByExcel(excel,schedule.getOriginalFilename());
            excel.close();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date;
            Date date_pub;
            if(list.get(0).size() == 1){
                String[] tmp = schedule.getOriginalFilename().split("[.]");
                date = new String(tmp[0] + "-" + tmp[1] + "-1 00:00:00");
                date_pub = sdf.parse(date);
                for(int i = 0;i < list.size();i++){
                    result = contributeService.uploadSchedule(list.get(i).toString(),date_pub);
                    if(result != null && result == 1){

                    }
                    else{
                        result = 0;
                        data = "Update Failed";
                    }
                }
            }
            else if(list.get(0).size() == 2){
                for(int i = 0;i < list.size();i++){
                    String[] tmp = list.get(i).get(1).toString().split("[.]");
                    date = new String(tmp[0] + "-" + tmp[1] + "-1 00:00:00");
                    date_pub = sdf.parse(date);
                    result = contributeService.uploadSchedule(list.get(i).get(0).toString(),date_pub);
                    if(result != null && result == 1){

                    }
                    else{
                        result = 0;
                        data = "Update Failed";
                    }
                }
            }
        }
        catch (Exception e){
            data = "Read Excel Failed";
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param upload
     * @param filename
     * @return
     */
    public Integer upload(MultipartFile upload, String filename){
        Integer result = 1;
        int index = upload.getOriginalFilename().lastIndexOf(".");
        String format = upload.getOriginalFilename().substring(index);
        String filepath = "./file/upload";
        try {
            File file = new File(filepath);
            if (!file.exists()){
                file.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(filepath + "/" + new String((filename + format).getBytes("UTF-8"),"UTF-8"));
            out.write(upload.getBytes());
            out.flush();
            out.close();
        }
        catch (Exception e){
            result = 0;
        }
        return result;
    }

    /**
     *
     * @param filename
     * @param request
     * @param response
     */
    public Integer download(String filename, HttpServletRequest request,HttpServletResponse response){
        Integer result = 1;
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");
        FileInputStream fis = null;
        try{
            File file = new File("./file/upload/" + filename);
            if(!file.exists()){
                response.setStatus(404);
            }
            else{
                fis = new FileInputStream(file);
                response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
                IOUtils.copy(fis, response.getOutputStream());
                response.flushBuffer();
            }
        }
        catch(IOException e1){
            e1.printStackTrace();
            result = 0;
        }
        finally{
            if(fis != null){
                try{
                    fis.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                    result = 0;
                }
            }
        }
        return result;
    }

    /**
     * 判断文件格式
     *
     * @param inStr
     * @param fileName
     * @return
     * @throws Exception
     */
    Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return workbook;
    }

    /**
     * 处理上传的文件
     *
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    List getBankListByExcel(InputStream in, String fileName) throws Exception {
        List list = new ArrayList<>();
        //创建Excel工作薄
        Workbook work = this.getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                List<Object> li = new ArrayList<>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    li.add(cell);
                }
                list.add(li);
            }
        }
        return list;
    }
}
