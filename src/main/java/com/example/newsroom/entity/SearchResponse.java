package com.example.newsroom.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SearchResponse {
    private String bookNumber;
    private String title;
    private String authors;
    private String index;
    private String isbnOrIssn;
    private String publisher;
    private String publishTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date entryTime;
    private Integer bookCount;
    private String origin;
    private Integer id;
    private String classifyNumber;

    public SearchResponse() {
    }

//    public SearchResponse(eBook eBook) {
//        this.bookNumber = null;
//        this.title = eBook.getTitle();
//        this.authors = eBook.getAuthor();
//        this.index = null;
//        this.isbnOrIssn = eBook.getIsbn();
//        this.publisher = eBook.getPublisher();
//        this.publishTime = eBook.getPublishTime();
//        this.entryTime = null;
//        this.bookCount = null;
//        this.classifyNumber = eBook.getClassifyNumber();
//        this.origin = null;
//        this.id = eBook.getId();
//    }
//
//    public SearchResponse(ZYK zyk, Integer bookCount) {
//        this.bookNumber = zyk.getBookNumber();
//        this.title = zyk.getTitle();
//        this.authors = zyk.getAuthors();
//        this.index = zyk.getIndex();
//        this.isbnOrIssn = zyk.getIsbn();
//        this.publisher = zyk.getPublisher();
//        this.publishTime = zyk.getPublishTime();
//        this.entryTime = zyk.getEntryTime();
//        this.bookCount = bookCount;
//        this.classifyNumber = zyk.getClassifyNumber();
//        this.origin = zyk.getOrigin();
//        this.id = zyk.getId();
//    }
//
//    public SearchResponse(Journal journal, Integer bookCount) {
//        this.bookNumber = journal.getBookNumber();
//        this.title = journal.getTitle();
//        this.authors = journal.getAuthors();
//        this.index = journal.getIndex();
//        this.isbnOrIssn = journal.getIssn();
//        this.publisher = journal.getPublisher();
//        this.publishTime = journal.getPublishTime();
//        this.entryTime = journal.getEntryTime();
//        this.bookCount = bookCount;
//        this.classifyNumber = journal.getClassifyNumber();
//        this.origin = journal.getOrigin();
//        this.id = journal.getId();
//    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String classifyNumber) {
        this.index = classifyNumber;
    }

    public String getClassifyNumber() {
        return classifyNumber;
    }

    public void setClassifyNumber(String classifyNumber) {
        this.classifyNumber = classifyNumber;
    }

    public String getIsbnOrIssn() {
        return isbnOrIssn;
    }

    public void setIsbnOrIssn(String isbn) {
        this.isbnOrIssn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
