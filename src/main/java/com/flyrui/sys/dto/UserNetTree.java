package com.flyrui.sys.dto;

import java.util.List;

public class UserNetTree {
	private String id;
	private List<UserNetTree> children;
	private String title;
	private String className;
	private String star;
	private String starName;
	private String allchild_num;
	private String userCode;
	private String userState;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<UserNetTree> getChildren() {
		return children;
	}
	public void setChildren(List<UserNetTree> children) {
		this.children = children;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getAllchild_num() {
		return allchild_num;
	}
	public void setAllchild_num(String allchild_num) {
		this.allchild_num = allchild_num;
	}
	
	public void setStarName(String starName) {
		this.starName = starName;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getStarName() {
		return starName;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	
}
