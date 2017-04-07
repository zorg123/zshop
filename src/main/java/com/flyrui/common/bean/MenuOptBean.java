package com.flyrui.common.bean;

import java.util.List;

import com.flyrui.dao.pojo.sys.TbMenu;

public class MenuOptBean {
	public List<TbMenu> insertList;
	public List<TbMenu> deleteList;
	public List<TbMenu> updateList;
	
	public List<TbMenu> getInsertList() {
		return insertList;
	}
	public void setInsertList(List<TbMenu> insertList) {
		this.insertList = insertList;
	}
	public List<TbMenu> getDeleteList() {
		return deleteList;
	}
	public void setDeleteList(List<TbMenu> deleteList) {
		this.deleteList = deleteList;
	}
	public List<TbMenu> getUpdateList() {
		return updateList;
	}
	public void setUpdateList(List<TbMenu> updateList) {
		this.updateList = updateList;
	}
	
	
}
