package com.flyrui.dao.common.page;

import java.util.ArrayList;
import java.util.List;

public class PageModel <T>{
	private int total = 0;
	private List<T> rows = new ArrayList<T>();
	private int pageSize = 20;
	private int pageIndex = 1;
	private int startIndex = 0;
	private int endIndex = 0;
	private int pageCount=0;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
		if(endIndex>total){
			endIndex = total+1;
		}
		//计算页数
		if(total>0){
			if(total%pageSize == 0){
				pageCount = total/pageSize;
			}else{
				pageCount = total/pageSize+1;
			}
		}
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;		
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getStartIndex() {
		this.startIndex = (pageIndex-1)*pageSize;
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		endIndex = (pageIndex)*pageSize;		
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
}
