package com.example.newsroom.entity;

import java.util.List;

/**
 * @Description
 * @auther lfx
 * @date 2019/3/18 9:06
 */
public class PageBean {
    private int currentPage = 1;//当前页码,默认为1
    private int pageSize = 2;//每页显示的记录数,默认为10
    private int total;//总记录数
    private int totalPage;//总页数
    private int startIndex;//开始索引，从数据库中第几行拿
    private List rows;//当前页需要展示的数据集合

    /**
     * 构造方法：需要当前页码、总条数
     * @param currentPage
     * @param total
     */
    public PageBean(int currentPage, int total) {
        this.currentPage = currentPage;
        this.total = total;

        //获得总页数
        if (total % pageSize == 0) {
            //正好整除
            this.totalPage = total / pageSize;
        }else {
            //没有整除，需要加一页来显示
            this.totalPage = total / pageSize + 1;
        }

        //判断当前页码是否正确
        if (currentPage < 1) {
            currentPage = 1;
        }
        if (currentPage > totalPage && totalPage != 0){
            currentPage = totalPage;
        }
        //计算索引
        this.startIndex = (currentPage - 1) * pageSize;


    }

    /**
     * 无参构造函数
     */
    public PageBean() { }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
