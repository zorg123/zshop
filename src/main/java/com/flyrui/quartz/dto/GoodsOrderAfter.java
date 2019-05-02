package com.flyrui.quartz.dto;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class GoodsOrderAfter implements Serializable {

	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;

	/**  */
	private String user_id;

	/**  */
	private String goods_order_id;

	/**  */
	private Integer buy_amount;

	/** 0 待扫 1 处理 2 完成 -1 错误 */
	private Integer state;

	/**  */
	private Integer error_num;

	/**  */
	private Date create_date;

	/**  */
	private Date state_date;

	/**  */
	private String comments;

	/**  */
	private String after_type;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_id() {
		return this.user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getGoods_order_id() {
		return this.goods_order_id;
	}

	public void setGoods_order_id(String goods_order_id) {
		this.goods_order_id = goods_order_id;
	}

	public Integer getBuy_amount() {
		return this.buy_amount;
	}

	public void setBuy_amount(Integer buy_amount) {
		this.buy_amount = buy_amount;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getError_num() {
		return this.error_num;
	}

	public void setError_num(Integer error_num) {
		this.error_num = error_num;
	}

	public Date getCreate_date() {
		return this.create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getState_date() {
		return this.state_date;
	}

	public void setState_date(Date state_date) {
		this.state_date = state_date;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getAfter_type() {
		return this.after_type;
	}

	public void setAfter_type(String after_type) {
		this.after_type = after_type;
	}

}
