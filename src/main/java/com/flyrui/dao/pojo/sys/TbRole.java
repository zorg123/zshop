package com.flyrui.dao.pojo.sys;

import java.io.Serializable;
import java.util.Date;

public class TbRole implements Serializable {
    private Integer role_id;

    private String role_name;

    private String role_desc;

    private Date create_date;
    
    private String user_id;

    private static final long serialVersionUID = 1L;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name == null ? null : role_name.trim();
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc == null ? null : role_desc.trim();
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}
    
    
}