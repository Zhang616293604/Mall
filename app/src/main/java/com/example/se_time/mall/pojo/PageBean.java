package com.example.se_time.mall.pojo;

import android.support.v4.view.PagerTitleStrip;

import java.util.List;

public class PageBean<T> {
    private List<T> data;

    private int pageNum;
    private int pageSize;
    private int totalRecord;
    private int totalPage;
    private int startIndex;
    private int prePage;
    private int nextPage;

    public PageBean() {
    }

    public PageBean(int pageNum, int pageSize, int totalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        if(totalRecord%pageSize==0)
        {
            this.totalPage=totalRecord%pageSize;
        }
        else this.totalPage=totalRecord%pageSize+1;

        this.startIndex=(pageNum-1)*pageSize;
        this.prePage=this.pageNum-1;
        this.nextPage=this.pageNum+1;
        if(this.prePage<0)
            this.prePage=this.pageNum;
        if(this.nextPage>totalPage)
            this.nextPage=this.totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
}
