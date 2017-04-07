package com.flyrui.infoshare.train.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class InfoTrainAudit implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 培训审核id */
	private Integer audit_id;

	/** 培训id */
	private String train_id;

	/** 1 审核通过 0审核不通过 */
	private String audit_result;

	/** 审核意见 */
	private String audit_comments;

	/** 创建日期 */
	private Date create_date;

	/** 审核人 */
	private String audit_staff;


	public Integer getAudit_id() {
		return this.audit_id;
	}

	public void setAudit_id(Integer audit_id) {
		this.audit_id = audit_id;
	}

	public String getTrain_id() {
		return this.train_id;
	}

	public void setTrain_id(String train_id) {
		this.train_id = train_id;
	}

	public String getAudit_result() {
		return this.audit_result;
	}

	public void setAudit_result(String audit_result) {
		this.audit_result = audit_result;
	}

	public String getAudit_comments() {
		return this.audit_comments;
	}

	public void setAudit_comments(String audit_comments) {
		this.audit_comments = audit_comments;
	}

	public Date getCreate_date() {
		return this.create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getAudit_staff() {
		return this.audit_staff;
	}

	public void setAudit_staff(String audit_staff) {
		this.audit_staff = audit_staff;
	}

}
