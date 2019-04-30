package com.example.newsroom.dao;

import com.example.newsroom.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface AdminMapper {

    Integer CreateAnnouncement(@Param(value = "announcement")Announcement announcement);

    Integer DeleteAnnouncement(@Param(value = "id")int id);

    Integer UpdateAnnouncement(@Param(value = "announcement")Announcement announcement);

    Integer GetUserCount(@Param(value = "role")int role);

    List<HashMap<String,Object>> GetUser(@Param(value = "role")int role, @Param(value = "page")int page);

    Integer ResetPassword(@Param(value = "username")String username, @Param(value = "pwd")String pwd, @Param(value = "role")int role );

    Integer DeleteUser(@Param(value = "username")String username, @Param(value = "role")int role );

    Integer IsUserExist(@Param(value = "username") String username, @Param(value = "role")int role);

    Integer CreateUser(@Param(value = "user")Object user, @Param(value = "role")int role );

    Integer CreateAcademicsec(@Param(value = "academicsec")String academicsec);

    Integer SelectAcademicsec(@Param(value = "academicsec")String academicsec);

    Integer UpdateAcademicsec(@Param(value = "academicsec")String academicsec, @Param(value = "id")int id);

    Integer CreateColumn(@Param(value = "column")String column);

    Integer SelectColumn(@Param(value = "column")String column);

    Integer UpdateColumn(@Param(value = "column")String column, @Param(value = "id")int id);

    List<HashMap<String,Object>> GetStandardList();

    HashMap<String,Object> GetStandard(@Param(value = "year")int year);

    Integer UpdateStandard(@Param(value = "year")int year, @Param(value = "standard")int standard,
                           @Param(value = "reviewfee")int reviewfee, @Param(value = "pagecharges")int pagecharges,
                           @Param(value = "articlenum")int articlenum, @Param(value = "content")String content);

    Integer InsertStandard(@Param(value = "year")int year, @Param(value = "standard")int standard,
                           @Param(value = "reviewfee")int reviewfee, @Param(value = "pagecharges")int pagecharges,
                           @Param(value = "articlenum")int articlenum, @Param(value = "admin")String admin,
                           @Param(value = "password")String password, @Param(value = "content")String content);

    HashMap<String,Object> GetContent(int year);

    Integer UpdateContent(@Param(value = "year")int year, @Param(value = "cont")String cont);

    List<HashMap<String,Object>> GetAnnouncementInfoList(@Param(value = "type")int type);

    Integer InsertMain(@Param(value = "name")String name, @Param(value = "content")String content, @Param(value = "priority")int priority, @Param(value = "alive")int alive);

    Integer UpdateMain(@Param(value = "id")int id, @Param(value = "name")String name, @Param(value = "content")String content, @Param(value = "priority")int priority, @Param(value = "alive")int alive);

    Integer DeleteMain(@Param(value = "id")int id);

    Integer CreateInfoCenter(@Param(value = "name")String name, @Param(value = "content")String content, @Param(value = "priority")int priority, @Param(value = "alive")int alive, @Param(value = "date")Date date);

    Integer UpdateInfoCenter(@Param(value = "type")int type, @Param(value = "name")String name, @Param(value = "content")String content, @Param(value = "priority")int priority, @Param(value = "alive")int alive);

    Integer DeleteInfoCenter(@Param(value = "id")int id);

    Integer UpdateMainList(@Param(value = "type")int type, @Param(value = "name")String name);

    /**
     *TODO lfx
     */

    Integer InsertLink(@Param(value = "friendLink")FriendLink link);

    Integer UpdateLink(@Param(value = "friendLink")FriendLink link);

    Integer DeleteLink(@Param(value = "id")int id);

    Integer GetLinkCount();

    List<HashMap<String,Object>> SearchLink(@Param(value = "startIndex") int startIndex);

    List<HashMap<String,Object>> SearchUser(@Param(value = "usercondition") UserCondition condition, @Param(value = "startIndex") int startIndex);

    Integer SearchUserCount(@Param(value = "usercondition") UserCondition condition);

    Integer SearchAnnouncementCount(@Param(value = "title") String title);

    List<HashMap<String, Object>> SearchAnnouncement(@Param(value = "title") String title, @Param(value = "startIndex") int startIndex);

    HashMap GetAnnouncement(@Param(value = "id") int id);

    Integer GetAcademicsecCount();

    List<HashMap<String, Object>> GetAcademicsec(@Param(value = "startIndex") int startIndex);

    Integer DeleteAcademicsec(@Param(value = "id")int id);

    //证书
    Integer InsertCertificate(@Param(value = "certificate")Certificate certificate);

    Integer UpdateCertificate(@Param(value = "certificate")Certificate certificate);

    Integer DeleteCertificate(@Param(value = "id")int id);

    Integer GetCertificateCount();

    List<HashMap<String,Object>> SearchCertificate(@Param(value = "startIndex") int startIndex);

    Integer UpdateCertificateAlive(@Param(value = "id")int id, @Param(value = "alive")int alive);


    /**
     * lfx
     */


/*    Integer InsertLink(@Param(value = "name")String name, @Param(value = "content")String content);

    Integer UpdateLink(@Param(value = "type")int type, @Param(value = "name")String name, @Param(value = "content")String content);

    Integer DeleteLink(@Param(value = "id")int id);*/

}
