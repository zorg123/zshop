package com.flyrui.goods.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class GoodsCatalog implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 商品目录id */
	private String catalog_id;

	/** 商品名称 */
	private String catalog_name;

	/** 商品描述 */
	private String catalog_desc;

	/** 状态 1 有效 0 无效 */
	private String state;

	/** 创建日期 */
	private Date create_date;

	/** 创建人id */
	private String create_user_id;

	/** 上级商品目录id */
	private String up_catalog_id;

	/** 商品排序id */
	private Integer order_id;


	public String getCatalog_id() {
		return this.catalog_id;
	}

	public void setCatalog_id(String catalog_id) {
		this.catalog_id = catalog_id;
	}

	public String getCatalog_name() {
		return this.catalog_name;
	}

	public void setCatalog_name(String catalog_name) {
		this.catalog_name = catalog_name;
	}

	public String getCatalog_desc() {
		return this.catalog_desc;
	}

	public void setCatalog_desc(String catalog_desc) {
		this.catalog_desc = catalog_desc;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreate_date() {
		return this.create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getCreate_user_id() {
		return this.create_user_id;
	}

	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}

	public String getUp_catalog_id() {
		return this.up_catalog_id;
	}

	public void setUp_catalog_id(String up_catalog_id) {
		this.up_catalog_id = up_catalog_id;
	}

	public Integer getOrder_id() {
		return this.order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

}
