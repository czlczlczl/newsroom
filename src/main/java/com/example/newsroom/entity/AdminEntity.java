package com.example.newsroom.entity;

/**
 * @Description 因前端传递过来的是json格式数据，所以将adminController中的一些单个字段封装在此类中
 * @Author lfx
 * @Date 2019-05-28 20:19
 */
public class AdminEntity {
    private int id;
    private String title;//公告标题
    private String academicsec;//学术领域名称
    private String column;//栏目名称
    private String name;//首页横向版面名称
    private String content;//首页横向版面说明
    private int priority;//首页横向版面权重
    private int alive;//首页横向版面是否有效
    private int page;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcademicsec() {
        return academicsec;
    }

    public void setAcademicsec(String academicsec) {
        this.academicsec = academicsec;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getAlive() {
        return alive;
    }

    public void setAlive(int alive) {
        this.alive = alive;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
