package com.flyrui.dao.pojo.sys;

import java.io.Serializable;
import java.util.Date;

public class TbNotice implements Serializable {
    private Integer notice_id;

    private String title;

    private Integer content_id;

    private Date create_date;

    private Date eff_date;

    private Date exp_date;
    
    private String state;

    private Integer oper_staff;

    private static final long serialVersionUID = 1L;

    public Integer getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(Integer notice_id) {
        this.notice_id = notice_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getContent_id() {
        return content_id;
    }

    public void setContent_id(Integer content_id) {
        this.content_id = content_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getEff_date() {
        return eff_date;
    }

    public void setEff_date(Date eff_date) {
        this.eff_date = eff_date;
    }

    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }

    public Integer getOper_staff() {
        return oper_staff;
    }

    public void setOper_staff(Integer oper_staff) {
        this.oper_staff = oper_staff;
    }

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}    
}