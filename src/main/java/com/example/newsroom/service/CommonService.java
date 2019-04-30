package com.example.newsroom.service;

import com.example.newsroom.entity.Author;
import com.example.newsroom.model.ResetPwd;
import com.example.newsroom.model.SafeAnswer;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface CommonService {

    Map<String, Object> IsEmailExist(String email);

    Map<String, Object> InserAuthor(Author author);

    Map<String, Object> LoginVerify(String username, String userpassword, int role);

    Map<String, Object> GetUserByUsername(String username, int role);

    Map<String, Object> GetSafeQueById(String username, int role);

    Map<String, Object> VerifySafeQue(SafeAnswer safeAnswer);

    Map<String, Object> ResetPassword(ResetPwd resetPwd);

    Map<String, Object> GetAnnouncementList(int num);

    Map<String, Object> GetAnnouncement(int id);

    Map<String, Object> GetLatestArticleList(int num);

    Map<String, Object> GetArticle(int id);

    Map<String, Object> GetType(String type);

    Map<String, Object> GetMainList();

    Map<String, Object> GetMain(int id);

    Map<String, Object> GetInfoCenterList();

    Map<String, Object> GetLinkList();

    Map<String, Object> GetCertificate();
}
