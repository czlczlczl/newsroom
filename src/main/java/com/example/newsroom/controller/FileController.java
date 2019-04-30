package com.example.newsroom.controller;

import com.example.newsroom.dao.CommonMapper;
import com.example.newsroom.service.CommonService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.font.Script;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Action;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/file")

public class FileController {
    public static final String artpath = "./file/upload";//文章
    public static final String anattapath = "./file/AnnouncementAnnexes";//公告附件
    public static final String anpicpath = "./file/AnnouncementPic";//公告图片
    public static final String infocenterpath = "./file/InfoCenter";//资料中心
    public static final String certificatepath = "./file/Certificate";//证书

    @Autowired
    CommonMapper commonMapper;

    /**
     * 下载文件
     *
     * @param id
     * @param type
     * @param request
     * @param response
     */
    @GetMapping(value = "/download/id={id}&type={type}")
    public void downloadAritcle(@PathVariable(value = "id") int id, @PathVariable(value = "type") int type, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");
        FileInputStream fis = null;
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        File file;
        try {
            switch (type){
                case 1://文章
                    HashMap article = commonMapper.GetArticle(id);
                    if (article != null) {
                        String format = (String) article.get("format");
                        String a[] = format.split(";");
                        file = new File(artpath , id + a[0]);
                        if(!file.exists()){
                            response.setStatus(404);
                        }
                        fis = new FileInputStream(file);
                        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
                        IOUtils.copy(fis, response.getOutputStream());
                        response.flushBuffer();
                    }else {
                        response.setStatus(404);
                    }
                    break;
//                case 2://文章附件
//                    HashMap article1 = commonMapper.GetArticle(id);
//                    if(article1 != null) {
//                        String title1 = (String) article1.get("title");
//                        String format1 = (String) article1.get("format");
//                        String a1[] = format1.split(";");
//                        if(a1.length == 1){
//
//                        }
//                        file = new File(artattapath , id + title1 + a1[1]);
//                        fis = new FileInputStream(file);
//                        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
//                        IOUtils.copy(fis, response.getOutputStream());
//                        response.flushBuffer();
//                    }else {
//                        response.setStatus(404);
//                    }
//                    break;
                case 3://公告附件
                    HashMap announcement = commonMapper.GetAnnouncement(id);
                    if (announcement != null) {
                        String upload = (String) announcement.get("upload");
                        file = new File(anattapath ,upload);
                        if(!file.exists()){
                            response.setStatus(404);
                        }
                        fis = new FileInputStream(file);
                        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
                        IOUtils.copy(fis, response.getOutputStream());
                        response.flushBuffer();
                    }else {
                        response.setStatus(404);
                    }
                    break;
                case 4://资料中心
                    HashMap infocenter = commonMapper.GetInfoCenter(id);
                    if (infocenter != null) {
                        String upload = (String) infocenter.get("content");
                        file = new File(infocenterpath ,upload);
                        if(!file.exists()){
                            response.setStatus(404);
                        }
                        fis = new FileInputStream(file);
                        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
                        IOUtils.copy(fis, toClient);
                        toClient.flush();
                    }else {
                        response.setStatus(404);
                    }
                    break;
                default:
                    Map<String, Object> article2 = commonMapper.GetArticle(id);
                    if (article2 != null) {
                        String format2 = (String) article2.get("format");
                        String a2[] = format2.split(";");
                        file = new File(artpath , id + a2[0]);
                        if(!file.exists()){
                            response.setStatus(404);
                        }
                        fis = new FileInputStream(file);
                        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
                        IOUtils.copy(fis, response.getOutputStream());
                        response.flushBuffer();
                    }else {
                        response.setStatus(404);
                    }
                    break;
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    toClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
