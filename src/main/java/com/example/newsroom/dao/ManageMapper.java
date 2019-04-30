package com.example.newsroom.dao;

import com.example.newsroom.entity.Author;
import com.example.newsroom.model.ResetPwd;
import com.example.newsroom.model.Voucher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface ManageMapper {

    String GetPwdById(@Param(value = "username") String username, @Param(value = "role") int role);

    Integer ResetPassword(@Param(value = "resetPwd")String resetPwd,@Param(value = "username") String username, @Param(value = "role") int role);

    HashMap GetInformation(@Param(value = "username") String username, @Param(value = "role") int role);

    Integer UpdateUserInfo(@Param(value = "userinfo")Object userinfo, @Param(value = "username")String username, @Param(value = "role")int role);

    String GetName(@Param(value = "username") String username, @Param(value = "role") int role);

}
