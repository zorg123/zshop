package com.flyrui.dao.pojo.salary;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 *
 * 
 *
 */
public class BusSalaryBase implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 工资表主键 */
	private String salary_id;

	/** 用户id */
	private Integer user_id;
	
	/** 银行账户 **/
	private String bank_account;

	/** 用户code */
	private String user_code;

	/** 用户名字 */
	private String user_name;

	/** 录入时间 */
	private Date salary_schedule;

	/** 人员部门 */
	private String org_name;

	/** 批次部门 */
	private String batch_id;

	/** 创建时间 */
	private Date create_date;

	/** 创建人 */
	private String oper_user_id;
	
	/** 属性信息**/
	private List<BusSalaryExtend> busSalaryExtendList;

	/** 属性的表格形式**/
	private String extend_info;
	
	/** 查询条件的开始时间 */
	private String salary_schedule_start;
	  
	/** 查询条件的结束时间 */
	private String salary_schedule_end;
	
	public String getSalary_id() {
		return this.salary_id;
	}

	public void setSalary_id(String salary_id) {
		this.salary_id = salary_id;
	}

	public Integer getUser_id() {
		return this.user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_code() {
		return this.user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_name() {
		return this.user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Date getSalary_schedule() {
		return this.salary_schedule;
	}

	public void setSalary_schedule(Date salary_schedule) {
		this.salary_schedule = salary_schedule;
	}

	public String getOrg_name() {
		return this.org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getBatch_id() {
		return this.batch_id;
	}

	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}

	public Date getCreate_date() {
		return this.create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getOper_user_id() {
		return this.oper_user_id;
	}

	public void setOper_user_id(String oper_user_id) {
		this.oper_user_id = oper_user_id;
	}

	public List<BusSalaryExtend> getBusSalaryExtendList() {
		return busSalaryExtendList;
	}

	public void setBusSalaryExtendList(List<BusSalaryExtend> busSalaryExtendList) {
		this.busSalaryExtendList = busSalaryExtendList;
	}

	public String getExtend_info() {
		return extend_info;
	}

	public void setExtend_info(String extendInfo) {
		extend_info = extendInfo;
	}

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bankAccount) {
		bank_account = bankAccount;
	}

	public String getSalary_schedule_start() {
		return salary_schedule_start;
	}

	public void setSalary_schedule_start(String salaryScheduleStart) {
		salary_schedule_start = salaryScheduleStart;
	}

	public String getSalary_schedule_end() {
		return salary_schedule_end;
	}

	public void setSalary_schedule_end(String salaryScheduleEnd) {
		salary_schedule_end = salaryScheduleEnd;
	}
}
