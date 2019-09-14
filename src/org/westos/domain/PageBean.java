package org.westos.domain;

import java.util.List;

public class PageBean {
    private int currentPage=1;   //当前页
    private int pageCount=5;       // 每页的条数
    private int totalCount; // 总条数
    private int totalPage;    // 总页数=总条数/每页的条数
    private List<User> pageData; // 分页查询到的数据

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
      //          101/10;
    //获取总页数=总条数/每页的条数
    public int getTotalPage() {
        return totalCount%pageCount==0?totalCount/pageCount:(totalCount / pageCount)+1;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<User> getPageData() {
        return pageData;
    }

    public void setPageData(List<User> pageData) {
        this.pageData = pageData;
    }
}
