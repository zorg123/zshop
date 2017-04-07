package com.flyrui.dao.pojo.salary;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class BusSalaryExtend implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 工资表主键 */
	private String salary_id;

	/** 扩展名字 */
	private String extend_name;

	/** 扩展值 */
	private String extend_value;

	/** 顺序 */
	private Integer order_id;
	
	/** 批次号 */
	private String batch_id;

	/** 创建时间 */
	private Date create_date;


	public String getSalary_id() {
		return this.salary_id;
	}

	public void setSalary_id(String salary_id) {
		this.salary_id = salary_id;
	}

	public String getExtend_name() {
		return this.extend_name;
	}

	public void setExtend_name(String extend_name) {
		this.extend_name = extend_name;
	}

	public String getExtend_value() {
		return this.extend_value;
	}

	public void setExtend_value(String extend_value) {
		this.extend_value = extend_value;
	}

	public Integer getOrder_id() {
		return this.order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Date getCreate_date() {
		return this.create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(String batchId) {
		batch_id = batchId;
	}
	

}
