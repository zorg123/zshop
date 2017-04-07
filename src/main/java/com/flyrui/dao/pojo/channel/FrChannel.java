package com.flyrui.dao.pojo.channel;

import java.io.Serializable;
import java.util.List;

public class FrChannel  extends FrChannelExt implements Serializable{
    private Integer channel_id;

    private Integer model_id;

    private Integer site_id;

    private Integer parent_id;

    private String channel_path;

    private Integer priority;

    private Boolean has_content;

    private Boolean is_display;
    
    List<FrChannel> subChannelList ;

    private static final long serialVersionUID = 1L;

    public Integer getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(Integer channel_id) {
        this.channel_id = channel_id;
    }

    public Integer getModel_id() {
        return model_id;
    }

    public void setModel_id(Integer model_id) {
        this.model_id = model_id;
    }

    public Integer getSite_id() {
        return site_id;
    }

    public void setSite_id(Integer site_id) {
        this.site_id = site_id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getChannel_path() {
        return channel_path;
    }

    public void setChannel_path(String channel_path) {
        this.channel_path = channel_path == null ? null : channel_path.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getHas_content() {
        return has_content;
    }

    public void setHas_content(Boolean has_content) {
        this.has_content = has_content;
    }

    public Boolean getIs_display() {
        return is_display;
    }

    public void setIs_display(Boolean is_display) {
        this.is_display = is_display;
    }

	public List<FrChannel> getSubChannelList() {
		return subChannelList;
	}

	public void setSubChannelList(List<FrChannel> subChannelList) {
		this.subChannelList = subChannelList;
	}    
    
}