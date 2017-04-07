package com.flyrui.sys.dto;

import java.io.Serializable;

import com.flyrui.common.excel.ExcelAnnotation;

public class UserInfoDto implements Serializable {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;
	
	@ExcelAnnotation(exportName = "员工工号")
	private String user_code;
	
	@ExcelAnnotation(exportName = "姓名")
	private String name;
	
	@ExcelAnnotation(exportName = "所属部门")
	private String org_name;	
	
	@ExcelAnnotation(exportName = "银行账号")
	private String bank_account;	
	
	@ExcelAnnotation(exportName = "密码")
	private String password;
	
	@ExcelAnnotation(exportName = "电话")
	private String phone;
	
	@ExcelAnnotation(exportName = "性别")
	private String sex;
	
	@ExcelAnnotation(exportName = "邮箱")
	private String mail;
	
	@ExcelAnnotation(exportName = "身份证号码")
	private String id_card;
	
	@ExcelAnnotation(exportName = "员工级别")
	private String position_level;

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String userCode) {
		user_code = userCode;
	}
	
	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String orgName) {
		org_name = orgName;
	}

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bankAccount) {
		bank_account = bankAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String idCard) {
		id_card = idCard;
	}

	public String getPosition_level() {
		return position_level;
	}

	public void setPosition_level(String positionLevel) {
		position_level = positionLevel;
	}
		
}
