package com.flyrui.financMgmt.pojo;

import java.io.Serializable;
import java.util.Date;

import com.flyrui.common.excel.ExcelAnnotation;

public class AccoutInfoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer user_id;
	
	private String user_code;
	
	private String user_name;
	
	private Double bonus_coin;
	
	private Double elect_coin;
	
	private Double reconsmp_coin;
	
	private String account_bank;
	
	private String account_bank_brc;
	
	private String account_id;
	
	private String account_name;
	
	private String comments;
	
	private Double bonusact_sum;
	
	private Double reconsmpact_sum;
	
	private Double cash_coin;

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

	public Double getBonus_coin() {
		return bonus_coin;
	}

	public void setBonus_coin(Double bonus_coin) {
		this.bonus_coin = bonus_coin;
	}

	public Double getElect_coin() {
		return elect_coin;
	}

	public void setElect_coin(Double elect_coin) {
		this.elect_coin = elect_coin;
	}

	public Double getReconsmp_coin() {
		return reconsmp_coin;
	}

	public void setReconsmp_coin(Double reconsmp_coin) {
		this.reconsmp_coin = reconsmp_coin;
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

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getBonusact_sum() {
		return bonusact_sum;
	}

	public void setBonusact_sum(Double bonusact_sum) {
		this.bonusact_sum = bonusact_sum;
	}

	public Double getReconsmpact_sum() {
		return reconsmpact_sum;
	}

	public void setReconsmpact_sum(Double reconsmpact_sum) {
		this.reconsmpact_sum = reconsmpact_sum;
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

	public String getAccount_bank_brc() {
		return account_bank_brc;
	}

	public void setAccount_bank_brc(String account_bank_brc) {
		this.account_bank_brc = account_bank_brc;
	}

	public Double getCash_coin() {
		return cash_coin;
	}

	public void setCash_coin(Double cash_coin) {
		this.cash_coin = cash_coin;
	}
	
}
