package com.flyrui.goods.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class GoodsRevAddr implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 收货人地址id */
	private Integer addr_id;

	/** 所属用户 */
	private String user_id;

	/** 收货人 */
	private String rev_people;

	/** 收货人联系电话 */
	private String rev_link_phone;

	/** 收货人地址 */
	private String rev_addr;

	/** 收货人所在省 */
	private String rev_provice;

	/** 收货人所在地市 */
	private String rev_city;

	/** 收货人所在区县 */
	private String rev_zone;

	/** 收货人地址街道 */
	private String rev_street;

	/** 记录有效标示 1 有效 0 失效 */
	private String state;

	/** 是否默认地址 默认写入的第一个是默认 1 是  0 不是 */
	private String is_default;

	/** 创建时间 */
	private Date create_date;


	public Integer getAddr_id() {
		return this.addr_id;
	}

	public void setAddr_id(Integer addr_id) {
		this.addr_id = addr_id;
	}

	public String getUser_id() {
		return this.user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getRev_people() {
		return this.rev_people;
	}

	public void setRev_people(String rev_people) {
		this.rev_people = rev_people;
	}

	public String getRev_link_phone() {
		return this.rev_link_phone;
	}

	public void setRev_link_phone(String rev_link_phone) {
		this.rev_link_phone = rev_link_phone;
	}

	public String getRev_addr() {
		return this.rev_addr;
	}

	public void setRev_addr(String rev_addr) {
		this.rev_addr = rev_addr;
	}

	public String getRev_provice() {
		return this.rev_provice;
	}

	public void setRev_provice(String rev_provice) {
		this.rev_provice = rev_provice;
	}

	public String getRev_city() {
		return this.rev_city;
	}

	public void setRev_city(String rev_city) {
		this.rev_city = rev_city;
	}

	public String getRev_zone() {
		return this.rev_zone;
	}

	public void setRev_zone(String rev_zone) {
		this.rev_zone = rev_zone;
	}

	public String getRev_street() {
		return this.rev_street;
	}

	public void setRev_street(String rev_street) {
		this.rev_street = rev_street;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIs_default() {
		return this.is_default;
	}

	public void setIs_default(String is_default) {
		this.is_default = is_default;
	}

	public Date getCreate_date() {
		return this.create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

}
