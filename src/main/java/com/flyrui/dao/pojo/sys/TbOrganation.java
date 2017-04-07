package com.flyrui.dao.pojo.sys;

import java.io.Serializable;
import java.util.Date;

public class TbOrganation implements Serializable {
    private Integer org_id;

    private String org_code;

    private String org_name;

    private Integer up_org_id;

    private Date create_date;

    private String state;
    
    private String up_org_name;

    private static final long serialVersionUID = 1L;

    public Integer getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Integer org_id) {
        this.org_id = org_id;
    }

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code == null ? null : org_code.trim();
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name == null ? null : org_name.trim();
    }

    public Integer getUp_org_id() {
        return up_org_id;
    }

    public void setUp_org_id(Integer up_org_id) {
        this.up_org_id = up_org_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	public String getUp_org_name() {
		return up_org_name;
	}

	public void setUp_org_name(String upOrgName) {
		up_org_name = upOrgName;
	}
    
    
}