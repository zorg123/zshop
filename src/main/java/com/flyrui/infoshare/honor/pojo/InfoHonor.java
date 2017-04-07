package com.flyrui.infoshare.honor.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class InfoHonor implements Serializable {

	private static final long serialVersionUID = 1L;

	/** id */
	private String id;

	/** 记录顺序 */
	private Integer seq;

	/** 名字 */
	private String honor_name;

	/** 获奖单位 */
	private String unit;

	/** 获奖人员 */
	private String honor_peoples;

	/** 获奖时间 */
	private Date honor_date;

	/** 荣耀类型 */
	private String honor_type;

	/** 状态 1 有效 0 失效 */
	private String state;

	/** 创建时间 */
	private Date create_date;


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getHonor_name() {
		return this.honor_name;
	}

	public void setHonor_name(String honor_name) {
		this.honor_name = honor_name;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getHonor_peoples() {
		return this.honor_peoples;
	}

	public void setHonor_peoples(String honor_peoples) {
		this.honor_peoples = honor_peoples;
	}

	public Date getHonor_date() {
		return this.honor_date;
	}

	public void setHonor_date(Date honor_date) {
		this.honor_date = honor_date;
	}

	public String getHonor_type() {
		return this.honor_type;
	}

	public void setHonor_type(String honor_type) {
		this.honor_type = honor_type;
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

}
