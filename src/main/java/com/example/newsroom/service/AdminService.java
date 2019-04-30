package com.example.newsroom.service;

import com.alibaba.fastjson.JSONObject;
import com.example.newsroom.entity.*;

import java.util.Date;
import java.util.Map;

public interface AdminService {

    Map<String, Object> CreateAnnouncement(Announcement announcement);

    Map<String, Object> DeleteAnnouncement(int id);

    Map<String, Object> GetAnnouncement(String title, int page);

    Map<String, Object> GetAnnouncement(int id);

    Map<String, Object> UpdateAnnouncement(Announcement announcement);

    Map<String, Object> GetUser(int role, int page);

    Map<String, Object> ResetPassword(String username, int role);

    Map<String, Object> DeleteUser(String username, int role);

    Map<String, Object> CreateUser(JSONObject user, int role);

    Map<String, Object> CreateAcademicsec(String academicsec);

    Map<String, Object> UpdateAcademicsec(String academicesc, int id);

    Map<String, Object> CreateColumn(String coulumn);

    Map<String, Object> UpdateColumn(String coulumn, int id);

    Map<String, Object> GetStandardList();

    Map<String, Object> UpdateStandard(int year,int standard,int reviewfee,int pagecharges,int articlenum);

    Map<String, Object> GetContent(int year);

    Map<String, Object> UpdateContent(int year, int which, Date date, int num);

    void InsertInfo();

    void ClearSrc();

    Map<String, Object> InsertMain(String name, String content, int priority, int alive);

    Map<String, Object> UpdateMain(int id, String name, String content, int priority, int alive);

    Map<String, Object> DeleteMain(int id);

    Map<String, Object> CreateInfoCenter(String name, String content, int priority, int alive);

    Map<String, Object> UpdateInfoCenter(int type, String name, String content, int priority, int alive);

    Map<String, Object> DeleteInfoCenter(int id);

    Map<String, Object> UpdateLink(FriendLink link);

    Map<String, Object> DeleteLink(int id);

    Map<String, Object> InsertLink(FriendLink link);

    Map<String, Object> SearchLink(int page);

    Map<String, Object> SearchUser(UserCondition userCondition);

    Map<String, Object> GetAcademicsec(int page);

    Map<String, Object> DeleteAcademicsec(int id);

    Map<String, Object> InsertCertificate(Certificate certificate);

    Map<String, Object> UpdateCertificate(Certificate certificate);

    Map<String, Object> DeleteCertificate(int id);

    Map<String, Object> SearchCertificate(int page);

    Map<String, Object> UpdateCertificateAlive(int id, int alive);

}
