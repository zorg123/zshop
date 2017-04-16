package com.flyrui.financMgmt.pojo;

import java.io.Serializable;
import java.util.Date;

import com.flyrui.common.excel.ExcelAnnotation;

public class BonusActDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date create_time;

	private Double gg_fee;
	
	private Double fd_fee;
	
	private Double re_fee;
	
	private Double act_fee;

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Double getGg_fee() {
		return gg_fee;
	}

	public void setGg_fee(Double gg_fee) {
		this.gg_fee = gg_fee;
	}

	public Double getFd_fee() {
		return fd_fee;
	}

	public void setFd_fee(Double fd_fee) {
		this.fd_fee = fd_fee;
	}

	public Double getRe_fee() {
		return re_fee;
	}

	public void setRe_fee(Double re_fee) {
		this.re_fee = re_fee;
	}

	public Double getAct_fee() {
		return act_fee;
	}

	public void setAct_fee(Double act_fee) {
		this.act_fee = act_fee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
