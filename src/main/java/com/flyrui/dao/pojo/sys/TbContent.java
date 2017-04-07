package com.flyrui.dao.pojo.sys;

import java.io.Serializable;
import java.util.Date;

public class TbContent implements Serializable {
    private Integer content_id;

    private Date create_date;

    private String content;

    private static final long serialVersionUID = 1L;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}