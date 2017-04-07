package com.flyrui.dao.pojo.sys;

import java.io.Serializable;
import java.util.Date;

public class TbRoleMenu implements Serializable {
    private Integer role_id;

    private Integer menu_id;

    private Date create_date;

    private static final long serialVersionUID = 1L;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}