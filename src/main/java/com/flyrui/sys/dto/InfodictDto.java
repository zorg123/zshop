package com.flyrui.sys.dto;

import java.io.Serializable;
import java.util.Date;

public class InfodictDto implements Serializable{
	private Integer dict_id;
	private String dict_name;
	private String dict_type;
	private String dict_code;
	private String dict_value;
	private String dict_desc;
	private Integer order_id;
	private String up_dict_type;
	private String state;
	private Date create_date;
	public Integer getDict_id() {
		return dict_id;
	}
	public void setDict_id(Integer dict_id) {
		this.dict_id = dict_id;
	}
	public String getDict_name() {
		return dict_name;
	}
	public void setDict_name(String dict_name) {
		this.dict_name = dict_name;
	}
	public String getDict_type() {
		return dict_type;
	}
	public void setDict_type(String dict_type) {
		this.dict_type = dict_type;
	}
	public String getDict_code() {
		return dict_code;
	}
	public void setDict_code(String dict_code) {
		this.dict_code = dict_code;
	}
	public String getDict_value() {
		return dict_value;
	}
	public void setDict_value(String dict_value) {
		this.dict_value = dict_value;
	}
	public String getDict_desc() {
		return dict_desc;
	}
	public void setDict_desc(String dict_desc) {
		this.dict_desc = dict_desc;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getUp_dict_type() {
		return up_dict_type;
	}
	public void setUp_dict_type(String up_dict_type) {
		this.up_dict_type = up_dict_type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
}
