package com.flyrui.dao.pojo.sys;

import java.io.Serializable;
import java.util.Date;

public class TbUser implements Serializable {
    private String user_id;

    private String user_code;

    private String name;

    private String password;

    private String sex;

    private String mail;

    private String phone;

    private Integer org_id;

    private Date register_date;

    private String register_ip;

    private Date last_login_time;

    private String last_login_ip;

    private Integer login_count;

    private String state;
    
    private String bank_account;

    private String id_card;
    
    private String position_level;
    
    private String cas_account;
    
    private static final long serialVersionUID = 1L;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code == null ? null : user_code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Integer org_id) {
        this.org_id = org_id;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public String getRegister_ip() {
        return register_ip;
    }

    public void setRegister_ip(String register_ip) {
        this.register_ip = register_ip == null ? null : register_ip.trim();
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getLast_login_ip() {
        return last_login_ip;
    }

    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip == null ? null : last_login_ip.trim();
    }

    public Integer getLogin_count() {
        return login_count;
    }

    public void setLogin_count(Integer login_count) {
        this.login_count = login_count;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bankAccount) {
		bank_account = bankAccount;
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

	public String getCas_account() {
		return cas_account;
	}

	public void setCas_account(String cas_account) {
		this.cas_account = cas_account;
	}
   
	
    
}