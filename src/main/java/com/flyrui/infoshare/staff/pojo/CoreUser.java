package com.flyrui.infoshare.staff.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 用户，包括科研人员和系统用户.
 *
 */
public class CoreUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**  */
	private String id;

	/**  */
	private String name;

	/** 简介 */
	private String summary;

	/** 照片地址 */
	private String photo;

	/** 所属单位 */
	private String department;

	/** 状态，0：待认证，1：通过认证，-1：禁用 */
	private Integer status;

	/** 注册时间 */
	private Date register_time;

	/** 登陆账号 */
	private String account;

	/** 密码 */
	private String password;

	/**  */
	private String phone;

	/**  */
	private String citizen_id;

	/**  */
	private String mobile;
	
	/** 所属部门名称  */
	private String department_name;
	


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getRegister_time() {
		return this.register_time;
	}

	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCitizen_id() {
		return this.citizen_id;
	}

	public void setCitizen_id(String citizen_id) {
		this.citizen_id = citizen_id;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
}
