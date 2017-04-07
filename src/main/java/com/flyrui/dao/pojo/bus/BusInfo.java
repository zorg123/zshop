package com.flyrui.dao.pojo.bus;

import java.io.Serializable;
import java.util.Date;

public class BusInfo implements Serializable {
    private Integer bus_id;

    private String bus_name;

    private String imp_tmp;

    private String exp_tmp;

    private Date create_date;

    private static final long serialVersionUID = 1L;

    public Integer getBus_id() {
        return bus_id;
    }

    public void setBus_id(Integer bus_id) {
        this.bus_id = bus_id;
    }

    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name == null ? null : bus_name.trim();
    }

    public String getImp_tmp() {
        return imp_tmp;
    }

    public void setImp_tmp(String imp_tmp) {
        this.imp_tmp = imp_tmp == null ? null : imp_tmp.trim();
    }

    public String getExp_tmp() {
        return exp_tmp;
    }

    public void setExp_tmp(String exp_tmp) {
        this.exp_tmp = exp_tmp == null ? null : exp_tmp.trim();
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}