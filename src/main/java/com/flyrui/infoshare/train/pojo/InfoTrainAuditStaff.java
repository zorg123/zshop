package com.flyrui.infoshare.train.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class InfoTrainAuditStaff implements Serializable {

	private static final long serialVersionUID = 1L;

	/** id */
	private Integer id;

	/**  */
	private String deparment_id;

	/**  */
	private String user_id;

	/** 1 有效 0无效 */
	private String state;

	/** 创建时间 */
	private Date create_date;

	/** 操作员工 */
	private String oper_staff;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeparment_id() {
		return this.deparment_id;
	}

	public void setDeparment_id(String deparment_id) {
		this.deparment_id = deparment_id;
	}

	public String getUser_id() {
		return this.user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public String getOper_staff() {
		return this.oper_staff;
	}

	public void setOper_staff(String oper_staff) {
		this.oper_staff = oper_staff;
	}

}
