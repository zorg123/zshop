package com.flyrui.dao.pojo.channel;

import java.io.Serializable;
import java.util.Date;

public class FrContentExt implements Serializable {
    private Integer content_id;

    private String title;

    private String short_title;

    private String author;

    private String origin;

    private String origin_url;

    private String description;

    private Date release_date;

    private String media_path;

    private String media_type;

    private String title_color;

    private Boolean is_bold;

    private String title_img;

    private String content_img;

    private String type_img;

    private String link;

    private String tpl_content;

    private Boolean need_regenerate;

    private static final long serialVersionUID = 1L;

    public Integer getContent_id() {
        return content_id;
    }

    public void setContent_id(Integer content_id) {
        this.content_id = content_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getShort_title() {
        return short_title;
    }

    public void setShort_title(String short_title) {
        this.short_title = short_title == null ? null : short_title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getOrigin_url() {
        return origin_url;
    }

    public void setOrigin_url(String origin_url) {
        this.origin_url = origin_url == null ? null : origin_url.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getMedia_path() {
        return media_path;
    }

    public void setMedia_path(String media_path) {
        this.media_path = media_path == null ? null : media_path.trim();
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type == null ? null : media_type.trim();
    }

    public String getTitle_color() {
        return title_color;
    }

    public void setTitle_color(String title_color) {
        this.title_color = title_color == null ? null : title_color.trim();
    }

    public Boolean getIs_bold() {
        return is_bold;
    }

    public void setIs_bold(Boolean is_bold) {
        this.is_bold = is_bold;
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

    public String getType_img() {
        return type_img;
    }

    public void setType_img(String type_img) {
        this.type_img = type_img == null ? null : type_img.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getTpl_content() {
        return tpl_content;
    }

    public void setTpl_content(String tpl_content) {
        this.tpl_content = tpl_content == null ? null : tpl_content.trim();
    }

    public Boolean getNeed_regenerate() {
        return need_regenerate;
    }

    public void setNeed_regenerate(Boolean need_regenerate) {
        this.need_regenerate = need_regenerate;
    }
}