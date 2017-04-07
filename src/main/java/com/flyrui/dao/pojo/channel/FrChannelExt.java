package com.flyrui.dao.pojo.channel;

import java.io.Serializable;

public class FrChannelExt implements Serializable {
    private Integer channel_id;

    private String channel_name;

    private Byte final_step;

    private Byte after_check;

    private String is_static_channel;

    private String is_static_content;

    private String is_access_by_dir;

    private String is_list_child;

    private Integer page_size;

    private String channel_rule;

    private String content_rule;

    private String link;

    private String tpl_channel;

    private String tpl_content;

    private String title_img;

    private String content_img;

    private Boolean has_title_img;

    private Boolean has_content_img;

    private Integer title_img_width;

    private Integer title_img_height;

    private Integer content_img_width;

    private Integer content_img_height;

    private Integer comment_control;

    private Boolean allow_updown;

    private Boolean is_blank;

    private String title;

    private String keywords;

    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(Integer channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name == null ? null : channel_name.trim();
    }

    public Byte getFinal_step() {
        return final_step;
    }

    public void setFinal_step(Byte final_step) {
        this.final_step = final_step;
    }

    public Byte getAfter_check() {
        return after_check;
    }

    public void setAfter_check(Byte after_check) {
        this.after_check = after_check;
    }

    public String getIs_static_channel() {
        return is_static_channel;
    }

    public void setIs_static_channel(String is_static_channel) {
        this.is_static_channel = is_static_channel == null ? null : is_static_channel.trim();
    }

    public String getIs_static_content() {
        return is_static_content;
    }

    public void setIs_static_content(String is_static_content) {
        this.is_static_content = is_static_content == null ? null : is_static_content.trim();
    }

    public String getIs_access_by_dir() {
        return is_access_by_dir;
    }

    public void setIs_access_by_dir(String is_access_by_dir) {
        this.is_access_by_dir = is_access_by_dir == null ? null : is_access_by_dir.trim();
    }

    public String getIs_list_child() {
        return is_list_child;
    }

    public void setIs_list_child(String is_list_child) {
        this.is_list_child = is_list_child == null ? null : is_list_child.trim();
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public String getChannel_rule() {
        return channel_rule;
    }

    public void setChannel_rule(String channel_rule) {
        this.channel_rule = channel_rule == null ? null : channel_rule.trim();
    }

    public String getContent_rule() {
        return content_rule;
    }

    public void setContent_rule(String content_rule) {
        this.content_rule = content_rule == null ? null : content_rule.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getTpl_channel() {
        return tpl_channel;
    }

    public void setTpl_channel(String tpl_channel) {
        this.tpl_channel = tpl_channel == null ? null : tpl_channel.trim();
    }

    public String getTpl_content() {
        return tpl_content;
    }

    public void setTpl_content(String tpl_content) {
        this.tpl_content = tpl_content == null ? null : tpl_content.trim();
    }

    public String getTitle_img() {
        return title_img;
    }

    public void setTitle_img(String title_img) {
        this.title_img = title_img == null ? null : title_img.trim();
    }

    public String getContent_img() {
        return content_img;
    }

    public void setContent_img(String content_img) {
        this.content_img = content_img == null ? null : content_img.trim();
    }

    public Boolean getHas_title_img() {
        return has_title_img;
    }

    public void setHas_title_img(Boolean has_title_img) {
        this.has_title_img = has_title_img;
    }

    public Boolean getHas_content_img() {
        return has_content_img;
    }

    public void setHas_content_img(Boolean has_content_img) {
        this.has_content_img = has_content_img;
    }

    public Integer getTitle_img_width() {
        return title_img_width;
    }

    public void setTitle_img_width(Integer title_img_width) {
        this.title_img_width = title_img_width;
    }

    public Integer getTitle_img_height() {
        return title_img_height;
    }

    public void setTitle_img_height(Integer title_img_height) {
        this.title_img_height = title_img_height;
    }

    public Integer getContent_img_width() {
        return content_img_width;
    }

    public void setContent_img_width(Integer content_img_width) {
        this.content_img_width = content_img_width;
    }

    public Integer getContent_img_height() {
        return content_img_height;
    }

    public void setContent_img_height(Integer content_img_height) {
        this.content_img_height = content_img_height;
    }

    public Integer getComment_control() {
        return comment_control;
    }

    public void setComment_control(Integer comment_control) {
        this.comment_control = comment_control;
    }

    public Boolean getAllow_updown() {
        return allow_updown;
    }

    public void setAllow_updown(Boolean allow_updown) {
        this.allow_updown = allow_updown;
    }

    public Boolean getIs_blank() {
        return is_blank;
    }

    public void setIs_blank(Boolean is_blank) {
        this.is_blank = is_blank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}