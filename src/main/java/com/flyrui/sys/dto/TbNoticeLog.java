package com.flyrui.sys.dto;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class TbNoticeLog implements Serializable {

	private static final long serialVersionUID = 1L;

	/**  */
	private Integer log_Id;

	/**  */
	private Integer notice_id;

	/**  */
	private String state;

	/**  */
	private Date create_date;

	/**  */
	private Integer user_id;


	public Integer getLog_Id() {
		return this.log_Id;
	}

	public void setLog_Id(Integer log_Id) {
		this.log_Id = log_Id;
	}

	public Integer getNotice_id() {
		return this.notice_id;
	}

	public void setNotice_id(Integer notice_id) {
		this.notice_id = notice_id;
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

	public Integer getUser_id() {
		return this.user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

}
