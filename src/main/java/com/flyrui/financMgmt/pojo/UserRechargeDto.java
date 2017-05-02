package com.flyrui.financMgmt.pojo;

import java.io.Serializable;
import java.util.Date;

import com.flyrui.common.excel.ExcelAnnotation;

public class UserRechargeDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ExcelAnnotation(exportName = "申请时间")
	private Date create_time;
	private String rec_code;
	@ExcelAnnotation(exportName = "充值银行")
	private String rec_bankname;
	@ExcelAnnotation(exportName = "充值卡号")
	private String rec_bankid;
	@ExcelAnnotation(exportName = "申请金额 ")
	private String rec_num;
	@ExcelAnnotation(exportName = "充值留言 ")
	private String rec_message;
	private Integer user_id;
	@ExcelAnnotation(exportName = "会员编号 ")
	private String user_code;
	@ExcelAnnotation(exportName = "会员名称 ")
	private String user_name;
	@ExcelAnnotation(exportName = "是否充值")
	private String state_name;
	@ExcelAnnotation(exportName = "充值金额")
	private String coin_num;
	@ExcelAnnotation(exportName = "充值时间")
	private Date rec_time;
	@ExcelAnnotation(exportName = "操作人")
	private String oper_user_name;
	private String start_time;
	private String end_time;
	public String getRec_code() {
		return rec_code;
	}
	public void setRec_code(String rec_code) {
		this.rec_code = rec_code;
	}
	public String getRec_bankname() {
		return rec_bankname;
	}
	public void setRec_bankname(String rec_bankname) {
		this.rec_bankname = rec_bankname;
	}
	public String getRec_bankid() {
		return rec_bankid;
	}
	public void setRec_bankid(String rec_bankid) {
		this.rec_bankid = rec_bankid;
	}
	public String getRec_num() {
		return rec_num;
	}
	public void setRec_num(String rec_num) {
		this.rec_num = rec_num;
	}
	public String getRec_message() {
		return rec_message;
	}
	public void setRec_message(String rec_message) {
		this.rec_message = rec_message;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public String getCoin_num() {
		return coin_num;
	}
	public void setCoin_num(String coin_num) {
		this.coin_num = coin_num;
	}
	public Date getRec_time() {
		return rec_time;
	}
	public void setRec_time(Date rec_time) {
		this.rec_time = rec_time;
	}
	public String getOper_user_name() {
		return oper_user_name;
	}
	public void setOper_user_name(String oper_user_name) {
		this.oper_user_name = oper_user_name;
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
}
