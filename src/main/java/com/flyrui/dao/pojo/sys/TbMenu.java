package com.flyrui.dao.pojo.sys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TbMenu implements Serializable {
    private Integer menu_id;

    private String menu_name;

    private String menu_url;

    private Integer url_open_type;

    private Integer up_menu_id;

    private Date create_date;

    private Date modify_date;

    private String state;

    private String menu_desc;

    private Integer order_id;
    
    private List sub_menu_list;

    private static final long serialVersionUID = 1L;

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name == null ? null : menu_name.trim();
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url == null ? null : menu_url.trim();
    }

    public Integer getUrl_open_type() {
        return url_open_type;
    }

    public void setUrl_open_type(Integer url_open_type) {
        this.url_open_type = url_open_type;
    }

    public Integer getUp_menu_id() {
        return up_menu_id;
    }

    public void setUp_menu_id(Integer up_menu_id) {
        this.up_menu_id = up_menu_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getMenu_desc() {
        return menu_desc;
    }

    public void setMenu_desc(String menu_desc) {
        this.menu_desc = menu_desc == null ? null : menu_desc.trim();
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

	public List getSub_menu_list() {
		return sub_menu_list;
	}

	public void setSub_menu_list(List subMenuList) {
		sub_menu_list = subMenuList;
	}   
    
}