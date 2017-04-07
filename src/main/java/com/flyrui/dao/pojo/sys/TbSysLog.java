package com.flyrui.dao.pojo.sys;

import java.io.Serializable;
import java.util.Date;

public class TbSysLog implements Serializable {
    private Integer log_id;

    private String user_id;

    private Integer login_role_Id;

    private Integer log_type;

    private Date create_time;

    private String ip;

    private String url;

    private String resultCode;

    private String title;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getLog_id() {
        return log_id;
    }

    public void setLog_id(Integer log_id) {
        this.log_id = log_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getLogin_role_Id() {
        return login_role_Id;
    }

    public void setLogin_role_Id(Integer login_role_Id) {
        this.login_role_Id = login_role_Id;
    }

    public Integer getLog_type() {
        return log_type;
    }

    public void setLog_type(Integer log_type) {
        this.log_type = log_type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode == null ? null : resultCode.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}