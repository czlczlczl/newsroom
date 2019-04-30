package com.example.newsroom.dao;

import com.example.newsroom.entity.Author;
import com.example.newsroom.model.ResetPwd;
import com.example.newsroom.model.Voucher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface CommonMapper {

    Integer IsEmailExist(@Param(value = "email") String email);

    Integer InsertAuthor(@Param(value = "author")Author author);

    String GetPwdById(@Param(value = "username") String username, @Param(value = "role") int role, @Param(value = "year") int year);

    HashMap GetUserById(@Param(value = "username") String username, @Param(value = "role") int role);

    HashMap GetSafeQueById(@Param(value = "username") String username, @Param(value = "role") int role);

    String GetQueById(@Param(value = "id")int id);

    Integer ResetPassword(@Param(value = "resetPwd")ResetPwd resetPwd);

    List<HashMap<String,Object>> GetAnnouncementList(@Param(value = "num") int num);

    HashMap GetAnnouncement(@Param(value = "id") int id);

    List<HashMap<String,Object>> GetLatestArticleList(@Param(value = "num") int num, @Param(value = "date") Date date);

    HashMap GetArticle(@Param(value = "id") int id);

    List<HashMap<String,Object>> GetType(@Param(value = "type") String type);

    List<HashMap<String,Object>> GetMainList();

    String GetMain(@Param(value = "type") int type);

    List<HashMap<String,Object>> GetInfoCenterList();

    HashMap GetInfoCenter(@Param(value = "id") int id);

    List<HashMap<String,Object>> GetLinkList();

    List<HashMap<String,Object>> GetCertificate();
}
