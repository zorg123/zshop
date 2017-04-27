package com.flyrui.financMgmt.pojo;

import java.io.Serializable;
import java.util.Date;

import com.flyrui.common.excel.ExcelAnnotation;

public class BonusRecDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@ExcelAnnotation(exportName = "会员编号")
	private String user_code;
	
	@ExcelAnnotation(exportName = "会员名称")
	private String user_name;
	
	@ExcelAnnotation(exportName = "金额")
	private Double coin_num;
	
	@ExcelAnnotation(exportName = "时间")
	private Date create_time;
	
	@ExcelAnnotation(exportName = "充值人名称")
	private String oper_user_name;
	
	private String file_info;

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

	public Double getCoin_num() {
		return coin_num;
	}

	public void setCoin_num(Double coin_num) {
		this.coin_num = coin_num;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getOper_user_name() {
		return oper_user_name;
	}

	public void setOper_user_name(String oper_user_name) {
		this.oper_user_name = oper_user_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFile_info() {
		return file_info;
	}

	public void setFile_info(String file_info) {
		this.file_info = file_info;
	}
	
}
