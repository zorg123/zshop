package com.flyrui.dao.pojo.sys;

import java.io.Serializable;
import java.util.Date;

public class TbConfig implements Serializable {
    private String cf_id;

    private String cf_desc;

    private String cf_value;

    private Date create_time;

    private static final long serialVersionUID = 1L;

    public String getCf_id() {
        return cf_id;
    }

    public void setCf_id(String cf_id) {
        this.cf_id = cf_id == null ? null : cf_id.trim();
    }

    public String getCf_desc() {
        return cf_desc;
    }

    public void setCf_desc(String cf_desc) {
        this.cf_desc = cf_desc == null ? null : cf_desc.trim();
    }

    public String getCf_value() {
        return cf_value;
    }

    public void setCf_value(String cf_value) {
        this.cf_value = cf_value == null ? null : cf_value.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}