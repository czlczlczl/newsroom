package com.example.newsroom.entity;

/**
 * @Description 此类为查询User对象的条件
 * @auther lfx
 * @date 2019/3/18 10:35
 */
public class UserCondition {

    //用户角色
    private int role;

    //用户姓名
    private String name = "";

    //作者email
    private String email = "";

    //联系方式
    private String phone = "";

    //用户账号
    private String username = "";

    //当前页数
    private int page = 1;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
