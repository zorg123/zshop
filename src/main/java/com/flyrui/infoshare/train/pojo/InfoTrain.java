package com.flyrui.infoshare.train.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class InfoTrain implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 培训id */
	private String train_id;

	/** 记录顺序 */
	private Integer seq;

	/** 培训简略名字 */
	private String train_name;

	/** 培训标题 */
	private String train_title;

	/** 培训类型 1 一般培训 */
	private String train_type;

	/** 培训内容 */
	private String train_content;

	/** 培训开始时间 */
	private Date train_start;

	/** 培训结束时间 */
	private Date train_end;

	/** 培训参与人员 */
	private String train_peoples;

	/** 培训部门 */
	private String department;

	/** 培训参与人员数量 */
	private Integer people_amount;

	/** 培训状态 0 作废 1 已审核 2 待审核 3 审核不通过 */
	private String state;

	/** 记录创建时间 */
	private Date create_date;

	/** 操作员工 */
	private String oper_staff;

	/** 审核员工 */
	private String audit_staff;
	
	private String train_type_name;
	
	private String department_name;
	
	private String audit_staff_name;
	
	private String train_date_start;
	
	private String train_date_end;

	public String getTrain_id() {
		return this.train_id;
	}

	public void setTrain_id(String train_id) {
		this.train_id = train_id;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getTrain_name() {
		return this.train_name;
	}

	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}

	public String getTrain_title() {
		return this.train_title;
	}

	public void setTrain_title(String train_title) {
		this.train_title = train_title;
	}

	public String getTrain_type() {
		return this.train_type;
	}

	public void setTrain_type(String train_type) {
		this.train_type = train_type;
	}

	public String getTrain_content() {
		return this.train_content;
	}

	public void setTrain_content(String train_content) {
		this.train_content = train_content;
	}

	public Date getTrain_start() {
		return this.train_start;
	}

	public void setTrain_start(Date train_start) {
		this.train_start = train_start;
	}

	public Date getTrain_end() {
		return this.train_end;
	}

	public void setTrain_end(Date train_end) {
		this.train_end = train_end;
	}

	public String getTrain_peoples() {
		return this.train_peoples;
	}

	public void setTrain_peoples(String train_peoples) {
		this.train_peoples = train_peoples;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getPeople_amount() {
		return this.people_amount;
	}

	public void setPeople_amount(Integer people_amount) {
		this.people_amount = people_amount;
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

	public String getAudit_staff() {
		return this.audit_staff;
	}

	public void setAudit_staff(String audit_staff) {
		this.audit_staff = audit_staff;
	}

	public String getTrain_type_name() {
		return train_type_name;
	}

	public void setTrain_type_name(String train_type_name) {
		this.train_type_name = train_type_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getAudit_staff_name() {
		return audit_staff_name;
	}

	public void setAudit_staff_name(String audit_staff_name) {
		this.audit_staff_name = audit_staff_name;
	}

	public String getTrain_date_start() {
		return train_date_start;
	}

	public void setTrain_date_start(String train_date_start) {
		this.train_date_start = train_date_start;
	}

	public String getTrain_date_end() {
		return train_date_end;
	}

	public void setTrain_date_end(String train_date_end) {
		this.train_date_end = train_date_end;
	}
	
	

}
