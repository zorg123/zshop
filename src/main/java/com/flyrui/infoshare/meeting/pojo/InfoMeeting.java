package com.flyrui.infoshare.meeting.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class InfoMeeting implements Serializable {

	private static final long serialVersionUID = 1L;

	/** id */
	private String id;

	/** 记录顺序 */
	private Integer seq;

	/** 标题 */
	private String titile;

	/** 内容 */
	private String content;

	/** 会议时间 */
	private Date meeting_date;

	/** 会议参加人员 */
	private String peoples;

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

	public String getTitile() {
		return this.titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getMeeting_date() {
		return this.meeting_date;
	}

	public void setMeeting_date(Date meeting_date) {
		this.meeting_date = meeting_date;
	}

	public String getPeoples() {
		return this.peoples;
	}

	public void setPeoples(String peoples) {
		this.peoples = peoples;
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
