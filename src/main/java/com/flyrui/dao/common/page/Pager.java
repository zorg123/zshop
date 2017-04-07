package com.flyrui.dao.common.page;

import java.io.Serializable;
import java.util.List;

public class Pager implements Serializable{	 

    private static final long serialVersionUID = 1566826618769972857L;

    //默认的每页记录数

    public static final int DEFAULT_PAGE_SIZE = 25;

    // 每页的记录数

    private int pageSize = DEFAULT_PAGE_SIZE;

    // 当前页

    private int pageNo = 1;

    // 总行数

    private int rowCount;

    // 总页数

    private int pageCount;

    // 每页的记录

    private List resultList;

   

    public Pager() {

    }   

    public Pager(int pageNo) {

       this.pageNo = pageNo;

    } 

    public Pager(int pageSize, int pageNo) {

       this.pageSize = pageSize;

       this.pageNo = pageNo;

    } 

    public int getPageSize() {

       return pageSize;

    } 

    public void setPageSize(int pageSize) {

       this.pageSize = pageSize;

    } 

    public int getPageNo() {

       return pageNo;

    } 

    public void setPageNo(int pageNo) {

       this.pageNo = pageNo;

    }

    public int getRowCount() {

       return rowCount;

    }

    public void setRowCount(int rowCount) {

       this.rowCount = rowCount;

       if(rowCount % pageSize == 0) {

           this.pageCount = rowCount / pageSize;

       } else {

           this.pageCount = rowCount / pageSize + 1;

       }

    }

    public int getPageCount() {

       return pageCount;

    }

    public void setPageCount(int pageCount) {

       this.pageCount = pageCount;

    } 

    public List getResultList() {

       return resultList;

    } 

    public void setResultList(List resultList) {

       this.resultList = resultList;

    }

}
