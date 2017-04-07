package com.flyrui.dao.pojo.bus;

import java.io.Serializable;
import java.util.Date;

public class BusTemplate implements Serializable {
    private String template_id;

    private String template_name;

    private String template_type;

    private String data_type;

    private Integer sheet_number;

    private Integer start_row;

    private Date create_date;

    private static final long serialVersionUID = 1L;

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id == null ? null : template_id.trim();
    }

    public String getTemplate_name() {
        return template_name;
    }

    public void setTemplate_name(String template_name) {
        this.template_name = template_name == null ? null : template_name.trim();
    }

    public String getTemplate_type() {
        return template_type;
    }

    public void setTemplate_type(String template_type) {
        this.template_type = template_type == null ? null : template_type.trim();
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type == null ? null : data_type.trim();
    }

    public Integer getSheet_number() {
        return sheet_number;
    }

    public void setSheet_number(Integer sheet_number) {
        this.sheet_number = sheet_number;
    }

    public Integer getStart_row() {
        return start_row;
    }

    public void setStart_row(Integer start_row) {
        this.start_row = start_row;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}