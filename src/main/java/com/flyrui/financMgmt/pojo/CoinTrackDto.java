package com.flyrui.financMgmt.pojo;

import java.io.Serializable;
import java.util.Date;

import com.flyrui.common.excel.ExcelAnnotation;

public class CoinTrackDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String log_type;
	
	private String sub_logType;
	
	private Integer user_id;
	
	@ExcelAnnotation(exportName = "银行名称")
	private String account_bank;
	
	@ExcelAnnotation(exportName = "银行账号")
	private String account_id;
	
	@ExcelAnnotation(exportName = "开户支行")
	private String account_bank_brc;
	
	@ExcelAnnotation(exportName = "开户人姓名")
	private String account_name;
	
	@ExcelAnnotation(exportName = "会员编号")
	private String user_code;
	
	@ExcelAnnotation(exportName = "会员名称")
	private String user_name;
	
	private Integer coin_type;
	
	@ExcelAnnotation(exportName = "金额")
	private Double coin_num;
	
	private String create_type;
	
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
	
	private String coin_type_name;
	
	private String create_type_name;
	
	private String balance_comments;
	
	private String goods_order_id;
	
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

	public String getCreate_type_name() {
		return create_type_name;
	}

	public void setCreate_type_name(String create_type_name) {
		this.create_type_name = create_type_name;
	}

	public String getAccount_bank() {
		return account_bank;
	}

	public void setAccount_bank(String account_bank) {
		this.account_bank = account_bank;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getCoin_type_name() {
		return coin_type_name;
	}

	public void setCoin_type_name(String coin_type_name) {
		this.coin_type_name = coin_type_name;
	}

	public String getAccount_bank_brc() {
		return account_bank_brc;
	}

	public void setAccount_bank_brc(String account_bank_brc) {
		this.account_bank_brc = account_bank_brc;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getBalance_comments() {
		return balance_comments;
	}

	public void setBalance_comments(String balance_comments) {
		this.balance_comments = balance_comments;
	}

	public String getGoods_order_id() {
		return goods_order_id;
	}

	public void setGoods_order_id(String goods_order_id) {
		this.goods_order_id = goods_order_id;
	}

	public String getLog_type() {
		return log_type;
	}

	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}

	public String getSub_logType() {
		return sub_logType;
	}

	public void setSub_logType(String sub_logType) {
		this.sub_logType = sub_logType;
	}	
}
