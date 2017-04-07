package com.flyrui.infoshare.staff.pojo;

import java.io.Serializable;
import java.util.Date;

import com.flyrui.common.excel.ExcelAnnotation;


/**
 *
 * 
 *
 */
public class InfoUserExt extends CoreUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 员工id,和core_user表对应 */
	private String user_id;

	/** 性别 */
	@ExcelAnnotation(exportName = "性别")
	private String sex;

	/** 房间号 */
	private String office_room;

	/** 政治面貌 */
	@ExcelAnnotation(exportName = "政治面貌")
	private String political_status;

	/** 参加工作时间 */
	@ExcelAnnotation(exportName = "参加工作日期")
	private Date work_date;

	/** 进入时间 */
	@ExcelAnnotation(exportName = "进入时间")
	private Date join_date;

	/** 学历 */
	@ExcelAnnotation(exportName = "学历")
	private String education;

	/** 学位 */
	@ExcelAnnotation(exportName = "学位")
	private String degree;

	/** 职位 */
	@ExcelAnnotation(exportName = "职务名称")
	private String job_title;

	/** 享受待遇级别 */
	@ExcelAnnotation(exportName = "享受待遇级别")
	private String job_level;

	/** 任职时间 */
	@ExcelAnnotation(exportName = "任职时间")
	private Date serving_time;

	/** 现级别提拔时间 */
	@ExcelAnnotation(exportName = "现级别提拔时间")
	private Date nowjob_up_time;

	/** 专业技术资格名称 */
	@ExcelAnnotation(exportName = "专业技术资格名称")
	private String qualify_name;

	/** 专业技术级别 */
	@ExcelAnnotation(exportName = "专业技术级别")
	private String qualify_level;

	/** 聘任专业技术岗位等级 */
	@ExcelAnnotation(exportName = "聘任专业技术岗位等级")
	private String appoint_level;

	/** 减员方式 */
	@ExcelAnnotation(exportName = "减员方式")
	private String jyfs;

	/** 减员时间 */
	@ExcelAnnotation(exportName = "减员时间")
	private Date jysj;

	/** 聘任工人技术职务名称 */
	@ExcelAnnotation(exportName = "聘任工人技术职务名称")
	private String prgrjszwmc;

	/** 创建时间 */
	private Date create_date;

	/** 状态时间 */
	private Date state_date;

	/** 状态  1 有效 0 失效 */
	private String state;

	/** 序号 当前生效的记录序号为0 */
	private Integer seq;

	/** 1 在职 2 离职 */
	private String job_state;

	/** 离职时间 */
	private Date off_job_time;

	/** 离职时间 */
	@ExcelAnnotation(exportName = "身份证号")
	private String id_card;

	public String getUser_id() {
		return this.user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getOffice_room() {
		return this.office_room;
	}

	public void setOffice_room(String office_room) {
		this.office_room = office_room;
	}

	public String getPolitical_status() {
		return this.political_status;
	}

	public void setPolitical_status(String political_status) {
		this.political_status = political_status;
	}

	public Date getWork_date() {
		return this.work_date;
	}

	public void setWork_date(Date work_date) {
		this.work_date = work_date;
	}

	public Date getJoin_date() {
		return this.join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getJob_title() {
		return this.job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getJob_level() {
		return this.job_level;
	}

	public void setJob_level(String job_level) {
		this.job_level = job_level;
	}

	public Date getServing_time() {
		return this.serving_time;
	}

	public void setServing_time(Date serving_time) {
		this.serving_time = serving_time;
	}

	public Date getNowjob_up_time() {
		return this.nowjob_up_time;
	}

	public void setNowjob_up_time(Date nowjob_up_time) {
		this.nowjob_up_time = nowjob_up_time;
	}

	public String getQualify_name() {
		return this.qualify_name;
	}

	public void setQualify_name(String qualify_name) {
		this.qualify_name = qualify_name;
	}

	public String getQualify_level() {
		return this.qualify_level;
	}

	public void setQualify_level(String qualify_level) {
		this.qualify_level = qualify_level;
	}

	public String getAppoint_level() {
		return this.appoint_level;
	}

	public void setAppoint_level(String appoint_level) {
		this.appoint_level = appoint_level;
	}

	public String getJyfs() {
		return this.jyfs;
	}

	public void setJyfs(String jyfs) {
		this.jyfs = jyfs;
	}

	public Date getJysj() {
		return this.jysj;
	}

	public void setJysj(Date jysj) {
		this.jysj = jysj;
	}

	public String getPrgrjszwmc() {
		return this.prgrjszwmc;
	}

	public void setPrgrjszwmc(String prgrjszwmc) {
		this.prgrjszwmc = prgrjszwmc;
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getJob_state() {
		return this.job_state;
	}

	public void setJob_state(String job_state) {
		this.job_state = job_state;
	}

	public Date getOff_job_time() {
		return this.off_job_time;
	}

	public void setOff_job_time(Date off_job_time) {
		this.off_job_time = off_job_time;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
    
	
}
