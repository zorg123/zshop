package com.flyrui.financMgmt.pojo;

import java.io.Serializable;
import java.util.Date;

import com.flyrui.common.excel.ExcelAnnotation;

public class CoinTrackDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer user_id;
	
	@ExcelAnnotation(exportName = "会员编号")
	private String user_code;
	
	@ExcelAnnotation(exportName = "会员名称")
	private String user_name;
	
	private Integer coin_type;
	
	@ExcelAnnotation(exportName = "金额")
	private Double coin_num;
	
	private Integer create_type;
	
	private Integer oper_user_id;
	
	private String oper_user_name;
	
	private Integer order_id;
	
	@ExcelAnnotation(exportName = "时间")
	private Date create_time;
	
	private String comments;
	
	private String file_info;
	
	private String start_time;
	
	private String end_time;
	
	private Date oper_time;
	
	@ExcelAnnotation(exportName = "手续费")
	private Double counter_num;
	
	@ExcelAnnotation(exportName = "打款金额")
	private Double act_num;
	
	@ExcelAnnotation(exportName = "流水号")
	private String serial_num;
	
	@ExcelAnnotation(exportName = "是否打款")
	private String apply_state;

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

	public Double getCoin_num() {
		return coin_num;
	}

	public void setCoin_num(Double coin_num) {
		this.coin_num = coin_num;
	}

	public Integer getCreate_type() {
		return create_type;
	}

	public void setCreate_type(Integer create_type) {
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public Date getOper_time() {
		return oper_time;
	}

	public void setOper_time(Date oper_time) {
		this.oper_time = oper_time;
	}

	public Double getCounter_num() {
		return counter_num;
	}

	public void setCounter_num(Double counter_num) {
		this.counter_num = counter_num;
	}

	public Double getAct_num() {
		return act_num;
	}

	public void setAct_num(Double act_num) {
		this.act_num = act_num;
	}

	public String getSerial_num() {
		return serial_num;
	}

	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}

	public String getApply_state() {
		return apply_state;
	}

	public void setApply_state(String apply_state) {
		this.apply_state = apply_state;
	}
	
}