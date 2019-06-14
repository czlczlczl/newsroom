package com.example.newsroom.entity;

import java.util.Date;

public class Resource {
    private String func;
    private int academicsec;
    private int id_article;

    public void setFunc(String func) {
        this.func = func;
    }

    public String getFunc() {
        return func;
    }

    public void setAcademicsec(int academicsec){
        this.academicsec = academicsec;
    }

    public int getAcademicsec(){
        return academicsec;
    }

    public void setId_article(int id_article){
        this.id_article = id_article;
    }

    public int getId_article(){
        return id_article;
    }
}
