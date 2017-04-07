package com.flyrui.dao.pojo.bus;

import java.io.Serializable;
import java.util.Date;

public class BusRule implements Serializable {
    private Integer rule_id;

    private String rule_name;

    private String rule_type;

    private String rule_content;

    private Date create_date;

    private static final long serialVersionUID = 1L;

    public Integer getRule_id() {
        return rule_id;
    }

    public void setRule_id(Integer rule_id) {
        this.rule_id = rule_id;
    }

    public String getRule_name() {
        return rule_name;
    }

    public void setRule_name(String rule_name) {
        this.rule_name = rule_name == null ? null : rule_name.trim();
    }

    public String getRule_type() {
        return rule_type;
    }

    public void setRule_type(String rule_type) {
        this.rule_type = rule_type == null ? null : rule_type.trim();
    }

    public String getRule_content() {
        return rule_content;
    }

    public void setRule_content(String rule_content) {
        this.rule_content = rule_content == null ? null : rule_content.trim();
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}