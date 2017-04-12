package com.flyrui.financMgmt.pojo;

import java.io.Serializable;
import java.util.Date;

import com.flyrui.common.excel.ExcelAnnotation;

public class CoinTrackDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer user_id;
	
	private String user_code;
	
	private String user_name;
	
	private Integer coin_type;
	
	private Float coin_num;
	
	private String create_type;
	
	private Integer oper_user_id;
	
	private String oper_user_name;
	
	private Integer order_id;
	
	private Date create_time;
	
	private String file_info;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getCoin_type() {
		return coin_type;
	}

	public void setCoin_type(Integer coin_type) {
		this.coin_type = coin_type;
	}

	public Float getCoin_num() {
		return coin_num;
	}

	public void setCoin_num(Float coin_num) {
		this.coin_num = coin_num;
	}

	public String getCreate_type() {
		return create_type;
	}

	public void setCreate_type(String create_type) {
		this.create_type = create_type;
	}

	public Integer getOper_user_id() {
		return oper_user_id;
	}

	public void setOper_user_id(Integer oper_user_id) {
		this.oper_user_id = oper_user_id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getFile_info() {
		return file_info;
	}

	public void setFile_info(String file_info) {
		this.file_info = file_info;
	}
	
	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOper_user_name() {
		return oper_user_name;
	}

	public void setOper_user_name(String oper_user_name) {
		this.oper_user_name = oper_user_name;
	}
	
}
