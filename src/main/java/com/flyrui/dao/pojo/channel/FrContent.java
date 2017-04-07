package com.flyrui.dao.pojo.channel;

import java.io.Serializable;
import java.util.Date;

public class FrContent extends FrContentExt implements Serializable {
    private Integer content_id;

    private Integer channel_id;

    private Integer user_id;

    private Integer type_id;

    private Integer site_id;

    private Date sort_date;

    private String top_level;

    private Boolean has_title_img;

    private Boolean is_recommend;

    private String status;

    private Integer views_day;

    private Short comments_day;

    private Short downloads_day;

    private Short ups_day;

    private static final long serialVersionUID = 1L;

    public Integer getContent_id() {
        return content_id;
    }

    public void setContent_id(Integer content_id) {
        this.content_id = content_id;
    }

    public Integer getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(Integer channel_id) {
        this.channel_id = channel_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Integer getSite_id() {
        return site_id;
    }

    public void setSite_id(Integer site_id) {
        this.site_id = site_id;
    }

    public Date getSort_date() {
        return sort_date;
    }

    public void setSort_date(Date sort_date) {
        this.sort_date = sort_date;
    }

    public String getTop_level() {
        return top_level;
    }

    public void setTop_level(String top_level) {
        this.top_level = top_level;
    }

    public Boolean getHas_title_img() {
        return has_title_img;
    }

    public void setHas_title_img(Boolean has_title_img) {
        this.has_title_img = has_title_img;
    }

    public Boolean getIs_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(Boolean is_recommend) {
        this.is_recommend = is_recommend;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getViews_day() {
        return views_day;
    }

    public void setViews_day(Integer views_day) {
        this.views_day = views_day;
    }

    public Short getComments_day() {
        return comments_day;
    }

    public void setComments_day(Short comments_day) {
        this.comments_day = comments_day;
    }

    public Short getDownloads_day() {
        return downloads_day;
    }

    public void setDownloads_day(Short downloads_day) {
        this.downloads_day = downloads_day;
    }

    public Short getUps_day() {
        return ups_day;
    }

    public void setUps_day(Short ups_day) {
        this.ups_day = ups_day;
    }
}